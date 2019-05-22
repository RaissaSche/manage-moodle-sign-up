package br.com.ntm.managemoodlesignup.classes;

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

    private void createUsername(List<String> nameRow) {

        spreadsheetMoodleReady.add(new ArrayList<>());
        spreadsheetMoodleReady.get(0).add("username");
        System.out.println(spreadsheetMoodleReady.get(0).get(0));

        for (String name : nameRow) {
            if (!name.toLowerCase().contains("nome")) {
                String[] nameAux = name.split(" ");
               spreadsheetMoodleReady.get(0).add(nameAux[0].toLowerCase() + nameAux[nameAux.length - 1].toLowerCase());
                System.out.println(nameAux[0].toLowerCase() + nameAux[nameAux.length - 1].toLowerCase());
            }
        }
    }

    public void create(List<List<String>> spreadsheetInfo) {

        List<String> nameRow = findColumn.find("nome", spreadsheetInfo);

        //username
        createUsername(nameRow);

        // password
        //generate from spreadsheet name + @ + current year
        //'Hello world I am Bob'.replace('Hello world', '')
        spreadsheetMoodleReady.add(new ArrayList<>());

        // \firstname
        //get from spreadsheet
        spreadsheetMoodleReady.add(new ArrayList<>());

        // lastname
        //get from spreadsheet
        spreadsheetMoodleReady.add(new ArrayList<>());

        // email\
        //get from spreadsheet
        spreadsheetMoodleReady.add(new ArrayList<>());

        // course1
        //ask for input on the program somehow
        spreadsheetMoodleReady.add(new ArrayList<>());
    }
}
