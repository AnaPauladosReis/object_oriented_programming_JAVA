package visualizacao;

import javax.swing.*;
import modelo.Movimentacao;
import java.util.ArrayList;

public class EntradaSaida {
    public static int solicitarOpcaoPrograma() {
        String[] opcoes = {"Depositar", "Sacar", "Visualizar Dados da Conta", "Visualizar Extrato",
                "Visualizar Extrato de Depositos", "Visualizar Extrato de Saques", "Sair do Programa"};

        JComboBox<String> menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione uma opcao", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedIndex();
    }

    public static String solicitarTitularDaConta() {
        return JOptionPane.showInputDialog(null, "Qual o nome do titular da conta?");
    }

    public static String solicitarTipoDaConta() {
        String[] opcoes = {"Corrente", "Poupanca"};
        JComboBox<String> menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione o tipo da conta", JOptionPane.OK_CANCEL_OPTION);
        return menu.getSelectedItem().toString();
    }

    public static double solicitarInformacoesDeposito() {
        return Double.parseDouble(JOptionPane.showInputDialog(null, "Qual a quantia que você deseja depositar?"));
    }

    public static double solicitarInformacoesSaque() {
        return Double.parseDouble(JOptionPane.showInputDialog(null, "Qual a quantia que você deseja sacar?"));
    }

    public static void exibirDadosDaConta(String[] informacoesDaConta) {
		JOptionPane.showMessageDialog(null, "" +
                "Nome do titular: " + informacoesDaConta[0] + "\n" +
                "Tipo da conta: " + informacoesDaConta[1] + "\n" +
                "Saldo: R$" + informacoesDaConta[2]);		  		
    }

    public static void exibirExtratoCompleto(ArrayList<Movimentacao> historicoDeMovimentacoes) {
        if (historicoDeMovimentacoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há movimentações registradas.");
            return;
        }

        StringBuilder extrato = new StringBuilder();
        extrato.append("Extrato Completo:\n");
        for (Movimentacao movimentacao : historicoDeMovimentacoes) {
            extrato.append("Data: ").append(movimentacao.getData()).append("\n");
            extrato.append("Tipo: ").append(movimentacao.getTipo()).append("\n");
            extrato.append("Valor: R$").append(String.format("%.2f", movimentacao.getValor())).append("\n");
            extrato.append("--------------------\n");
        }

        JOptionPane.showMessageDialog(null, extrato.toString());
    }

    public static void exibirExtratos(String tipo, ArrayList<Movimentacao> historicoDeMovimentacoes) {
        if (historicoDeMovimentacoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há movimentações do tipo " + tipo + " registradas.");
            return;
        }

        StringBuilder extrato = new StringBuilder();
        extrato.append("Extrato de ").append(tipo).append(":\n");
        for (Movimentacao movimentacao : historicoDeMovimentacoes) {
            if (movimentacao.getTipo().equals(tipo)) {
                extrato.append("Data: ").append(movimentacao.getData()).append("\n");
                extrato.append("Valor: R$").append(String.format("%.2f", movimentacao.getValor())).append("\n");
                extrato.append("--------------------\n");
            }
        }

        JOptionPane.showMessageDialog(null, extrato.toString());
    }

    public static void exibirSucesso(String metodo) {
        JOptionPane.showMessageDialog(null, metodo + " bem-sucedido");
    }

    public static void exibirInvalido(String metodo) {
        JOptionPane.showMessageDialog(null, "O valor do " + metodo + " nao pode ser menor ou igual a zero!");
    }

    public static void exibirLimiteAtingido() {
        JOptionPane.showMessageDialog(null, "Voce nao pode sacar mais, pois excede o debito maximo na conta!");
    }

    public static void exibirMetodoNaoEncontrado(String metodo) {
        JOptionPane.showMessageDialog(null, "O método '" + metodo + "' nao foi encontrado!");
    }
}