package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.*;
import visualizacao.EntradaSaida;

public class Principal {

    public static void main(String[] args) {
        Controladora controladora = new Controladora();
        controladora.exibeMenu();
    }
}