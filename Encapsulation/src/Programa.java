import java.util.Scanner;

public class Programa {
    private static final int MAX_FLOWERS = 10;
    private static int contador = 0;
    private static int identificador = 100;

    private static String[] nomeFlor = new String[MAX_FLOWERS];
    private static String[] estacaoFlor = new String[MAX_FLOWERS];
    private static String[] cuidadosFlor = new String[MAX_FLOWERS];
    private static String[] ambienteFlor = new String[MAX_FLOWERS];
    private static int[] identificaFlor = new int[MAX_FLOWERS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao sistema Plantando Flores.");
            displayMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFlores(scanner);
                    break;
                case 2:
                    atualizarFlores(scanner);
                    break;
                case 3:
                    listarFlores();
                    break;
                case 4:
                    estacaoFlores();
                    break;
                case 5:
                    excluirFlores(scanner);
                    break;
                case 6:
                    sair();
                    scanner.close(); 
                    return;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--------------------|MENU PRINCIPAL|-------------------");
        System.out.println("1 - Cadastrar flores.");
        System.out.println("2 - Atualizar cadastro.");
        System.out.println("3 - Listar flores.");
        System.out.println("4 - Flores por estação.");
        System.out.println("5 - Excluir cadastro.");
        System.out.println("6 - Sair.");
        System.out.println("-------------------------------------------------------");
        System.out.print("Digite a opção desejada: ");
    }

    private static void cadastrarFlores(Scanner scanner) {
        if (contador < MAX_FLOWERS) {
            System.out.println("\n-------------------------------------------------------");
            System.out.println("---------------|CADASTRO DE FLORES|--------------------");
            String auxiliar;

            do {
                System.out.print("Digite o nome da flor: ");
                auxiliar = scanner.next();

                if (!isFlowerNameAlreadyExists(auxiliar)) {
                    nomeFlor[contador] = auxiliar;
                } else {
                    System.out.println("Nome da flor já cadastrado.");
                    System.out.println("Para alterações no cadastro acesse: Menu Principal -> Opção 2 - Atualizar Cadastro\n");
                }
            } while (isFlowerNameAlreadyExists(auxiliar));

            System.out.print("Informe a estação de floração: ");
            estacaoFlor[contador] = scanner.next();

            System.out.print("Informe os cuidados necessários: ");
            cuidadosFlor[contador] = scanner.next();

            System.out.print("Informe se a flor é de ambiente Interno ou Externo: ");
            ambienteFlor[contador] = scanner.next();

            System.out.println("\nFlor cadastrada com sucesso!");

            identificaFlor[contador] = identificador;

            contador++;
            identificador++;
        } else {
            System.out.println("Limite de flores atingido. Não é possível cadastrar mais flores.");
        }
    }

    private static boolean isFlowerNameAlreadyExists(String name) {
        for (int i = 0; i < contador; i++) {
            if (nomeFlor[i] != null && nomeFlor[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void listarFlores() {
        System.out.println("\n--------------------|LISTAR FLORES|-------------------");

        if (contador > 0) {
            for (int i = 0; i < contador; i++) {
                if (identificaFlor[i] >= 100) {
                    displayFlowerDetails(i);
                }
            }

            if (contador == 0) {
                System.out.println("Não existem flores cadastradas!");
            }
        } else {
            System.out.println("Não existem flores cadastradas!");
        }

        System.out.println("\n--------------------------------------------------------");
    }

    private static void estacaoFlores() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n----------------|FLORES POR ESTAÇÃO|-------------------");
        System.out.println("Selecione a estação de floração");
        System.out.println("1 - Primavera.");
        System.out.println("2 - Verão.");
        System.out.println("3 - Outono.");
        System.out.println("4 - Inverno.");
        System.out.println("-------------------------------------------------------");

        int option = scanner.nextInt();

        for (int i = 0; i < contador; i++) {
            if (option == 1 && "primavera".equalsIgnoreCase(estacaoFlor[i])) {
                displayFlowerDetails(i);
            } else if (option == 2 && "verao".equalsIgnoreCase(estacaoFlor[i])) {
                displayFlowerDetails(i);
            } else if (option == 3 && "outono".equalsIgnoreCase(estacaoFlor[i])) {
                displayFlowerDetails(i);
            } else if (option == 4 && "inverno".equalsIgnoreCase(estacaoFlor[i])) {
                displayFlowerDetails(i);
            }
        }
    }

    private static void displayFlowerDetails(int index) {
        System.out.println("ID: " + identificaFlor[index]);
        System.out.println("Nome: " + nomeFlor[index]);
        System.out.println("Estação: " + estacaoFlor[index]);
        System.out.println("Cuidados: " + cuidadosFlor[index]);
        System.out.println("Ambiente: " + ambienteFlor[index]);
        System.out.println();
    }

    private static void excluirFlores(Scanner scanner) {
        System.out.println("\n--------------------|EXCLUIR FLORES|-------------------");

        System.out.print("Digite a ID da flor: ");
        int identificadorDesejado = scanner.nextInt();
        boolean achou = false;

        for (int i = 0; i < contador; i++) {
            if (identificadorDesejado == identificaFlor[i]) {
                identificaFlor[i] = 0;
                nomeFlor[i] = "";
                estacaoFlor[i] = "";
                cuidadosFlor[i] = "";
                ambienteFlor[i] = "";

                achou = true;
                System.out.println("Flor excluída com sucesso!");
            }
        }

        if (!achou) {
            System.out.println("ID inexistente!");
        }

        System.out.println("\n--------------------------------------------------------");
    }

    private static void atualizarFlores(Scanner scanner) {
        System.out.println("\n--------------------|ATUALIZAR FLOR|-------------------");

        System.out.print("Digite a ID da flor: ");
        int identificadorDesejado = scanner.nextInt();
        boolean achou = false;

        for (int i = 0; i < contador; i++) {
            if (identificadorDesejado == identificaFlor[i]) {
                System.out.print("Digite o nome da Flor: ");
                nomeFlor[i] = scanner.next();

                System.out.print("Informe a estação de floração: ");
                estacaoFlor[i] = scanner.next();

                System.out.print("Informe os cuidados necessários: ");
                cuidadosFlor[i] = scanner.next();

                System.out.print("Informe se a flor é de ambiente Interno ou Externo: ");
                ambienteFlor[i] = scanner.next();

                achou = true;
                System.out.println("\nFlor atualizada com sucesso!");
            }
        }

        if (!achou) {
            System.out.println("ID inexistente!");
        }

        System.out.println("\n--------------------------------------------------------");
    }

    private static void sair() {
        System.out.println("\nObrigado e volte sempre.");
    }
}
