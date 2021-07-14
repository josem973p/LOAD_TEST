
package comtecom.replicacion.dynamic;

/**
 *
 * @author jose1
 */
public class TableAttributes {
    String colName;
    String dataType;
    int length;

    public TableAttributes(String colName, String dataType, int length) {
        this.colName = colName;
        this.dataType = dataType;
        this.length = length;
    }
    
     public TableAttributes() {

    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "TableAttributes{" + "colName=" + colName + ", dataType=" + dataType + ", length=" + length + '}';
    }
    
    
    
    
    
    
}
