package visualizacao;

import javax.swing.JOptionPane;

import modelo.CupomFiscal;

public class Saida {
    public static void exibirFimPrograma(){
        JOptionPane.showMessageDialog(null, "O programa será encerrado!");
    }

    public static void exibirIdJaExiste(){
        JOptionPane.showMessageDialog(null, "Este código já existe!");
    }

    public static void exibirLista(String lista){
        JOptionPane.showMessageDialog(null, lista);
    }

    public static void exibirNaoTem(String metodo){
        JOptionPane.showMessageDialog(null, "Você não possui " + metodo + "!");
    }

    public static void exibirCupomFiscal(CupomFiscal cupomFiscal){
        JOptionPane.showMessageDialog(null, "Compra bem-sucedida!" + "\n Cupom fiscal:" +
                "\n Data: " + cupomFiscal.getDate() +
                "\n Produto: " + cupomFiscal.getProductDescription() +
                "\n Valor: R$" + String.format("%.2f",cupomFiscal.getProductValue()) +
                "\n Quantidade: " + cupomFiscal.getProductQuantity() +
                "\n Valor Total: R$" + String.format("%.2f",cupomFiscal.getValue()));
    }

    public static void exibirPrecoInvalido(){
        JOptionPane.showMessageDialog(null, "O valor do produto precisa ser maior que zero!");
    }
}
