
package comtecom.replicacion.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jose1
 */
public class Conexion {
/**
    private static String login = null;
    private static String clave = null;
    private static String url = null;

    public Conexion(String usuario,String clave , String url) {
        this.login=login;
        this.clave=clave;
        this.url =url;
    }
    **/
    
    private static Connection conn = null;
  private static String login = "system";
    private static String clave = "gswc789qad";
    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl3";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Conecion Exitosa");

            } else {
                System.out.println("Estas bien Wey!! ");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error \n" + e);

        }

        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

}
