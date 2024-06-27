import javax.swing.JOptionPane;

class EntradaSaida {
	
    // Métodos estáticos modelo do carro
    public static String solicitarModelo() {
        return JOptionPane.showInputDialog("Digite o modelo do veículo:");
    }

    // Métodos estáticos cor do carro
    public static String solicitarCor() {
        return JOptionPane.showInputDialog("Digite a cor do veículo:");
    }
}
