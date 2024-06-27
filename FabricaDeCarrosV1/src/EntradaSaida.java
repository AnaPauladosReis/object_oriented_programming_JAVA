import java.util.Scanner; 

public class EntradaSaida {
    
	// Método estático para solicitar o modelo do veículo.
    public static String solicitarModelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        return modelo;
    }

    // Método estático para solicitar a cor do veículo.
    public static String solicitarCor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a cor do veículo: ");
        String cor = scanner.nextLine();
        return cor;
    }
  
}
