package modelo;
public class Carro extends CarroBase {
    private String direcaoTipo;

    public Carro(String modelo, String cor, int anoFabricacao, String tipoCombustivel, String direcaoTipo) {
        super(modelo, cor, anoFabricacao, tipoCombustivel);
        this.direcaoTipo = direcaoTipo;
    }

    public String getDirecaoTipo() {
        return direcaoTipo;
    }

    public void setDirecaoTipo(String direcaoTipo) {
        this.direcaoTipo = direcaoTipo;
    }
}
