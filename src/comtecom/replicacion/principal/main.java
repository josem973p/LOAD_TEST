
package comtecom.replicacion.principal;

import comtecom.replicacion.Data.CreateSqlStatement;
import comtecom.replicacion.conexiones.Conexion;
import comtecom.replicacion.dynamic.TableMapper;
import comtecom.replicacion.tablas.VENTA_registro_salida_corrida;
import comtecom.replicacion.transacciones.Hilos;
import java.io.IOException;
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

    public static void main(String[] args) throws SQLException, IOException {
        
        
        
        ConfigFile.loadConfig("../conf.txt");
        
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
        System.out.println("shema: ");
        String schema = entrada.next();
        System.out.println("tabla");
        String tabla = entrada.next();
        System.out.println("PK");
        String pk = entrada.next();
        System.out.println("UNIQUE");
        String UNIQUE = entrada.next();
        System.out.println("num updates");
        int n_updates  = entrada.nextInt();
        System.out.println("num deletes");
        int n_deletes  = entrada.nextInt();
        
        System.out.println("el esquema es"+schema);
        System.out.println("la tbla es"+ tabla);
        System.out.println("la UNICO es"+ UNIQUE);

        Hilos obj = new Hilos(n,schema,tabla,pk,UNIQUE,n_updates,n_deletes);

        Hilos h1 = new Hilos();
      Hilos h2 = new Hilos();
      Hilos h3 = new Hilos();
  //   Hilos h4 = new Hilos();

        h1.start();
     h2.start();
     h3.start();
   //    h4.start();
**/
    
        
    }

}
