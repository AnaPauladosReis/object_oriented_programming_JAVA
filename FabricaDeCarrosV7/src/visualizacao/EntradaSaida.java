package visualizacao;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {
	
	
	
	public static int escolherTipoCarro() {
        String[] opcoes = {"Carro Popular", "Carro Esportivo", "Sair do Programa"};
        JComboBox<String> menu = new JComboBox<>(opcoes);

        int opcaoSelecionada = JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

        if (opcaoSelecionada == JOptionPane.CANCEL_OPTION || opcaoSelecionada == JOptionPane.CLOSED_OPTION) {
            return 2; 
        } else {
            return menu.getSelectedIndex();
        }
    }
    
    public static void exibeMsgEncerraPrograma() {
    	JOptionPane.showMessageDialog(null, "O programa será fechado!");
    }
    
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
   
 }


