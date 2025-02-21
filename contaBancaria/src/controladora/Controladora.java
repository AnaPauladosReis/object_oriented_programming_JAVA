package controladora;

import modelo.Conta;
import visualizacao.EntradaSaida;

public class Controladora {
    private static Conta conta;

    public static void iniciar() {
        conta = new Conta();
        conta.setNomeDoTitular(EntradaSaida.solicitarTitularDaConta());
        conta.setTipoDeConta(EntradaSaida.solicitarTipoDaConta());
        exibirMenu();
    }

    public static void exibirMenu() {
        int opcao;
        do {
            opcao = EntradaSaida.solicitarOpcaoPrograma();
            switch (opcao) {
                case 0:
                    realizarDeposito();
                    break;
                case 1:
                    realizarSaque();
                    break;
                case 2:
                    EntradaSaida.exibirDadosDaConta(conta.gerarDadosDaConta());
                    break;
                case 3:
                    EntradaSaida.exibirExtratoCompleto(conta.gerarExtrato());
                    break;
                case 4:
                    EntradaSaida.exibirExtratos("Deposito", conta.gerarExtratoDepositos());
                    break;
                case 5:
                    EntradaSaida.exibirExtratos("Saque", conta.gerarExtratoSaques());
                    break;
            }
        } while (opcao != 6);
    }

    private static void realizarDeposito() {
        double deposito = EntradaSaida.solicitarInformacoesDeposito();
        if (deposito <= 0) {
            EntradaSaida.exibirInvalido("deposito");
            return;
        }
        conta.gerarSaldo("Deposito", deposito);
        EntradaSaida.exibirSucesso("Deposito");
    }

    private static void realizarSaque() {
        if (conta.getSaldo() == -500) {
            EntradaSaida.exibirLimiteAtingido();
            return;
        }

        double saque = EntradaSaida.solicitarInformacoesSaque();
        if (saque <= 0 || saque > conta.getSaldo() + 500) {
            if (saque <= 0) {
                EntradaSaida.exibirInvalido("saque");
            } else {
                EntradaSaida.exibirLimiteAtingido();
            }
            return;
        }

        conta.gerarSaldo("Saque", saque);
        EntradaSaida.exibirSucesso("Saque");
    }
}