package main.java.edd;

public class Main {
    public static void main(String[] args) {
        IFila fila = new Fila();

        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.print();

        System.out.println("Tamanho da fila: " + fila.size());

        fila.remove();
        fila.print();

        System.out.println("Fila está vazia? " + fila.isEmpty());

        fila.remove();
        fila.remove();
        fila.print();
        System.out.println("Fila está vazia? " + fila.isEmpty());
    }
}