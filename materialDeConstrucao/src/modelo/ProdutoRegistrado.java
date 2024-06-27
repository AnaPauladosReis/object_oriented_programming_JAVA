package modelo;

import java.util.ArrayList;

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
}
