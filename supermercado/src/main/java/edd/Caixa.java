package edd;

public class Caixa {
    private IFila filaClientes;
    private Cliente clienteAtual;
    private int tempoRestante;

    public Caixa() {
        this.filaClientes = new Fila(); 
        this.clienteAtual = null;
        this.tempoRestante = 0;
    }

    public void adicionarCliente(Cliente cliente) {
        filaClientes.add(cliente);
    }

    public int getTamanhoFila() {
        return filaClientes.size();
    }

    public void processar() {
        if (clienteAtual == null && !filaClientes.isEmpty()) {
            clienteAtual = (Cliente) ((Fila) filaClientes).proximo();
            filaClientes.remove();
            tempoRestante = clienteAtual.getTempoAtendimento();
        }

        if (clienteAtual != null) {
            clienteAtual.decrementarTempoAtendimento();
            tempoRestante--;

            if (tempoRestante <= 0) {
                clienteAtual = null; 
            }
        }
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public void exibirFila() {
        ((Fila) filaClientes).print();
    }

    public boolean estaLivre() {
        return clienteAtual == null;
    }
}