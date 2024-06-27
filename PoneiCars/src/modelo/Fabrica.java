package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Fabrica {
    private ArrayList<Carro> carros;

    public Fabrica() {
        carros = new ArrayList<>();
    }

    public void fabricarCarro(Carro carro) {
        carros.add(carro);
    }

    public void venderCarro() {
        if (!carros.isEmpty()) {
            carros.remove(0);
            System.out.println("Carro vendido com sucesso!");
        } else {
            System.out.println("Não há carros para vender.");
        }
    }

   /* public void verInformacoesCarros() {
        if (!carros.isEmpty()) {
            System.out.println("Informações dos carros:");
            for (Carro carro : carros) {
            	JOptionPane.showMessageDialog(null, "Modelo: " + carro.getModelo() + ", Cor: " + carro.getCor(), null, 0, null);
            }
        } else {
        	JOptionPane.showMessageDialog(null,"Não há carros para mostrar informações.");
        }
    }*/
    
    public void verInformacoesCarros() {
        if (!carros.isEmpty()) {
            System.out.println("Informações dos carros:");

            for (int i = 0; i < carros.size(); i++) {
                Carro carro = carros.get(i);
                String mensagem = "Modelo: " + carro.getModelo() + ", Cor: " + carro.getCor();
                JOptionPane.showMessageDialog(null, mensagem);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há carros para mostrar informações.");
        }
    }
}