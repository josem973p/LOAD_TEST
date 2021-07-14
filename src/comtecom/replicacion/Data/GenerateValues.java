package comtecom.replicacion.Data;

import comtecom.replicacion.dynamic.TableAttributes;
import comtecom.replicacion.dynamic.TableMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jose1
 */
public class GenerateValues {
    Boolean isUnique=false; 

    public String values(String schema, String tabla,String PK,String UNIQUE) {

        List tableColumns = new ArrayList();
        TableMapper mp = new TableMapper();
        RamdomValues random = new RamdomValues();
        tableColumns = mp.DataTable(schema,tabla);

        StringBuilder insertStatement = new StringBuilder();
        // String InsertStatement ="insert into schema.tabla(clumnas) values(valores)";
        insertStatement.append(" VALUES(");

        int tam = tableColumns.size();
        int i = 0;
        int j=0;
        int longitud= tableColumns.size();
        for (Iterator iterator = tableColumns.iterator(); iterator.hasNext();) {

            Object next = iterator.next();
            TableAttributes atributos = (TableAttributes) next;
            String tipo = atributos.getDataType();
            int length = atributos.getLength();

            if (atributos.getColName().equals(PK)) {
                insertStatement.append(schema+".PRUEBA_SEC.NEXTVAL");
                insertStatement.append(",");
                i++;
                continue;
            }

            if(atributos.getColName().equals(UNIQUE) /**&& atributos.getDataType().equals("VARCHAR2")*/){
             isUnique=true;
             
              continue;
                }

            int datatype=0;
            String valor =  null;
            int valorEntero = 0;

            switch (tipo) {

                case "VARCHAR2":

                   valor= random.generateString(length);
                    datatype=1;

                    break; // break es opcional

                case "NUMBER":

                    valorEntero=random.generateInt(length);
                    datatype=2;
                    // Declaraciones
                    break; // break es opcional

                case "DATE":

                    valor=random.generateDate();
                    datatype=1;

                    break;

                default:

            }
            if (datatype==1) {
                insertStatement.append("'");
                insertStatement.append(valor);
                insertStatement.append("'");
            }else if(datatype==2){
              //  insertStatement.append("'");
                insertStatement.append(valorEntero);
               // insertStatement.append("'");
            }

             if (i == longitud-1) {
                
            } else {
                if (isUnique== true) {
                    
                    if (iterator.hasNext()) {
                       insertStatement.append(","); 
                    }else{
                    }
                    
                }else{
                    insertStatement.append(",");
                }
             
            }

            i++;

        }
        insertStatement.append(")");
        
        String valores= insertStatement.toString();

        return valores;
    }

}
