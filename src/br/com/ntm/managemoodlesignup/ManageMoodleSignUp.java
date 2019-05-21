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
//adicionar as colunas que preciso, jogando com as variáveis
    //username password \firstname lastname email\ course1
//exportar para csv (ler do original o nome e concatenar com algo tipo "moodle-ready")

    public static void main(String[] args) {

        CreateUserAndPassword createUserAndPassword = new CreateUserAndPassword();
        ManageFile readAndWriteFile = new ManageFile();

        readAndWriteFile.readAndWriteFile();
    }
}