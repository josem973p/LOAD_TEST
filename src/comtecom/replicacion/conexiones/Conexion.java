
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

    private static String login = null;
    private static String clave = null;
    private static String url = null;

    public Conexion(String usuario,String clave , String url) {
        this.login=usuario;
        this.clave=clave;
        this.url =url;
    }
    
    
    
    private static Connection conn = null;
    /**
  private static String login = "system";
    private static String clave = "gswc789qad";
    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl3";
**/
    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            
            if (conn != null) {
                System.out.println("Conexion Exitosa");

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

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Conexion.login = login;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        Conexion.clave = clave;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Conexion.url = url;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        Conexion.conn = conn;
    }

    
}
