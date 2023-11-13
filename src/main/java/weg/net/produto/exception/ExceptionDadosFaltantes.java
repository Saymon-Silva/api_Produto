package weg.net.produto.exception;


public class ExceptionDadosFaltantes extends RuntimeException{

    public ExceptionDadosFaltantes(){
        super ("O cadastrado precisa ser preenchido por inteiro!");
    }
    public ExceptionDadosFaltantes(String mensgaem){
        super(mensgaem);
    }

}
