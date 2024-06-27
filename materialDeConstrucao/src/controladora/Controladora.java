package controladora;

import modelo.ProdutoEstocado;
import modelo.CupomFiscal;
import modelo.ListaCupomFiscal;
import modelo.Produto;
import modelo.ProdutoRegistrado;
import visualizacao.Entrada;
import visualizacao.Saida;



public class Controladora {
	
    public static void mostrarMenu() {
        int opcaoMenu = 0;

        do {
            String[] opcoes = {"Registro de Produtos", "Estoque de Produtos", "Cupons Fiscais", "Sair do programa"};
            opcaoMenu = Entrada.solicitarMenu(opcoes, "Material de construção");
            int opcaoSubMenu = Entrada.solicitarSubMenu(opcaoMenu);
            switch (opcaoMenu) {
                case 0: {
                    switch (opcaoSubMenu) {
                        case 0: {
                           
                            int opcao = 0;
                            String id = "";
                            String descricao = "";
                    double preco = 0;
                            do {
                                id = Entrada.solicitarIdProduto();
                                while (ProdutoRegistrado.verificarIdExistente(id)) {
                                    Saida.exibirIdJaExiste();
                                    id = Entrada.solicitarIdProduto();
                                }
                                descricao = Entrada.solicitarDescricaoProduto();
                                preco = Entrada.solicitarPrecoProduto();
                                ProdutoRegistrado.registrarProduto(id, descricao, preco);
                                opcao = Entrada.solicitarContinuarMenu("Continuar registrando produtos?");
                            } while (opcao != 1);

                            break;
                        }
                        case 1: {
                            
                            if (ProdutoRegistrado.verificarProdutosRegistradosVazios()) {
                                Saida.exibirNaoTem("produtos registrados");
                            } else {
                                String lista = ProdutoRegistrado.listarProdutosRegistrados();
                                Saida.exibirLista(lista);
                            }
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (opcaoSubMenu) {
                        case 0: {
                           
                            if (ProdutoRegistrado.verificarProdutosRegistradosVazios()) {
                                Saida.exibirNaoTem("produtos registrados");
                            } else {
                                int opcao = 0;
                                do {
                                    String[] opcoesMenuProdutosRegistrados = ProdutoRegistrado.criarMenuProdutosRegistrados();
                                    int indiceProduto = Entrada.solicitarProdutoParaVender(opcoesMenuProdutosRegistrados); 
                                    Produto produto = ProdutoRegistrado.getProdutoRegistrado().get(indiceProduto); 

                                    int quantidade = Entrada.solicitarQuantidadeProduto("adicionar ao estoque");

                                    ProdutoEstocado.adicionarProdutoAoEstoque(quantidade, produto);
                                    opcao = Entrada.solicitarContinuarMenu("Continuar adicionando produtos ao estoque?");
                                } while (opcao != 1);
                            }
                            break; // subMenu
                        }
                        case 1: {
                          
                            if (ProdutoEstocado.verificarProdutosEstoqueVazios()) {
                                Saida.exibirNaoTem("produtos no estoque");
                            } else {
                                String lista = ProdutoEstocado.listarProdutosEstoque();
                                Saida.exibirLista(lista);
                            }
                            break; // subMenu
                        }
                        case 2: {
                            // Vender um produto - criar cupom fiscal (data, descrição do produto, quantidade, valor)
                            if (ProdutoEstocado.verificarProdutosEstoqueVazios()) {
                                Saida.exibirNaoTem("produtos no estoque");
                            } else {
                                String[] opcoesMenu = ProdutoEstocado.criarMenuProdutosEstoque();
                                int indiceProduto = Entrada.solicitarMenu(opcoesMenu, "Vender Produtos");

                                int quantidade = Entrada.solicitarQuantidadeProduto("vender");

                                ProdutoEstocado.venderProdutoEstoque(indiceProduto, quantidade);
                                Saida.exibirCupomFiscal(ListaCupomFiscal.cuponsFiscais.get((ListaCupomFiscal.cuponsFiscais.size() - 1)));
                            }
                            break; // subMenu
                        }
                    }
                    break; // menu
                }
                case 2: {
                    if (ListaCupomFiscal.cuponsFiscais.isEmpty()) {
                        Saida.exibirNaoTem("cupons fiscais");
                    } else {
                        String lista = "Data | Produto | Valor do Produto | Quantidade | Valor Total";
                        for (CupomFiscal cupomFiscal : ListaCupomFiscal.cuponsFiscais) {
                            lista += "\n" + cupomFiscal.getDate() + " | " + cupomFiscal.getProductDescription() + " | " + String.format("%.2f", cupomFiscal.getProductValue())
                                    + " | " + cupomFiscal.getProductQuantity() + " | " + String.format("%.2f", cupomFiscal.getValue());
                        }

                        Saida.exibirLista(lista);
                    }
                    break;
                }
            }

        } while (opcaoMenu != 3);
        Saida.exibirFimPrograma();
        System.exit(0);
    }
}