package br.com.ntm.managemoodlesignup.classes;

import br.com.ntm.managemoodlesignup.exceptions.WrongFileExtensionException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    CreateMoodleReadySpreadsheet createMoodleReadySpreadsheet = new CreateMoodleReadySpreadsheet();

    public boolean checkIfFileIsTSV(String originalPath) {

        if (!originalPath.contains(".tsv")) {
            throw new WrongFileExtensionException();
        }
        return true;
    }

    private String newFilePath(String originalPath) {

        if (checkIfFileIsTSV(originalPath)) {
            String[] splitPath = originalPath.split(".tsv");
            splitPath[0] += "_pronto_pro_moodle.csv";
            return splitPath[0];
        }
        return null;
    }

    private boolean lineIsResidue(String line) {

        String testLine = new String(new char[line.length()]).replace("\0", "\t");
        return line.matches(testLine) || line.isEmpty();
    }

    public void readAndWriteFile(String filePath, String courseInitials) {

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
                }
            }

            List<List<String>> spreadsheetMoodleReady = createMoodleReadySpreadsheet.create(spreadsheetInfo, courseInitials);

            for (List<String> list : spreadsheetMoodleReady) {
                for (String row : list) {
                    outputStream.write(row);
                }
                outputStream.newLine();
            }

            System.out.println(spreadsheetMoodleReady);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
