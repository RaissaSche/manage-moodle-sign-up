package br.com.ntm.managemoodlesignup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageMoodleSignUp {

    //Use collections to do this. For example:

    //List<List<Integer>> dynamic2D = new ArrayList<List<Integer>>();

    //dynamic2D.add(new ArrayList<Integer>());
    //dynamic2D.add(new ArrayList<Integer>());
    //dynamic2D.add(new ArrayList<Integer>());

    //dynamic2D.get(0).add(5);
    //dynamic2D.get(0).add(6);
    //dynamic2D.get(0).add(7);

    //System.out.println(dynamic2D.get(0).get(0)); // 5
    //System.out.println(dynamic2D.get(0).get(1)); // 6
    // System.out.println(dynamic2D.get(0).get(2)); // 7

//ler do arquivo
//guardar em uma matriz
    //trim every variable!! V
    //throw things from strings to a (dynamic) matrix!! update: use collections!!
    // ------------------------------------------------------------------------
//adicionar as colunas que que preciso, jogando com as variáveis
    //username password \firstname lastname email\ course1
//exportar para csv (ler do original o nome e concatenar com algo tipo "moodle-ready")

    public static void main(String[] args) {

        List<List<String>> spreadsheetInfo = new ArrayList<List<String>>();
        int rowNumber = 0;

        try (BufferedReader inputStream = new BufferedReader(new
                FileReader("C:/Users/733120/Desktop/Scratch (respostas).txt"));
             BufferedWriter outputStream = new BufferedWriter(new
                     FileWriter("C:/Users/733120/Desktop/scratch.csv"))) {
            String line;
            while ((line = inputStream.readLine()) != null || line.matches("\t")) {

                spreadsheetInfo.add(new ArrayList<>());
                String auxLine[] = line.split("\t");

                for(String info : auxLine){
                    info = info.trim();
                    spreadsheetInfo.get(rowNumber).add(info);
                }
                System.out.println(spreadsheetInfo.get(rowNumber));
                System.out.println(spreadsheetInfo.get(rowNumber).get(0));
                rowNumber++;

                outputStream.write(line);
                outputStream.newLine();

                //tem que ter um jeito mais inteligente de checar isso, na boa
               // if(spreadsheetInfo.contains("email") || spreadsheetInfo.contains("e-mail")
                //        || spreadsheetInfo.contains("Email") || spreadsheetInfo.get(0).get(5).contains("E-mail")){

                //}
                //else{
                //    throw new EmailNotFoundException();
               // }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}