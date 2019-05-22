package br.com.ntm.managemoodlesignup.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    CreateMoodleReadySpreadsheet createMoodleReadySpreadsheet = new CreateMoodleReadySpreadsheet();
    FindColumn findColumn = new FindColumn();
    //ler do arquivo
//guardar em uma matriz
    //trim every variable!!
    //throw things from strings to a (dynamic) matrix!! update: use collections!!
    // ------------------------------------------------------------------------
//adicionar as colunas que preciso, jogando com as variáveis
    //THE SUBLISTS ARE ROWS, THE STRINGS ARE COLUMNS
    //username password \firstname lastname email\ course1
//exportar para csv (ler do original o nome e concatenar com algo tipo "moodle-ready")

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
                        info = info.trim();
                        spreadsheetInfo.get(rowNumber).add(info);
                    }
                    //System.out.println(spreadsheetInfo.get(rowNumber));
                    rowNumber++;

                    outputStream.write(line);
                    outputStream.newLine();
                }
            }
            createMoodleReadySpreadsheet.create(spreadsheetInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
