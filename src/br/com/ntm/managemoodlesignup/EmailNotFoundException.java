package br.com.ntm.managemoodlesignup;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException() {
        super("Coluna email não encontrada na tabela");
    }
}