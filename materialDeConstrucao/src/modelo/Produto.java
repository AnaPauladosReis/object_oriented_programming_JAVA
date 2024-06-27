package modelo;

public class Produto {
    private String id;
    private String descricao;
    private double preco;
    private int quantidade;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }
}
