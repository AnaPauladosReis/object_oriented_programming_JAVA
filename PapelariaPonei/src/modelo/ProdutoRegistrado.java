package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProdutoRegistrado{
	
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static ArrayList<Produto> getProdutoRegistrado() {
        return produtos;
    }

    public static void registrarProduto(String id, String descricao, double preco){
        Produto produto = new Produto();
        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produtos.add(produto);
    }

    public static String listarProdutosRegistrados() {
        String lista = "Codigo | Produto | Valor ";

        for(Produto produto: produtos){
            lista += "\n" + produto.getId() +" | " + produto.getDescricao()
                    + " | " + String.format("%.2f",produto.getPreco());
        }

        return lista;
    }

    public static boolean verificarIdExistente(String id){
        for(Produto produto: produtos){
            if(produto.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarProdutosRegistradosVazios(){
        return produtos.isEmpty();
    }

    public static String[] criarMenuProdutosRegistrados() {

        String[] opcoesMenu = new String[produtos.size()];

        for (Produto produto : produtos) {
            opcoesMenu[produtos.indexOf(produto)] = produto.getDescricao() + " | " + produto.getPreco() + " | " +
                    produto.getQuantidade();
        }
        return opcoesMenu;
    }

    // CRUD para Produtos Registrados
    
    
    public static void removerProdutoRegistrado(String id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId().equals(id)) {
                produtos.remove(i);
                JOptionPane.showMessageDialog(null, "Produto removido do registro com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado no registro.");
    }

    public static void atualizarProdutoRegistrado(String id, String novaDescricao, double novoPreco) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId().equals(id)) {
                produtos.get(i).setDescricao(novaDescricao);
                produtos.get(i).setPreco(novoPreco);
                JOptionPane.showMessageDialog(null, "Produto atualizado no registro com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado no registro.");
    }
}