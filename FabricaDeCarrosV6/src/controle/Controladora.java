package controle;
import javax.swing.JOptionPane;
import modelo.Carro;
import modelo.CarroEsportivo;
import visualizacao.EntradaSaida;

public class Controladora {
	
	public void exibeMenu() {
		
		String escolha = EntradaSaida.escolherTipoCarro(); //primeiro passo

        String modelo = EntradaSaida.solicitarModelo();
        String cor = EntradaSaida.solicitarCor();
        int anoFabricacao = EntradaSaida.solicitarAnoFabricacao();
        String tipoCombustivel = EntradaSaida.solicitarTipoCombustivel();

        if (escolha.equals("1")) {
            String direcaoTipo = EntradaSaida.solicitarDirecaoTipo();
            Carro meuCarro = new Carro(modelo, cor, anoFabricacao, tipoCombustivel, direcaoTipo);
            JOptionPane.showMessageDialog (null, "Informações do Carro:\nModelo: " + meuCarro.getModelo() + "\nCor: " + meuCarro.getCor() + "\nAno de Fabricação: " + meuCarro.getAnoFabricacao() + "\nTipo de Combustível: " + meuCarro.getTipoCombustivel() + "\nTipo de Direção: " + meuCarro.getDirecaoTipo());
        } else if (escolha.equals("2")) {
            String cambioTipo = EntradaSaida.solicitarCambioTipo();
            CarroEsportivo meuCarroEsportivo = new CarroEsportivo(modelo, cor, anoFabricacao, tipoCombustivel, cambioTipo);
            JOptionPane.showMessageDialog(null, "Informações do Carro Esportivo:\nModelo: " + meuCarroEsportivo.getModelo() + "\nCor: " + meuCarroEsportivo.getCor() + "\nAno de Fabricação: " + meuCarroEsportivo.getAnoFabricacao() + "\nTipo de Combustível: " + meuCarroEsportivo.getTipoCombustivel() + "\nTipo de Câmbio: " + meuCarroEsportivo.getCambioTipo());
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida");
        }
	}
}
