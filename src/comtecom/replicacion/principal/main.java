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
        
        /**
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

        VENTA_registro_salida_corrida obj = new VENTA_registro_salida_corrida(n);

        VENTA_registro_salida_corrida h1 = new VENTA_registro_salida_corrida();
        VENTA_registro_salida_corrida h2 = new VENTA_registro_salida_corrida();
        VENTA_registro_salida_corrida h3 = new VENTA_registro_salida_corrida();
        VENTA_registro_salida_corrida h4 = new VENTA_registro_salida_corrida();

        h1.start();
        h2.start();
        h3.start();
        h4.start();
**/
        TableMapper mp = new TableMapper();
        mp.DataTable("HR","HIST_CAJA_CONCENTRADO");
        CreateSqlStatement ce = new CreateSqlStatement();
        ce.Statement("HR","HIST_CAJA_CONCENTRADO");
        
        
    }

}
