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
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author jose1
 */
public class Hilos  extends Thread{
    
    CreateSqlStatement statement = new CreateSqlStatement();
    
    static   int  n_registros;
    static String schema;
    static String tabla;

    public Hilos(int n_registros, String schema, String tabla) {
        this.n_registros = n_registros;
        this.schema=schema;
        this.tabla=tabla;
        System.out.println("ddd"+this.n_registros);
    }
    
     public Hilos() {
     
    }
     
     int registroXhilo=  Math.round(this.n_registros/4);
    
    
     

    @Override
    public void run() {
     
        System.out.println("registros por hilo"+this.registroXhilo);
        System.out.println("el eschem es "+this.schema
                + "ila tabla es"+this.tabla);
        Connection con = null;
      try {
            con = Conexion.getConnection();
        } catch (SQLException ex) {
           Logger.getLogger(VENTA_registro_salida_corrida.class.getName()).log(Level.SEVERE, null, ex);
       }

        PreparedStatement pst= null;

      //  String sql = "insert into hr.prueba(id,nombre) VALUES(HR.PRUEBA_SEC.NEXTVAL,?)";
      //String sql = "insert into HR.REGISTRO_SALIDA_CORRIDA (REGISTROSALIDACORRIDA_ID, CORRIDA_ID, FECCORRIDA, HORACORRIDA, CLASESERVICIO_ID, MARCA_ID, ORIGENTRAMO_ID, DESTINOCORRIDA_ID, FECHORSALIDATRAMO, FECHORSALIDAINFORMADA, REGIONCORRIDA_ID, CAUSAIMPUNTUALIDAD_ID, DESCCOMENTARIO, INDEDICION, USUARIO_ID, FECHORACT, STATUS, CVEPUNTOVENTA, DESCTIPOSERVICIO, INDPUNTUALIDAD, SISTEMAREGISTRO_ID) values (HR.PRUEBA_SEC.NEXTVAL, 5, '22/12/2007', '19/04/2005', 9, 2, 5, 7, '12/08/2020', '15/04/2021', 6, 5, 'd', 5, 2, '15/09/2020', 1, 'a', 'b', 'a', 5)";
      String sql = statement.Statement(schema, tabla);
      
      //String commit = "commit";
        System.out.println(this.n_registros);

        try {
          //  pst = (OraclePreparedStatement) con.prepareStatement(sql);
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
            for (int i = 0; i < this.registroXhilo; i++) {

               // pst.setString(1, "pepe");
               

                // if (i==100000 ||i==200000 || i==300000  || i==400000 ) {
                System.out.println(i);
                
               //  }

                pst.execute();
                // con.commit();
            }
            con.commit();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    
}
