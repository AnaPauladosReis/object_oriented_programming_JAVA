package modelo;

import java.time.OffsetDateTime;

public class CupomFiscal {

    private String descricaoProduto;
    private int quantidadeProduto;
    private double valorProduto;
    private double valor;
    private String data;

    public void setProductDescription(String descricao) {
        this.descricaoProduto = descricao;
    }

    public String getProductDescription() {
        return descricaoProduto;
    }

    public void setProductQuantity(int quantidade) {
        this.quantidadeProduto = quantidade;
    }

    public int getProductQuantity(){
        return quantidadeProduto;
    }

    public void setProductValue(double valorProduto){
        this.valorProduto = valorProduto;
    }

    public double getProductValue(){
        return valorProduto;
    }

    public void setValue(double valor) {
        this.valor = valor;
    }

    public double getValue(){
        return valor;
    }

    public void setDate(){
        this.data = OffsetDateTime.now().getDayOfMonth() + "/" + OffsetDateTime.now().getMonthValue()
                + "/" + OffsetDateTime.now().getYear();

    }

    public String getDate(){
        return data;
    }
}