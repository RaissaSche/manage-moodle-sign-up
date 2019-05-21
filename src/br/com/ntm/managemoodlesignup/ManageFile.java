package br.com.ntm.managemoodlesignup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    //ler do arquivo
//guardar em uma matriz
    //trim every variable!!
    //throw things from strings to a (dynamic) matrix!! update: use collections!!
    // ------------------------------------------------------------------------
//adicionar as colunas que preciso, jogando com as variáveis
    //THE SUBLISTS ARE ROWS, THE STRINGS ARE COLUMNS
    //username password \firstname lastname email\ course1
//exportar para csv (ler do original o nome e concatenar com algo tipo "moodle-ready")

    public void findEmailColumn(List<List<String>> spreadsheetInfo) {

        List<String> firstRow = spreadsheetInfo.get(0);

        for (int i = 0; i < firstRow.size(); i++) {

            if (firstRow.get(i).toLowerCase().contains("email")
                    || firstRow.get(i).toLowerCase().contains("e-mail")) {

                System.out.println("Achei!");
            }
        }
    }

    public void findColumn(String columnName, List<List<String>> spreadsheetInfo){
        //columnName variable must be lower-case

        List<String> firstRow = spreadsheetInfo.get(0);

        for (int i = 0; i < firstRow.size(); i++) {

            if (firstRow.get(i).toLowerCase().equals(columnName)) {

                System.out.println("Achei! " + firstRow.get(i));
            }
        }
    }

    public boolean lineIsResidue(String line) {

        String testLine = new String(new char[line.length()]).replace("\0", "\t");
        return line.matches(testLine) || line.isEmpty();
    }

    public void readAndWriteFile() {

        List<List<String>> spreadsheetInfo = new ArrayList<>();
        int rowNumber = 0;

        try (BufferedReader inputStream = new BufferedReader(new
                FileReader("C:/Users/733120/Desktop/Scratch (respostas).tsv"));
             BufferedWriter outputStream = new BufferedWriter(new
                     FileWriter("C:/Users/733120/Desktop/scratch_pronto_pro_moodle.csv"))) {
            String line;

            while ((line = inputStream.readLine()) != null) {

                if (!lineIsResidue(line)) {
                    spreadsheetInfo.add(new ArrayList<>());
                    String auxLine[] = line.split("\t");

                    for (String info : auxLine) {
                        //add reorganizing here maybe?
                        info = info.trim();
                        spreadsheetInfo.get(rowNumber).add(info);
                    }
                    System.out.println(spreadsheetInfo.get(rowNumber));
                    //System.out.println(spreadsheetInfo.get(rowNumber).get(0));
                    rowNumber++;

                    outputStream.write(line);
                    outputStream.newLine();
                }
            }

           // findEmailColumn(spreadsheetInfo);

            findColumn("sobrenome", spreadsheetInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
