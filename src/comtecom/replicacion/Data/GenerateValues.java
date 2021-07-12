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
public class GenerateValues {

    public String values() {

        List tableColumns = new ArrayList();
        TableMapper mp = new TableMapper();
        RamdomValues random = new RamdomValues();
        tableColumns = mp.DataTable("HR","HIST_CAJA_CONCENTRADO");

        StringBuilder insertStatement = new StringBuilder();
        // String InsertStatement ="insert into schema.tabla(clumnas) values(valores)";
        insertStatement.append(" VALUES(");

        int tam = tableColumns.size();
        int i = 0;
        int j=0;
        int longitud= tableColumns.size();
        for (Iterator iterator = tableColumns.iterator(); iterator.hasNext();) {
            if (i==0) {
                insertStatement.append("HR.PRUEBA_SEC.NEXTVAL");
                insertStatement.append(",");
                i++;
                Object next = iterator.next();
                continue;
                            
            }
            Object next = iterator.next();
            TableAttributes atributos = (TableAttributes) next;
            //guardar tipo y longitud y generarlo
            String tipo = atributos.getDataType();
            int length = atributos.getLength();
          //  System.out.println("numero ->" +length);
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

            if (i != longitud-1) {
                insertStatement.append(",");
            }

            i++;

        }
        insertStatement.append(")");
        
        String valores= insertStatement.toString();

        return valores;
    }

}
