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

    String schem;
    String tabl;
    String pk;
    String UNIQUE;
    Boolean isUnique = false;

    public String Statement(String Schema, String tabla, String pk, String UNIQUE) {
        this.schem = Schema;
        this.tabl = tabla;
        this.pk = pk;
        this.UNIQUE = UNIQUE;
        List tableColumns = new ArrayList();
        TableMapper mp = new TableMapper();
        tableColumns = mp.DataTable(Schema, tabla);
        int longitud = tableColumns.size();

        StringBuilder insertStatement = new StringBuilder();
        // String InsertStatement ="insert into schema.tabla(clumnas) values(valores)";
        insertStatement.append("INSERT INTO");

        insertStatement.append(" " + Schema + "." + tabla + "(");

        int tam = tableColumns.size();
        int i = 0;
        for (Iterator iterator = tableColumns.iterator(); iterator.hasNext();) {

            //  isUnique= false;
            Object next = iterator.next();
            TableAttributes atributos = (TableAttributes) next;

            if (atributos.getColName().equals(this.UNIQUE)) {
                isUnique = true;
                continue;
            }

            insertStatement.append(atributos.getColName());
            if (i == longitud - 1) {

            } else {
                if (isUnique == true) {

                    if (iterator.hasNext()) {
                        insertStatement.append(",");
                    } else {
                    }

                } else {
                    insertStatement.append(",");
                }
            }
            i++;

        }
        insertStatement.append(")");

        GenerateValues valores = new GenerateValues();
        String cadenaValores = valores.values(schem, tabl, pk, UNIQUE);
        //   System.out.println(cadenaValores);

        insertStatement.append(" " + cadenaValores);

        String query = insertStatement.toString();

        System.out.println(query);
        return query;

    }

    public String UpdateStatement(String Schema, String tabla, String pk, int num_updates) {

        List tableColumns = new ArrayList();
        TableMapper mp = new TableMapper();
        tableColumns = mp.DataTable(Schema, tabla); // lista objetos 
        StringBuilder UpdateStatement = new StringBuilder();
        // String InsertStatement ="insert into schema.tabla(clumnas) values(valores)";
        UpdateStatement.append("UPDATE " + Schema + "." + tabla + " SET" + "");

        Object segunda_col = tableColumns.get(1);
        TableAttributes atributos = (TableAttributes) segunda_col;
        RamdomValues random = new RamdomValues();

        String campo = atributos.getColName();
        String val = atributos.getDataType();
        int length = atributos.getLength();
        String valor = null;
        int valorEntero = 0;
        int datatype = 0;

        switch (val) {
            case "VARCHAR2":
                valor = random.generateString(length);
                datatype = 1;
                break; // break es opcional
            case "NUMBER":
                valorEntero = random.generateInt(length);
                datatype = 2;
                break; // break es opcional
            case "DATE":
                valor = random.generateDate();
                datatype = 1;
                break;
            default:
        }
        if (datatype == 1) {
            UpdateStatement.append(" " + campo + "='" + valor + "'");

        } else if (datatype == 2) {
            UpdateStatement.append(" " + campo + "=" + valorEntero);
        }
        UpdateStatement.append(" WHERE " + pk + " BETWEEN " + "1 AND " + num_updates);

        String update = UpdateStatement.toString();

        return update;
    }

    public String DeleteStatement(String Schema, String tabla, String pk, int num_deletes) {

        StringBuilder UpdateStatement = new StringBuilder();

        UpdateStatement.append("DELETE FROM " + Schema + "." + tabla + " WHERE " + pk + " BETWEEN 1 AND " + num_deletes);

        String delete = UpdateStatement.toString();

        return delete;
    }

}
