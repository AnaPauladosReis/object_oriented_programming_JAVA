package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.*;
import visualizacao.EntradaSaida;

public class Controladora {

    private Casa casa = null;

    public void exibeMenu() {
        int opcao;
        do {
            opcao = EntradaSaida.solicitaOpcao();

            switch (opcao) {
                case 0:
                    construirCasa();
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Movimentar portas ou janelas");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Ver informações da casa");
                    break;
            }
        } while (opcao != 3);

        EntradaSaida.exibeMsgEncerraPrograma();
        System.exit(0);
    }

    private void construirCasa() {
        this.casa = new Casa();
        String descricao = EntradaSaida.solicitaDescricao("casa", 0);
        String cor = EntradaSaida.solicitaCor();
        int quantidadeDePortas = EntradaSaida.solicitaQuantidadeDeAberturas("portas");
        int quantidadeDeJanelas = EntradaSaida.solicitaQuantidadeDeAberturas("janelas");

        if (quantidadeDePortas < 0 || quantidadeDeJanelas < 0) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida. Por favor, insira um número positivo.");
            return;
        }

        ArrayList<Aberturas> listaDePortas = construirAberturas("porta", quantidadeDePortas);
        ArrayList<Aberturas> listaDeJanelas = construirAberturas("janela", quantidadeDeJanelas);

        JOptionPane.showMessageDialog(null, "Construir casa");

        this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);

        exibirInformacoesCasa();
    }

    private ArrayList<Aberturas> construirAberturas(String tipoAbertura, int quantidade) {
        ArrayList<Aberturas> aberturas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            Aberturas abertura;
            if (tipoAbertura.equals("porta")) {
                abertura = new Porta();
            } else {
                abertura = new Janela();
            }
            abertura.setDescricao(EntradaSaida.solicitaDescricao(tipoAbertura, i + 1));
            int estadoInt = EntradaSaida.solicitaEstado(tipoAbertura); // Obtém o estado como inteiro
            String estadoStr = estadoInt == 0 ? "Fechada" : "Aberta"; // Converte para string correspondente
            abertura.setEstado(estadoStr); // Define o estado da porta/janela
            aberturas.add(abertura);
        }
        return aberturas;
    }

    private void exibirInformacoesCasa() {
        System.out.println("Descrição da casa: " + casa.getDescricao() + "\n");
        System.out.println("Cor da casa: " + casa.getCor() + "\n");

        exibirAberturas(casa.getListaDePortas(), "porta");
        exibirAberturas(casa.getListaDeJanelas(), "janela");
    }

    private void exibirAberturas(ArrayList<Aberturas> aberturas, String tipoAbertura) {
        for (Aberturas abertura : aberturas) {
            System.out.println("Descrição da " + tipoAbertura + ": " + abertura.getDescricao() + "\n");
            System.out.println("Estado da " + tipoAbertura + ": " + abertura.getEstado() + "\n");
        }
    }
}