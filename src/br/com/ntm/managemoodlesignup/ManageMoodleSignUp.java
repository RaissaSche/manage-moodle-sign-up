package br.com.ntm.managemoodlesignup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageMoodleSignUp {

//ler do arquivo
//guardar em uma matriz
    //trim every variable!!
    //throw things from strings to a (dynamic) matrix!! update: use collections!!
    // ------------------------------------------------------------------------
//adicionar as colunas que que preciso, jogando com as variáveis
    //username password \firstname lastname email\ course1
//exportar para csv (ler do original o nome e concatenar com algo tipo "moodle-ready")

    public static void main(String[] args) {

        List<List<String>> spreadsheetInfo = new ArrayList<List<String>>();
        //separating the first lines, so that they can be used for username and password
        spreadsheetInfo.add(new ArrayList<>());
        spreadsheetInfo.add(new ArrayList<>());
        int rowNumber = 2;

        try (BufferedReader inputStream = new BufferedReader(new
                FileReader("C:/Users/733120/Desktop/Scratch (respostas).txt"));
             BufferedWriter outputStream = new BufferedWriter(new
                     FileWriter("C:/Users/733120/Desktop/scratch.csv"))) {
            String line;
            while ((line = inputStream.readLine()) != null || line.matches("\t")) {

                spreadsheetInfo.add(new ArrayList<>());
                String auxLine[] = line.split("\t");

                for(String info : auxLine){
                    //add reorganizing here maybe?
                    info = info.trim();
                    spreadsheetInfo.get(rowNumber).add(info);
                }
                System.out.println(spreadsheetInfo.get(rowNumber));
                System.out.println(spreadsheetInfo.get(rowNumber).get(0));
                rowNumber++;

                outputStream.write(line);
                outputStream.newLine();

                //tem que ter um jeito mais inteligente de checar isso, na boa
                if(spreadsheetInfo.contains("email") || spreadsheetInfo.contains("e-mail")
                        || spreadsheetInfo.contains("Email") || spreadsheetInfo.get(0).get(5).contains("E-mail")){

                }
                else{
                    throw new EmailNotFoundException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}