package rmisecuritynm.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class RmiSecurityNM {

    public RmiSecurityNM() {
        super();

    }

    public static CharSequence lerPolicy(String caminho) {
        CharSequence value = "";
        try {
            FileReader file = new FileReader(caminho);
            BufferedReader readFile = new BufferedReader(file);

            String line = readFile.readLine();
            value += line;

            while (line != null) {
                line = readFile.readLine();
                if (line != null) {
                    value += "\n" + line;
                }
            }
            file.close();
        } catch (IOException e) {
            System.err.println("falha ao ler o arquivo -> " + e.getMessage());
        }
        return value;
    }

    public static void writePolicy(String caminho, String valor) {
        try {
            FileWriter file = new FileWriter(caminho);
            PrintWriter writeFile = new PrintWriter(file);
            valor = valor.substring(1, (valor.length() - 1));
            valor = valor.replace("\n, ", "\n\t");

            valor = "grant{\n\t" + valor + "\n};";
            writeFile.append(valor);

            file.close();
        } catch (IOException ex) {
            Logger.getLogger(RmiSecurityNM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getValuesFromTable(JTable table) {
        ArrayList<StringBuilder> linhas = new ArrayList<>();
        StringBuilder b;
        for (int i = 0; i < table.getRowCount() - 1; i++) {
            b = new StringBuilder();
            for (int j = 0; j < table.getColumnCount(); j++) {
                if (table.getValueAt(i, j) != null)
                    b.append(table.getValueAt(i, j)).append(" ");
            }
            if(table.getValueAt(i, 0) != null)
                b.append(";\n");
            linhas.add(b);
        }
        return linhas.toString();
    }
    
    public static String getValuesAll() {
        return "#permission java.security.AllPermission;#";
    }

    /*public static JTable setValuesFromTable(String caminho){
     JTable tbl = new JTable();
        
     String policyValue = RmiSecurityNM.lerPolicy(caminho).toString();
            
     String[] newValue = policyValue.split("\n");            
     for(int i = 0; i < newValue.length; i++){
     String[] newLine = newValue[i].split("\t");
     for(int k = 6; k < newLine.length; k++){
     /*if(k == 0)
     newLine[k] = newLine[k].replace("[", "");

     tbl.setValueAt(newLine[k], i, k);
     }
     }
     return tbl;
     }*/
    /*
     public static void main(String[] args) {
     lerPolicy("/home/hadoop/teste/arquivo.txt");
     writePolicy("/home/hadoop/teste/arquivo.txt");
     lerPolicy("/home/hadoop/teste/arquivo.txt");
     }
     */
}
