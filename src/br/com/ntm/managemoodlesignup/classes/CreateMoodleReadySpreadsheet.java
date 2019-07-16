package br.com.ntm.managemoodlesignup.classes;

import java.text.Normalizer;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

class CreateMoodleReadySpreadsheet {

    private FindColumn findColumn = new FindColumn();
    private List<List<String>> spreadsheetMoodleReady = new ArrayList<>();

    List<List<String>> create(List<List<String>> spreadsheetInfo, String courseInitials) {

        List<String> nameRow = findColumn.findName(spreadsheetInfo);
        List<String> emailRow = findColumn.findEmail(spreadsheetInfo);

        for (int i = 0; i < 6; i++) {
            spreadsheetMoodleReady.add(new ArrayList<>());
        }

        //username - 0
        spreadsheetMoodleReady.get(0).add("username;");
        createUsername(nameRow);

        // password - 1
        spreadsheetMoodleReady.get(0).add("password;");
        createPassword(nameRow);

        // \firstname - 2
        spreadsheetMoodleReady.get(0).add("firstname;");
        createFirstName(nameRow);

        // lastname - 3
        spreadsheetMoodleReady.get(0).add("lastname;");
        createLastName(nameRow);

        // email - 4
        spreadsheetMoodleReady.get(0).add("email;");
        createEmail(emailRow);

        // course1 - 5
        spreadsheetMoodleReady.get(0).add("course1;");
        createCourse1(nameRow.size(), courseInitials);

        // role1 - 6
        spreadsheetMoodleReady.get(0).add("role1;");
        createRole1(nameRow.size());

        return spreadsheetMoodleReady;
    }

    private void createUsername(List<String> nameRow) {

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                name = stripAccents(name);
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[0].toLowerCase() +
                        nameAux[nameAux.length - 1].toLowerCase() + ";");
                row++;
            }
        }
    }

    private void createPassword(List<String> nameRow) {

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                name = stripAccents(name);
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[0] + "@" + Year.now() + ";");
                row++;
            }
        }
    }

    private void createFirstName(List<String> nameRow) {

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[0] + ";");
                row++;
            }
        }
    }

    private void createLastName(List<String> nameRow) {

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[nameAux.length - 1] + ";");
                row++;
            }
        }
    }

    private void createEmail(List<String> emailRow) {

        int row = 1;

        for (String email : emailRow) {
            if (!email.toLowerCase().contains("email") && !email.toLowerCase().contains("e-mail")) {
                spreadsheetMoodleReady.get(row).add(email + ";");
                row++;
            }
        }
    }

    private void createCourse1(int numberOfRows, String courseInitials) {

        int row = 1;

        while (row < numberOfRows) {
            spreadsheetMoodleReady.get(row).add(courseInitials + ";");
            row++;
        }
    }

    private void createRole1(int numberOfRows) {

        int row = 1;

        while (row < numberOfRows) {
            spreadsheetMoodleReady.get(row).add("student;");
            row++;
        }
    }

    private static String stripAccents(String word) {

        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return word;
    }
}
