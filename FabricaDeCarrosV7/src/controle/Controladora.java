package controle;
import javax.swing.JOptionPane;
import modelo.*;
import visualizacao.EntradaSaida;

public class Controladora {
	    
	    public void exibeMenu() {
	        
	        int opcao;
	        
	        do {
	            opcao = EntradaSaida.escolherTipoCarro();
	            
	            if (opcao != 2) {
	                String modelo = EntradaSaida.solicitarModelo();
	                String cor = EntradaSaida.solicitarCor();
	                int anoFabricacao = EntradaSaida.solicitarAnoFabricacao();
	                String tipoCombustivel = EntradaSaida.solicitarTipoCombustivel();
	                
	                switch(opcao){
	                    
	                    case 0:
	                        String direcaoTipo = EntradaSaida.solicitarDirecaoTipo();
	                        Carro meuCarro = new Carro(modelo, cor, anoFabricacao, tipoCombustivel, direcaoTipo);
	                        JOptionPane.showMessageDialog(null, "Informações do Carro:\nModelo: " + meuCarro.getModelo() + "\nCor: " + meuCarro.getCor() + "\nAno de Fabricação: " + meuCarro.getAnoFabricacao() + "\nTipo de Combustível: " + meuCarro.getTipoCombustivel() + "\nTipo de Direção: " + meuCarro.getDirecaoTipo());
	                        break;
	                        
	                    case 1:
	                        String cambioTipo = EntradaSaida.solicitarCambioTipo();
	                        CarroEsportivo meuCarroEsportivo = new CarroEsportivo(modelo, cor, anoFabricacao, tipoCombustivel, cambioTipo);
	                        JOptionPane.showMessageDialog(null, "Informações do Carro Esportivo:\nModelo: " + meuCarroEsportivo.getModelo() + "\nCor: " + meuCarroEsportivo.getCor() + "\nAno de Fabricação: " + meuCarroEsportivo.getAnoFabricacao() + "\nTipo de Combustível: " + meuCarroEsportivo.getTipoCombustivel() + "\nTipo de Câmbio: " + meuCarroEsportivo.getCambioTipo());
	                        break;
	                }
	            }
	        } while (opcao != 2);
	        
	        EntradaSaida.exibeMsgEncerraPrograma();
	        
	        System.exit(0);
	    }
	}

