import javax.swing.JOptionPane;

public class EntradaSaida {
	
    public static String solicitarModelo() {
        return JOptionPane.showInputDialog("Digite o modelo do veículo:");
    }

    public static String solicitarCor() {
        return JOptionPane.showInputDialog("Digite a cor do veículo:");
    }

    public static int solicitarAnoFabricacao() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação do veículo:"));
    }

    public static String solicitarTipoCombustivel() {
        return JOptionPane.showInputDialog("Digite o tipo de combustível do veículo:");
    }

    public static String solicitarDirecaoTipo() {
        return JOptionPane.showInputDialog("Digite o tipo de direção do veículo:");
    }

    public static String solicitarCambioTipo() {
        return JOptionPane.showInputDialog("Digite o tipo de câmbio do veículo:");
    }

    //
    public static String escolherTipoCarro() {
        return JOptionPane.showInputDialog("Escolha o tipo de carro a montar:\n1 - Carro\n2 - Carro Esportivo");
    }
}
