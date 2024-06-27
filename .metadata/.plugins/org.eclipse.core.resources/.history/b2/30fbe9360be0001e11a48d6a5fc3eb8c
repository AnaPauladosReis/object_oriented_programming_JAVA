package visualizacao;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {
	
	public static int solicitaOpcao() {
		String [] opcoes = {"Construir casa", "Movimentar portas ou janelas", "Ver informações da casa", "Sair do programa"};
		JComboBox<String>  menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(menu, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
	
	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}
	
	public static String solicitaDescricao(String descricao, int ordem) {
		if(ordem==0) {
			return JOptionPane.showInputDialog("Informe a descricao da" +descricao);
		}else {
			return JOptionPane.showInputDialog("Informe a descricao da" +ordem+" "+descricao);
		}
	}
	
	public static String solicitaCor() {
		return JOptionPane.showInputDialog("Informe a cor da casa");
	}
	
	public static int solicitaQuantidadeDeAberturas(String abertura) {
		return Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de " +abertura));
	}
	
	public static int solicitaEstado(String tipoDeAbertura) {
		String[] opcoes = {"Fechada", "Aberta"};
		
		
		return JOptionPane.showOptionDialog(null, "Informe o estado da " +tipoDeAbertura, "Estado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, opcoes, opcoes[1]);
	}
		
}
