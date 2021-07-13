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
           /*
            if (i==0) {
                insertStatement.append("HR.PRUEBA_SEC.NEXTVAL");
                insertStatement.append(",");
                i++;
                Object next = iterator.next();
                continue;
                            
            }
*/
            Object next = iterator.next();
            TableAttributes atributos = (TableAttributes) next;
            String tipo = atributos.getDataType();
            int length = atributos.getLength();
            //guardar tipo y longitud y generarlo
            
            //se debe implementar codigo para que busque la PK
            if (atributos.getColName().equals(PK)) {
                insertStatement.append("HR.PRUEBA_SEC.NEXTVAL");
                insertStatement.append(",");
                i++;
                continue;
            }
            if(atributos.getColName().equals(UNIQUE) /**&& atributos.getDataType().equals("VARCHAR2")*/){
                System.out.println("entre al metodo");
                int[] lon = new  int[length];
                for (int k = 1; k < length; k++) {
                    lon[i]=i;
                }
                 Random rando = new Random();
                int c = (int) (rando.nextInt(length));
                    
                String cad = random.generateString(c);
                 insertStatement.append("null");
                insertStatement.append(",");
                i++;
                continue;
            
            }else if(atributos.getColName().equals(UNIQUE) && atributos.getDataType().equals("NUMBER")){
            insertStatement.append("HR.SEC_UNIQUE.NEXTVAL");
                insertStatement.append(",");
                i++;
                continue;
            }
            
            
            //
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
