package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Entrada {
    public static int solicitarMenu(String[] opcoes, String titulo) {

        JComboBox<String> menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, titulo, JOptionPane.OK_CANCEL_OPTION);
        return menu.getSelectedIndex();
    }

    public static int solicitarSubMenu(int menu){
        String[] opcoes = {};
        String titulo = "";
        if(menu == 0 ){
            titulo = "Registro de produtos";
            opcoes = new String[]{"Registrar produtos", "Ver produtos registrados", "Voltar"};
        } else if (menu == 1) {
            titulo = "Estoque de produtos";
            opcoes = new String[]{"Adicionar produtos ao estoque", "Ver produtos no estoque", "Vender produtos", "Voltar"};
        } else{
            return 0;
        }
        JComboBox<String> selectMenu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, selectMenu, titulo, JOptionPane.OK_CANCEL_OPTION);

        return selectMenu.getSelectedIndex();
    }

    public static String solicitarIdProduto() {
        String id = JOptionPane.showInputDialog(null, "Informe o código do produto");
        return id;
    }

    public static String solicitarDescricaoProduto() {
        String descricao = JOptionPane.showInputDialog(null, "Informe a descrição do produto");
        return descricao;
    }

    public static double solicitarPrecoProduto(){
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto"));
        while(preco <= 0) {
            Saida.exibirPrecoInvalido();
            preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto"));
        }
        return preco;
    }

    public static int solicitarContinuarMenu(String titulo){
        String[] opcoes = {"Sim", "Não"};
        JComboBox<String> menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, titulo, JOptionPane.OK_CANCEL_OPTION);
        return menu.getSelectedIndex();
    }

    public static int solicitarQuantidadeProduto(String metodo) {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade para " + metodo));
        while(quantidade <= 0) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida!");
            quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade para " + metodo));
        }
        return quantidade;
    }

    public static int solicitarProdutoParaVender(String[] opcoesMenu){
        JComboBox<String> menu = new JComboBox<>(opcoesMenu);
        JOptionPane.showConfirmDialog(null, menu, "Selecione um produto para atribuir ao estoque", JOptionPane.OK_CANCEL_OPTION);
        return menu.getSelectedIndex();
    }
}
