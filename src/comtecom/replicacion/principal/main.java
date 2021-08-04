
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
import java.util.Calendar;
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
        
        
        
        
        
        ConfigFile.loadConfig("./conf.txt");
        
        
        
        
        
    }

}
