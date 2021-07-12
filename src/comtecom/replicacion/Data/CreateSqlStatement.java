package comtecom.replicacion.Data;

import comtecom.replicacion.dynamic.TableAttributes;
import comtecom.replicacion.dynamic.TableMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jose1
 */
public class CreateSqlStatement {

    public String Statement(String Schema, String tabla) {
        List tableColumns = new ArrayList();
        TableMapper mp = new TableMapper();
        tableColumns = mp.DataTable("HR","HIST_CAJA_CONCENTRADO");
        int longitud= tableColumns.size();

        StringBuilder insertStatement = new StringBuilder();
        // String InsertStatement ="insert into schema.tabla(clumnas) values(valores)";
        insertStatement.append("INSERT INTO");

        insertStatement.append(" " + Schema + "." + tabla + "(");

        int tam = tableColumns.size();
        int i = 0;
        for (Iterator iterator = tableColumns.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            TableAttributes atributos = (TableAttributes) next;

            insertStatement.append(atributos.getColName());
            if (i != longitud-1) {
                insertStatement.append(",");
            }

            i++;

        }
        insertStatement.append(")");

       // System.out.println("tamaño" + tam);
        System.out.println(insertStatement);
        
     //   RamdomValues rand = new RamdomValues();
      //   String cadgenrada =rand.generateString(5);
       //  System.out.println(cadgenrada);
      //   int numero = rand.generateInt(4);
        // System.out.println(numero);
     //    String fecha = rand.generateDate();
        // System.out.println(fecha);
         GenerateValues valores = new GenerateValues();
         String cadenaValores =valores.values();
         System.out.println(cadenaValores);
         
         insertStatement.append(" "+cadenaValores);
         
         String query = insertStatement.toString();
         
         System.out.println(query);
        return query;
        
    }

}