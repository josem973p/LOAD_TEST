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
        
        try{
        Hilos h1 = new Hilos();
        Hilos h2 = new Hilos();
        Hilos h3 = new Hilos();
        Hilos h4 = new Hilos();

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        System.out.println(n+": Inserts generados en la tabla: "+tabla);
        System.out.println(n_updates+": Updates generados en la tabla: "+tabla);
        System.out.println(n_deletes+": Deletes generados en la tabla: "+tabla);
        
        }catch(Exception e){
            System.out.println("Error al ejecutar la prueba");
        }

        

    }

}
