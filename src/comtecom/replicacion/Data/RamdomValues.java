package comtecom.replicacion.Data;

import java.util.Random;

/**
 *
 * @author jose1
 */
public class RamdomValues {

    Random random = new Random();

    public String generateString(int digitos) {
        //  int digitos = 2;
        StringBuilder cad = new StringBuilder();
        if (digitos>10) {
                digitos=1;
            }

        for (int i = 0; i < digitos; i++) {
           

            char c = (char) (random.nextInt(26) + 'a');
            cad.append(c);
        }
        return cad.toString();
    }

    public int generateInt(int digitos) {
        
     //   int di=digitos;
        
        if (digitos>9) {
            digitos=8;
        }

        StringBuilder num = new StringBuilder();
        
        for (int i = 0; i < 1; i++) {
           
            int c = (int) (random.nextInt(9));
            String character = c + "";
            num.append(character);
        }
        String n = num.toString();
      //  System.out.println("cadena antes e numero"+n);
        int numero = Integer.parseInt(n);

        return numero;
    }

    public String generateDate() {
        StringBuilder date = new StringBuilder();

        String[] dia = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
        String[] mes = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] anio = {"2000", "2001", "2020", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"};

        // 15/05/1997
        //dias
        int c = (int) (random.nextInt(28));
        String character = dia[c];
        date.append(character);
        date.append("/");

        c = (int) (random.nextInt(12));
        character = mes[c];
        date.append(character);
        date.append("/");

        c = (int) (random.nextInt(22));
        character = anio[c];
        date.append(character);

        String n = date.toString();
        //int numero = Integer.valueOf(n);   
        return n;
    }
    
  

}
