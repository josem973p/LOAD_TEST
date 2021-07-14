package comtecom.replicacion.principal;

import comtecom.replicacion.conexiones.Conexion;
import comtecom.replicacion.transacciones.Hilos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author jose1
 */
public class ConfigFile {

    public static void loadConfig(String archivo) throws FileNotFoundException, IOException, SQLException {
        String[] conf = new String[10];
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        int i = 0;
        while ((cadena = b.readLine()) != null) {
            conf[i] = cadena;
            i++;
        }
        b.close();

        String login = conf[0];
        String clave = conf[1];
        String url_args = conf[2];
        String url = "jdbc:oracle:thin:@";
        url = url.concat(url_args);
        String schema = conf[3];
        String tabla = conf[4];
        String pk = conf[5];
        String UNIQUE = conf[6];
        int n = Integer.parseInt(conf[7]);
        int n_updates = Integer.parseInt(conf[8]);
        int n_deletes = Integer.parseInt(conf[9]);

        Conexion c = new Conexion(login, clave, url);
        Hilos obj = new Hilos(n, schema, tabla, pk, UNIQUE, n_updates, n_deletes);
        
      
        Hilos h1 = new Hilos();
        Hilos h2 = new Hilos();
        Hilos h3 = new Hilos();
        Hilos h4 = new Hilos();
       // Hilos h5 = new Hilos();
      //  Hilos h6 = new Hilos();
      //  Hilos h7 = new Hilos();
      //  Hilos h8 = new Hilos();
      //  Hilos h9 = new Hilos();
      //  Hilos h10 = new Hilos();
     //   Hilos h11 = new Hilos();
     //   Hilos h12 = new Hilos();
     //   Hilos h13 = new Hilos();
     //   Hilos h14 = new Hilos();
     //   Hilos h15 = new Hilos();
     //   Hilos h16 = new Hilos();
      //  Hilos h17 = new Hilos();
    //    Hilos h18 = new Hilos();
    //    Hilos h19 = new Hilos();
     //   Hilos h20 = new Hilos();

        h1.start();
        h2.start();
        h3.start();
        h4.start();
     //   h5.start();
      //  h6.start();
    //    h7.start();
    //    h8.start();
      //  h9.start();
    //    h10.start();
    //    h11.start();
     //   h12.start();
     //   h13.start();
     //   h14.start();
     //   h15.start();
     //   h16.start();
     //   h17.start();
     //   h18.start();
       // h19.start();
      //  h20.start();
        System.out.println(n+": Inserts generados en la tabla: "+tabla);
        System.out.println(n_updates+": Updates generados en la tabla: "+tabla);
        System.out.println(n_deletes+": Deletes generados en la tabla: "+tabla);
        
       
        
    }

}
