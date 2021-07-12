package comtecom.replicacion.dynamic;

import comtecom.replicacion.conexiones.Conexion;
import comtecom.replicacion.tablas.VENTA_registro_salida_corrida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author jose1
 */
public class TableMapper {

    public List DataTable(String schema,String tabla) {

        List tableColumns = new ArrayList();

        Connection con = null;
        try {
            con = Conexion.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VENTA_registro_salida_corrida.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement pst = null;
        Statement st = null;
        ResultSet rs = null;
        
        StringBuilder query = new StringBuilder();
        query.append("select column_name, data_type, data_length from all_tab_columns where owner='");
        query.append(schema+"'"+" and table_name='"+tabla+"'");
        System.out.println(query);
        String sql= query.toString();

     //   String sql = "select column_name, data_type, data_length from all_tab_columns where owner='HR' and table_name='REGISTRO_SALIDA_CORRIDA'";

        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                tableColumns.add(new TableAttributes(rs.getString(1), rs.getString(2), rs.getInt(3)));

            }

         //   System.out.println(tableColumns.size());
         //   System.out.println(tableColumns.get(0).toString());
          //  System.out.println(tableColumns.get(1).toString());

            rs.close();
            con.commit();

         //   System.out.println(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return tableColumns;
    }

}
