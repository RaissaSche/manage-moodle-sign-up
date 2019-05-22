package br.com.ntm.managemoodlesignup.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    CreateMoodleReadySpreadsheet createMoodleReadySpreadsheet = new CreateMoodleReadySpreadsheet();

    private boolean lineIsResidue(String line) {

        String testLine = new String(new char[line.length()]).replace("\0", "\t");
        return line.matches(testLine) || line.isEmpty();
    }

    private String newFilePath(String originalPath){
        //get original directory + add some stuff to the end (but before the csv)
        //separate string by .tsv
        //if xabu, throw exception
        //add pronto_pro_moodle.csv to first option

        String[] splitPath = originalPath.split(".tsv");
        splitPath[0] += "_pronto_pro_moodle.csv";

        return splitPath[0];
    }

    public void readAndWriteFile(String filePath) {

        List<List<String>> spreadsheetInfo = new ArrayList<>();
        int rowNumber = 0;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(filePath));
             BufferedWriter outputStream = new BufferedWriter(new
                     FileWriter(newFilePath(filePath)))) {
            String line;

            while ((line = inputStream.readLine()) != null) {

                if (!lineIsResidue(line)) {
                    spreadsheetInfo.add(new ArrayList<>());
                    String auxLine[] = line.split("\t");

                    for (String info : auxLine) {
                        info = info.trim();
                        spreadsheetInfo.get(rowNumber).add(info);
                    }

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
