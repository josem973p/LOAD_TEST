/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comtecom.replicacion.tablas;

import comtecom.replicacion.conexiones.Conexion;
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
public class VENTA_registro_salida_corrida extends Thread {

    @Override
    public void run() {
     

        Connection con = null;
      try {
            con = Conexion.getConnection();
        } catch (SQLException ex) {
           Logger.getLogger(VENTA_registro_salida_corrida.class.getName()).log(Level.SEVERE, null, ex);
       }

        PreparedStatement pst= null;

      //  String sql = "insert into hr.prueba(id,nombre) VALUES(HR.PRUEBA_SEC.NEXTVAL,?)";
      String sql = "insert into HR.REGISTRO_SALIDA_CORRIDA (REGISTROSALIDACORRIDA_ID, CORRIDA_ID, FECCORRIDA, HORACORRIDA, CLASESERVICIO_ID, MARCA_ID, ORIGENTRAMO_ID, DESTINOCORRIDA_ID, FECHORSALIDATRAMO, FECHORSALIDAINFORMADA, REGIONCORRIDA_ID, CAUSAIMPUNTUALIDAD_ID, DESCCOMENTARIO, INDEDICION, USUARIO_ID, FECHORACT, STATUS, CVEPUNTOVENTA, DESCTIPOSERVICIO, INDPUNTUALIDAD, SISTEMAREGISTRO_ID) values (HR.PRUEBA_SEC.NEXTVAL, 5, '22/12/2007', '19/04/2005', 9, 2, 5, 7, '12/08/2020', '15/04/2021', 6, 5, 'd', 5, 2, '15/09/2020', 1, 'a', 'b', 'a', 5)";
        String commit = "commit";

        try {
          //  pst = (OraclePreparedStatement) con.prepareStatement(sql);
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
            for (int i = 0; i < 500000; i++) {

               // pst.setString(1, "pepe");
               

                 if (i==100000 ||i==200000 || i==300000  || i==400000 ) {
                System.out.println(i);
                 }

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
