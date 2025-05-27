package main.java.edd;

public class Fila implements IFila{

    private Noh inicio;
    private Noh fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public boolean add(Object info) {
        Noh novo = new Noh(info);

        if (this.isEmpty()) {
            inicio = novo;
        } else {
            fim.setProx(novo);
        }

        fim = novo;
        tamanho++;
        return true;
    }

    @Override
    public boolean remove() {
        if (!isEmpty()) {
            if (inicio == fim) {
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.getProx();
            }
            tamanho--;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return inicio == null;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return;
        }

        Noh atual = inicio;
        System.out.print("Fila: [ ");
        while (atual != null) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getProx();
        }
        System.out.println("]");
    }
}
