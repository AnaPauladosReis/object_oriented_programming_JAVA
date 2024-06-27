import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        //métodos da classe EntradaSaida
        String modelo = EntradaSaida.solicitarModelo();
        String cor = EntradaSaida.solicitarCor();

        //instância da classe Carro - dados usuário
        Carro meuCarro = new Carro(modelo, cor);

        JOptionPane.showMessageDialog(null, "Modelo: " + meuCarro.modelo + "\nCor: " + meuCarro.cor);
    }
}