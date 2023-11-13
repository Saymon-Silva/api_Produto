package weg.net.produto.exception;

public class ExceptionConflito extends RuntimeException {

    public ExceptionConflito() {
        super("Já existe um cadastro parecido!");
    }
    public ExceptionConflito(String mensgaem){
        super(mensgaem);
    }

}
