/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comtecom.replicacion.transacciones;

import comtecom.replicacion.Data.CreateSqlStatement;
import comtecom.replicacion.conexiones.Conexion;
import comtecom.replicacion.tablas.VENTA_registro_salida_corrida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author jose1
 */
public class Hilos extends Thread {

    CreateSqlStatement statement = new CreateSqlStatement();

    static int n_registros;
    static String schema;
    static String tabla;
    static String pk;
    static String UNIQUE;
    static int num_updates;
    static int num_deletes;
    Connection con;

    PreparedStatement pst = null;
    static String sql;
    static String Updatesql;
    //System.out.println(Updatesql);
    static String Deletesql;
    static StringBuilder insertsql = new StringBuilder();
    static String newSql;

    public Hilos(int n_registros, String schema, String tabla, String pk, String UNIQUE, int num_updates, int num_deletes) throws SQLException {
        this.con = Conexion.getConnection();
        this.n_registros = n_registros;
        this.schema = schema;
        this.tabla = tabla;
        this.pk = pk;
        this.UNIQUE = UNIQUE;
        this.num_updates = num_updates;
        this.num_deletes = num_deletes;

    }

    public Hilos() throws SQLException {
        this.con = Conexion.getConnection();

    }

    int registroXhilo = Math.round(this.n_registros / 4);

    public void generasql() {
        sql = statement.Statement(schema, tabla, pk, UNIQUE);
        Updatesql = statement.UpdateStatement(schema, tabla, pk, num_updates);
        //System.out.println(Updatesql);
        Deletesql = statement.DeleteStatement(schema, tabla, pk, num_deletes);
        for (int i = 0; i < 10; i++) {
            insertsql.append(" " + sql + " ");
        }
        newSql = insertsql.toString();
        // System.out.println("nuevo insert ->"+newSql);
    }

    @Override
    public void run() {
        

        long TInicio, TFin, tiempo;           //Para determinar el tiempo
        TInicio = System.currentTimeMillis();

        //  System.out.println("registros por hilo" + this.registroXhilo);
        // System.out.println(Deletesql);
        //    System.out.println(this.n_registros);
        int n = 1000;
        int pinta = 1000;

        try {
            System.out.println(sql);
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
            for (int i = 0; i < this.registroXhilo; i++) {
                //  if (i == 50000 || i == 100000 || i == 150000 || i == 200000 || i == 250000 || i == 300000 || i == 350000 || i == 400000) {
                if (i % pinta == 0) {
                    System.out.println(i);

                }

                //   }
                pst.execute();

                if (i % n == 0) {
                    con.commit();
                }
            }

            pst = (OraclePreparedStatement) con.prepareStatement(Updatesql);
            pst.execute();
            pst = (OraclePreparedStatement) con.prepareStatement(Deletesql);
            pst.execute();
            con.commit();
            pst.close();

        } catch (SQLException e) {
            try {
                con.commit();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(e);
        }

        

        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución  por hilo en segundos ->: " + (tiempo/1000));
    }

}
