package br.com.ntm.managemoodlesignup;

public class ColumnNotFoundException extends RuntimeException {

    public ColumnNotFoundException() {
        super("Coluna não encontrada na tabela!");
    }
}