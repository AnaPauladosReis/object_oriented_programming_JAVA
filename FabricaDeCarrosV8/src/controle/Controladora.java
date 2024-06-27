package controle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.*;
import visualizacao.EntradaSaida;

public class Controladora {
    
    private List<CarroBase> carros = new ArrayList<>();
    
    public void exibeMenu() {
        
        int opcao;
        
        do {
            opcao = EntradaSaida.escolherTipoCarro();
            
            switch(opcao){
                
                case 0:
                    adicionarCarroComum(); 
                    break;
                    
                case 1:
                    adicionarCarroEsportivo();
                    break;
                
                case 2:                
                    listarCarros();
                    break;
            }
        } while (opcao != 3);
        
        EntradaSaida.exibeMsgEncerraPrograma();
        
        System.exit(0);
    }
    
    private void adicionarCarroComum() {
        String modelo = EntradaSaida.solicitarModelo();
        String cor = EntradaSaida.solicitarCor();
        int anoFabricacao = EntradaSaida.solicitarAnoFabricacao();
        String tipoCombustivel = EntradaSaida.solicitarTipoCombustivel();
        String direcaoTipo = EntradaSaida.solicitarDirecaoTipo();
        
        Carro meuCarro = new Carro(modelo, cor, anoFabricacao, tipoCombustivel, direcaoTipo);
        carros.add(meuCarro); //adiciona no novo Array
        JOptionPane.showMessageDialog(null, "Carro comum cadastrado com sucesso!");
    }
    
    private void adicionarCarroEsportivo() {
        String modelo = EntradaSaida.solicitarModelo();
        String cor = EntradaSaida.solicitarCor();
        int anoFabricacao = EntradaSaida.solicitarAnoFabricacao();
        String tipoCombustivel = EntradaSaida.solicitarTipoCombustivel();
        String cambioTipo = EntradaSaida.solicitarCambioTipo();
        
        CarroEsportivo meuCarroEsportivo = new CarroEsportivo(modelo, cor, anoFabricacao, tipoCombustivel, cambioTipo);
        carros.add(meuCarroEsportivo);
        JOptionPane.showMessageDialog(null, "Carro esportivo cadastrado com sucesso!");
    }
    
    private void listarCarros() {
        StringBuilder listaCarros = new StringBuilder();
        for (CarroBase carro : carros) {
            if (carro instanceof Carro) {
                listaCarros.append("Carro Comum: ").append(carro.getModelo()).append(" ").append(carro.getCor()).append("\n");
            } else if (carro instanceof CarroEsportivo) {
                listaCarros.append("Carro Esportivo: ").append(carro.getModelo()).append(" ").append(carro.getCor()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, listaCarros.toString(), "Lista de Carros", JOptionPane.INFORMATION_MESSAGE);
    }
}