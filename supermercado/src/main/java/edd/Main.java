package edd;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado(3);// n caixas nesse caso é 3 
        IFila fila = new Fila();
        supermercado.iniciarSimulacao();
    }
}