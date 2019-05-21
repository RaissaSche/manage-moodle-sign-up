package br.com.ntm.managemoodlesignup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    public boolean lineIsResidue(String line){

        String testLine = new String(new char[line.length()]).replace("\0", "\t");
        return line.matches(testLine) || line.isEmpty();
    }

    public void readAndWriteFile() {

        List<List<String>> spreadsheetInfo = new ArrayList<List<String>>();
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

                    //tem que ter um jeito mais inteligente de checar isso, na boa
               /* if (spreadsheetInfo.contains("email") || spreadsheetInfo.contains("e-mail")
                        || spreadsheetInfo.contains("Email") || spreadsheetInfo.get(0).get(5).contains("E-mail")) {

                } else {
                    throw new EmailNotFoundException();
                }*/
                }
            }

            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
