package modelo;

import java.util.ArrayList;

public class ListaCupomFiscal {
    public static ArrayList<CupomFiscal> cuponsFiscais = new ArrayList<>();

    public static void criarCupomFiscal(String descricao, double precoProduto, double valor, int quantidade ) {
        CupomFiscal cupomFiscal = new CupomFiscal();
        cupomFiscal.setDate();
        cupomFiscal.setProductDescription(descricao);
        cupomFiscal.setProductValue(precoProduto);
        cupomFiscal.setValue(valor);
        cupomFiscal.setProductQuantity(quantidade);

        cuponsFiscais.add(cupomFiscal);
    }
}