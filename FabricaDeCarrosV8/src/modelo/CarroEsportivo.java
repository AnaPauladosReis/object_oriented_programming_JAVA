package modelo;
public class CarroEsportivo extends CarroBase {
    private String cambioTipo;

    public CarroEsportivo(String modelo, String cor, int anoFabricacao, String tipoCombustivel, String cambioTipo) {
        super(modelo, cor, anoFabricacao, tipoCombustivel);
        this.cambioTipo = cambioTipo;
    }

    public String getCambioTipo() {
        return cambioTipo;
    }

    public void setCambioTipo(String cambioTipo) {
        this.cambioTipo = cambioTipo;
    }
}
