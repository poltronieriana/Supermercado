package edd;

import java.util.Random;
import java.util.Scanner;

public class Supermercado {
    private Caixa[] caixas;
    private int contadorClientes;
    private int id = 1; //iniciando o id para cirar o cliente
    private String[] nomes = {"Ismael Pastel", "Alvaro Cavaleiro Medieval", "Ana Linda", "Raquel Super Professora", "Maurício Mickey", "Gabriel Cuilherme Nunes", "Alan Turing"};
    private Random random;
    private Scanner scanner;


    public Supermercado(int numeroDeCaixas) {
        caixas = new Caixa[numeroDeCaixas];
        for (int i = 0; i < numeroDeCaixas; i++) {
            caixas[i] = new Caixa();
        }
        contadorClientes = 1;
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void iniciarSimulacao() {
        int passo = 1;
        while (true) {
            System.out.println("\n=== PASSO " + passo + " ===");
            System.out.println("Pressione ENTER para continuar");
            scanner.nextLine();

            gerarCliente();
            processarCaixas();
            exibirEstado();
            passo++;
        }
    }

    private void gerarCliente() {
        int chance = random.nextInt(100);
        if (chance < 50) { 
            int tempoAtendimento = 5 + random.nextInt(11); 
            String nomeAleatorio = nomes[random.nextInt(nomes.length)];
            Cliente novo = new Cliente(nomeAleatorio, id, tempoAtendimento);
            id++;
            Caixa caixaDestino = caixaComMenorFila();
            caixaDestino.adicionarCliente(novo);
            System.out.println("Novo cliente chegou: " + novo + " -> Direcionado ao caixa " + (indiceCaixa(caixaDestino) + 1));
        }
    }

    private void processarCaixas() {
        for (Caixa caixa : caixas) {
            caixa.processar();
        }
    }

    private void exibirEstado() {
        for (int i = 0; i < caixas.length; i++) {
            Caixa caixa = caixas[i];
            System.out.println("Caixa " + (i + 1) + ":");
            System.out.print("  Fila: ");
            caixa.exibirFila();
            if (caixa.getClienteAtual() != null) {
                System.out.println("  Em atendimento: " + caixa.getClienteAtual() +
                    " | Tempo restante: " + caixa.getTempoRestante());
            } else {
                System.out.println("  Em atendimento: Nenhum");
            }
        }
    }

    private Caixa caixaComMenorFila() {
        Caixa menor = caixas[0];
        for (int i = 1; i < caixas.length; i++) {
            if (caixas[i].getTamanhoFila() < menor.getTamanhoFila()) {
                menor = caixas[i];
            }
        }
        return menor;
    }

    private int indiceCaixa(Caixa caixa) {
        for (int i = 0; i < caixas.length; i++) {
            if (caixas[i] == caixa) {
                return i;
            }
        }
        return -1;
    }
}