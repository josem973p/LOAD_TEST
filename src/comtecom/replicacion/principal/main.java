/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comtecom.replicacion.principal;

import comtecom.replicacion.conexiones.Conexion;
import comtecom.replicacion.tablas.VENTA_registro_salida_corrida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;


/**
 *
 * @author jose1
 */
public class main {
    public static void main(String[] args) throws SQLException {
      
     //   Conexion c = new Conexion();
      //  c.getConnection();
  //String login = args[0];
   //  String clave = args[1];
   // String url_args = args[2];
     
   //  String url = "jdbc:oracle:thin:@"; 
   //  url=url.concat(url_args);
     
       // System.out.println(url);
      
          
          
           VENTA_registro_salida_corrida h1 = new VENTA_registro_salida_corrida();
               VENTA_registro_salida_corrida h2 = new VENTA_registro_salida_corrida();
               VENTA_registro_salida_corrida h3 = new VENTA_registro_salida_corrida();
               VENTA_registro_salida_corrida h4 = new VENTA_registro_salida_corrida();
               
               
                
               h1.start();
               h2.start();
               h3.start();
               h4.start();
    
    
         /**
       Conexion c = new Conexion();

        Connection con = null;
        try {
            con = c.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        PreparedStatement pst = null;

       // String sql = "insert into hr.prueba(id,nombre) VALUES(HR.PRUEBA_SEC.NEXTVAL,?)";
        //String sql = "insert into hr.prueba(id,nombre) VALUES(1,'PEPE')";
        String sql = "insert into HR.REGISTRO_SALIDA_CORRIDA (REGISTROSALIDACORRIDA_ID, CORRIDA_ID, FECCORRIDA, HORACORRIDA, CLASESERVICIO_ID, MARCA_ID, ORIGENTRAMO_ID, DESTINOCORRIDA_ID, FECHORSALIDATRAMO, FECHORSALIDAINFORMADA, REGIONCORRIDA_ID, CAUSAIMPUNTUALIDAD_ID, DESCCOMENTARIO, INDEDICION, USUARIO_ID, FECHORACT, STATUS, CVEPUNTOVENTA, DESCTIPOSERVICIO, INDPUNTUALIDAD, SISTEMAREGISTRO_ID) values (HR.PRUEBA_SEC.NEXTVAL, 5, '22/12/2007', '19/04/2005', 9, 2, 5, 7, '12/08/2020', '15/04/2021', 6, 5, 'd', 5, 2, '15/09/2020', 1, 'a', 'b', 'a', 5)";
      //  String commit = "commit";

        try {
            pst= con.prepareStatement(sql);

           // for (int i = 0; i < 1000; i++) {

              //  pst.setString(1, "pepe");

                //  if (i==100000 ||i==200000 || i==300000  || i==400000 ) {
             //   System.out.println(i);
                // }
                System.out.println("estoy aqui");
                pst.execute();
                // con.commit();
          //  }
            con.commit();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        **/
    }
   
          

    

    }
      

