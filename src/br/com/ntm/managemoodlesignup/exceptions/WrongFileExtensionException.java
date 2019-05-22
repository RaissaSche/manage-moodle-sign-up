package br.com.ntm.managemoodlesignup.exceptions;

public class WrongFileExtensionException extends RuntimeException {

    public WrongFileExtensionException() {
        super("O arquivo inserido não é do formato certo, garanta que está selecionando um arquivo .tsv!");
    }
}