package modelo;

import java.util.ArrayList;

public class Conta {
    private String nomeDoTitular;
    private String tipoDeConta;
    private double saldo;
    private ArrayList<Movimentacao> historicoDeMovimentacoes;

    public void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setTipoDeConta(String tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    private void depositar(double deposito) {
        this.saldo = this.saldo + deposito;
    }

    private void sacar(double saque) {
        this.saldo = this.saldo - saque;
    }

    public void gerarSaldo(String metodo, double valor) {
        switch (metodo) {
            case "Deposito":
                depositar(valor);
                break;
            case "Saque":
                sacar(valor);
                break;
        }

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData();
        movimentacao.setTipo(metodo);
        movimentacao.setValor(valor);

        if (historicoDeMovimentacoes == null) {
            historicoDeMovimentacoes = new ArrayList<>();
        }
        historicoDeMovimentacoes.add(movimentacao);
    }

    public String[] gerarDadosDaConta() {
        return new String[]{nomeDoTitular, tipoDeConta, String.format("%.2f", saldo)};
    }

    public ArrayList<Movimentacao> gerarExtrato() {
        return historicoDeMovimentacoes != null ? historicoDeMovimentacoes : new ArrayList<>();
    }

    public ArrayList<Movimentacao> gerarExtratoDepositos() {
        ArrayList<Movimentacao> listaDeDepositos = new ArrayList<>();
        if (historicoDeMovimentacoes != null) {
            for (Movimentacao movimentacao : historicoDeMovimentacoes) {
                if (movimentacao.getTipo().equals("Deposito")) {
                    listaDeDepositos.add(movimentacao);
                }
            }
        }
        return listaDeDepositos;
    }

    public ArrayList<Movimentacao> gerarExtratoSaques() {
        ArrayList<Movimentacao> listaDeSaques = new ArrayList<>();
        if (historicoDeMovimentacoes != null) {
            for (Movimentacao movimentacao : historicoDeMovimentacoes) {
                if (movimentacao.getTipo().equals("Saque")) {
                    listaDeSaques.add(movimentacao);
                }
            }
        }
        return listaDeSaques;
    }
}