/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comtecom.replicacion.principal;

import comtecom.replicacion.Data.CreateSqlStatement;
import comtecom.replicacion.conexiones.Conexion;
import comtecom.replicacion.dynamic.TableMapper;
import comtecom.replicacion.tablas.VENTA_registro_salida_corrida;
import comtecom.replicacion.transacciones.Hilos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author jose1
 */
public class main {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        String login = args[0];
        String clave = args[1];
        String url_args = args[2];
        String url = "jdbc:oracle:thin:@";
        url = url.concat(url_args);

        // System.out.println(url);
        Conexion c = new Conexion(login, clave, url);

        if (c != null) {
            System.out.println("Conexion Exitosa");
        } else {
            System.out.println("Conexion Fallida");
        }

        System.out.println("Numero de  transacciones: ");
        int n = entrada.nextInt();
        System.out.println("shema: ");
        String schema = entrada.next();
        System.out.println("tabla");
        String tabla = entrada.next();

        System.out.println("el esquema es" + schema);
        System.out.println("la tbla es" + tabla);

        Hilos obj = new Hilos(n, schema, tabla);

        Hilos h1 = new Hilos();
        Hilos h2 = new Hilos();
        Hilos h3 = new Hilos();
        Hilos h4 = new Hilos();
        Hilos h5 = new Hilos();
        Hilos h6 = new Hilos();
        Hilos h7 = new Hilos();
        Hilos h8 = new Hilos();
        Hilos h9 = new Hilos();
        Hilos h10 = new Hilos();
        Hilos h11 = new Hilos();
        Hilos h12 = new Hilos();
        Hilos h13 = new Hilos();
        Hilos h14 = new Hilos();
        Hilos h15 = new Hilos();
        Hilos h16 = new Hilos();
        Hilos h17 = new Hilos();
        Hilos h18 = new Hilos();
        Hilos h19 = new Hilos();
        Hilos h20 = new Hilos();

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();
        h7.start();
        h8.start();
        h9.start();
        h10.start();
        h11.start();
        h12.start();
        h13.start();
        h14.start();
        h15.start();
        h16.start();
        h17.start();
        h18.start();
        h19.start();
        h20.start();
        ;

        /**
         * TableMapper mp = new TableMapper();
         * mp.DataTable("HR","HIST_CAJA_CONCENTRADO"); CreateSqlStatement ce =
         * new CreateSqlStatement(); ce.Statement("HR","HIST_CAJA_CONCENTRADO");
        *
         */
    }

}
