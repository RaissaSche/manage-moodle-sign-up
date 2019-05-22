package br.com.ntm.managemoodlesignup.classes;

import java.text.Normalizer;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class CreateMoodleReadySpreadsheet {

    //ler do arquivo
//guardar em uma matriz
    //trim every variable!!
    //throw things from strings to a (dynamic) matrix!! update: use collections!!
//adicionar as colunas que preciso, jogando com as variáveis
    //THE SUBLISTS ARE ROWS, THE STRINGS ARE COLUMNS
    // ------------------------------------------------------------------------
    //username password \firstname lastname email\ course1
    //add GUI
    //come back to course1 and file names
//exportar para csv (ler do original o nome e concatenar com algo tipo "moodle-ready")

    FindColumn findColumn = new FindColumn();

    List<List<String>> spreadsheetMoodleReady = new ArrayList<>();

    public List<List<String>> create(List<List<String>> spreadsheetInfo, String courseInitials) {

        List<String> nameRow = findColumn.find("nome", spreadsheetInfo);
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
        return spreadsheetMoodleReady;
    }

    private void createUsername(List<String> nameRow) {

        System.out.println("username");

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                name = stripAccents(name);
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[0].toLowerCase() +
                        nameAux[nameAux.length - 1].toLowerCase() + ";");
                //System.out.println(nameAux[0].toLowerCase() + nameAux[nameAux.length - 1].toLowerCase()+ ";");
                row++;
            }
        }
    }

    private void createPassword(List<String> nameRow) {

        System.out.println("password");

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                name = stripAccents(name);
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[0] + "@" + Year.now() + ";");
                //System.out.println(nameAux[0] + "@" + Year.now()+ ";");
                row++;
            }
        }
    }

    private void createFirstName(List<String> nameRow) {

        System.out.println("firstname");

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[0] + ";");
                //System.out.println(nameAux[0]+ ";");
                row++;
            }
        }
    }

    private void createLastName(List<String> nameRow) {

        System.out.println("lastname");

        int row = 1;

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(row).add(nameAux[nameAux.length - 1] + ";");
                //System.out.println(nameAux[nameAux.length - 1]+ ";");
                row++;
            }
        }
    }

    private void createEmail(List<String> emailRow) {

        System.out.println("email");

        int row = 1;

        for (String email : emailRow) {
            if (!email.toLowerCase().contains("email") && !email.toLowerCase().contains("e-mail")) {
                spreadsheetMoodleReady.get(row).add(email + ";");
                //System.out.println(email + ";");
                row++;
            }
        }
    }

    private void createCourse1(int numberOfRows, String courseInitials) {

        int row = 1;

        while (row < numberOfRows) {
            spreadsheetMoodleReady.get(row).add(courseInitials);
            row++;
        }
    }

    public static String stripAccents(String word) {

        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return word;
    }
}
