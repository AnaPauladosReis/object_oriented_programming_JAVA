package visualizacao;

import javax.swing.*;

public class EntradaSaida {
    private final String[] opcoesMenu = {"Fabricar carros", "Vender um carro", "Ver informações dos carros", "Sair"};

    public int solicitarOpcaoMenu() {
        JComboBox<String> comboBox = new JComboBox<>(opcoesMenu);
        JOptionPane.showMessageDialog(null, comboBox, "Escolha uma opção:", JOptionPane.PLAIN_MESSAGE);
        return comboBox.getSelectedIndex() + 1;
    }

    public int solicitarQuantidadeCarros() {
        String quantidadeString = JOptionPane.showInputDialog(null, "Quantos carros deseja fabricar?", "Fabricar Carros", JOptionPane.QUESTION_MESSAGE);
        if (quantidadeString != null && !quantidadeString.isEmpty() && quantidadeString.matches("\\d+")) {
            return Integer.parseInt(quantidadeString);
        }
        return 0;
    }

    public String solicitarModeloCarro(int numero) {
        return JOptionPane.showInputDialog(null, "Digite o modelo do carro " + numero + ":", "Modelo", JOptionPane.QUESTION_MESSAGE);
    }

    public String solicitarCorCarro(int numero) {
        return JOptionPane.showInputDialog(null, "Digite a cor do carro " + numero + ":", "Cor", JOptionPane.QUESTION_MESSAGE);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}