package br.com.ntm.managemoodlesignup.exceptions;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException() {
        super("Coluna email não encontrada na tabela!");
    }
}