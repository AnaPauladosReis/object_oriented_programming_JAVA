package controladora;
import modelo.*;
import visualizacao.*;

public class Controladora {
    private Fabrica fabrica;
    private EntradaSaida entradaSaida;

    public Controladora() {
        fabrica = new Fabrica();
        entradaSaida = new EntradaSaida();
    }

    public void exibirMenu() {
        int opcaoSelecionada;

        do {
            opcaoSelecionada = entradaSaida.solicitarOpcaoMenu();
            switch (opcaoSelecionada) {
                case 1:
                    fabricarCarros();
                    break;
                case 2:
                    fabrica.venderCarro();
                    break;
                case 3:
                    fabrica.verInformacoesCarros();
                    break;
                case 4:
                    entradaSaida.mostrarMensagem("Encerrando o programa...");
                    break;
                default:
                    entradaSaida.mostrarMensagem("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcaoSelecionada != 4);
    }

    private void fabricarCarros() {
        int quantidade = entradaSaida.solicitarQuantidadeCarros();
        if (quantidade > 0) {
            for (int i = 0; i < quantidade; i++) {
                String modelo = entradaSaida.solicitarModeloCarro(i + 1);
                String cor = entradaSaida.solicitarCorCarro(i + 1);
                fabrica.fabricarCarro(new Carro(modelo, cor));
            }
            entradaSaida.mostrarMensagem(quantidade + " carro(s) fabricado(s) com sucesso!");
        } else {
            entradaSaida.mostrarMensagem("Nenhum carro foi fabricado.");
        }
    }
}