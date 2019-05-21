package br.com.ntm.managemoodlesignup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageMoodleSignUp {

    public static void main(String[] args) {

        CreateUserAndPassword createUserAndPassword = new CreateUserAndPassword();
        ManageFile readAndWriteFile = new ManageFile();

        readAndWriteFile.readAndWriteFile();
    }
}