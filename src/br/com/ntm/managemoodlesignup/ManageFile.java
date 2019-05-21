package br.com.ntm.managemoodlesignup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    public void findEmailColumn(List<List<String>> spreadsheetInfo) {

        //tem que ter um jeito mais inteligente de checar isso, na boa

        List<String> firstRow = spreadsheetInfo.get(0);

        for (int i = 0; i < firstRow.size(); i++) {

            if (firstRow.get(i).contains("email") || firstRow.get(i).contains("e-mail")
                    || firstRow.get(i).contains("Email") || firstRow.get(i).contains("E-mail")) {

                System.out.println("Achei!");
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
                     FileWriter("C:/Users/733120/Desktop/scratch.csv"))) {
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

            findEmailColumn(spreadsheetInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
