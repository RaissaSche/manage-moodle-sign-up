package br.com.ntm.managemoodlesignup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    /*public boolean lineHasInfo(String line){

        return (!line.isEmpty());
    }*/

    public boolean lineIsntOnlyTabulation(String line, int lineFields){

        String testLine = new String(new char[lineFields]).replace("\0", "\t");
        return !line.matches(testLine);
    }

    public void readAndWriteFile() {

        List<List<String>> spreadsheetInfo = new ArrayList<List<String>>();
        int rowNumber = 0;

        try (BufferedReader inputStream = new BufferedReader(new
                FileReader("C:/Users/733120/Desktop/Scratch (respostas).txt"));
             BufferedWriter outputStream = new BufferedWriter(new
                     FileWriter("C:/Users/733120/Desktop/scratch.csv"))) {
            String line;
            int lineFields = 0;

            while ((line = inputStream.readLine()) != null || lineIsntOnlyTabulation(line, lineFields)) {

               // if (lineHasInfo(line)) {
                    spreadsheetInfo.add(new ArrayList<>());
                    String auxLine[] = line.split("\t");
                    lineFields = auxLine.length;

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
               // }
            }

            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
