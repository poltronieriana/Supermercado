package edd;

import java.util.Objects;

public class Cliente {
    private final String nome;
    private final int id;
    private int tempoAtendimento;

    public Cliente(String nome, int id, int tempoAtendimento) {
        this.nome = nome;
        this.id = id;
        this.tempoAtendimento = tempoAtendimento;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void decrementarTempoAtendimento() {
        if (tempoAtendimento > 0) {
            tempoAtendimento--;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", tempoAtendimento=" + tempoAtendimento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && tempoAtendimento == cliente.tempoAtendimento && Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, id, tempoAtendimento);
    }
}