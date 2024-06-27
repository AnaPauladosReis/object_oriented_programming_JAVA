package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class ProdutoEstocado {
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void adicionarProdutoAoEstoque(int quantidade, Produto produto) {
        if (!produtos.contains(produto)) {
            produtos.add(produto);
        }

        produto.setQuantidade(quantidade + produto.getQuantidade());
    }

    public static String listarProdutosEstoque() {
        String lista = "Produto | Valor | Quantidade";

        for (Produto produto : produtos) {
            lista += "\n" + produto.getDescricao() + " | " + String.format("%.2f", produto.getPreco()) + " | "
                    + produto.getQuantidade();
        }

        return lista;
    }

    public static void venderProdutoEstoque(int indiceProduto, int quantidade) {

        double valor = 0;
        Produto produtoParaVender = produtos.get(indiceProduto); 
        if (produtoParaVender.getQuantidade() - quantidade < 0) {
            JOptionPane.showMessageDialog(null, "Você não possui quantidade suficiente desse " +
                    "produto para vender!");
           return;
        } else if (produtoParaVender.getQuantidade() - quantidade == 0) {
            produtoParaVender.setQuantidade(0);
            produtos.remove(indiceProduto);
        } else {
            produtoParaVender.setQuantidade(produtoParaVender.getQuantidade() - quantidade);
        }

        valor = produtoParaVender.getPreco() * quantidade;

        ListaCupomFiscal.criarCupomFiscal(produtoParaVender.getDescricao(), produtoParaVender.getPreco(), valor, quantidade);
        
    }

    public static boolean verificarProdutosEstoqueVazios() {
        return produtos.isEmpty();
    }

    public static String[] criarMenuProdutosEstoque(){
        String[] opcoesMenu = new String[produtos.size()];

        for (Produto produto : produtos) {
            opcoesMenu[produtos.indexOf(produto)] = produto.getDescricao() + " | " + String.format("%.2f",produto.getPreco()) + " | " +
                    produto.getQuantidade();
        }
        return opcoesMenu;
    }
}