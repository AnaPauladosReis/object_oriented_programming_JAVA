 import javax.swing.JOptionPane;

	public class EntradaSaida {

	    // Método estático modelo do carro
	    public static String solicitarModelo() {
	        return JOptionPane.showInputDialog("Digite o modelo do veículo:");
	    }

	    // Método estático cor do carro
	    public static String solicitarCor() {
	        return JOptionPane.showInputDialog("Digite a cor do veículo:");
	    }
	}
