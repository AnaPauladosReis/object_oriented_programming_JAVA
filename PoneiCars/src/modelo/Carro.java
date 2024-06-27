package modelo;

public class Carro {
    private String modelo;
    private String cor;

    public Carro(String modelo, String cor) {
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }
}