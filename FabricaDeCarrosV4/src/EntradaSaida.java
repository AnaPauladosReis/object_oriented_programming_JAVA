import javax.swing.JOptionPane;

class EntradaSaida {
	
    // Método
    public static String solicitarModelo() {
        return JOptionPane.showInputDialog("Digite o modelo do veículo:");
    }

    // Método
    public static String solicitarCor() {
        return JOptionPane.showInputDialog("Digite a cor do veículo:");
    }
}
