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
    // ------------------------------------------------------------------------
//adicionar as colunas que preciso, jogando com as variáveis
    //THE SUBLISTS ARE ROWS, THE STRINGS ARE COLUMNS
    //username password \firstname lastname email\ course1
//exportar para csv (ler do original o nome e concatenar com algo tipo "moodle-ready")

    FindColumn findColumn = new FindColumn();

    List<List<String>> spreadsheetMoodleReady = new ArrayList<>();

    public void create(List<List<String>> spreadsheetInfo) {

        List<String> nameRow = findColumn.find("nome", spreadsheetInfo);

        for (int i = 0; i < 6; i++){
            spreadsheetMoodleReady.add(new ArrayList<>());
        }

        //username - 0
        spreadsheetMoodleReady.get(0).add("username");
        createUsername(nameRow);

        // password - 1
        //generate from spreadsheet name + @ + current year
        spreadsheetMoodleReady.get(1).add("password");
        createPassword(nameRow);

        // \firstname - 2
        //get from spreadsheet
        spreadsheetMoodleReady.get(2).add("firstname");
        createFirstName(nameRow);

        // lastname - 3
        //get from spreadsheet
        spreadsheetMoodleReady.get(3).add("lastname");

        // email - 4
        //get from spreadsheet
        spreadsheetMoodleReady.get(4).add("email");

        // course1 - 5
        //ask for input on the program somehow
        spreadsheetMoodleReady.get(5).add("course1");
    }

    private void createUsername(List<String> nameRow) {

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                name = stripAccents(name);
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(0).add(nameAux[0].toLowerCase() + nameAux[nameAux.length - 1].toLowerCase());
                System.out.println(nameAux[0].toLowerCase() + nameAux[nameAux.length - 1].toLowerCase());
            }
        }
    }

    private void createPassword(List<String> nameRow) {

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                name = stripAccents(name);
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(1).add(nameAux[0] + "@" + Year.now());
                System.out.println(nameAux[0] + "@" + Year.now());
            }
        }
    }

    private void createFirstName(List<String> nameRow) {

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(1).add(nameAux[0]);
                System.out.println(nameAux[0]);
            }
        }
    }

    private void createLastName(List<String> nameRow) {

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                String[] nameAux = name.split(" ");
                spreadsheetMoodleReady.get(1).add(nameAux[0]);
                System.out.println(nameAux[0]);
            }
        }
    }

    public static String stripAccents(String word) {

        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return word;
    }
}
