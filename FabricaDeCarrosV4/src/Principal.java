import javax.swing.JOptionPane;

 class Principal {
    public static void main(String[] args) {
        //métodos -> entrada+saida
        String modelo = EntradaSaida.solicitarModelo();
        String cor = EntradaSaida.solicitarCor();

        //instância -> carro-> dados usuário
        Carro meuCarro = new Carro(modelo, cor);

        JOptionPane.showMessageDialog(null, "Modelo: " + meuCarro.getModelo() + "\nCor: " + meuCarro.getCor());
    }
}