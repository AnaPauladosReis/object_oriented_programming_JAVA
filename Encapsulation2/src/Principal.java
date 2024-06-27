public class Principal {
    public static void main(String[] args) {
       
        Pessoa pessoa = new Pessoa();

        // método setter
        pessoa.setNome("Ana Paula");

        // método getter 
        System.out.println("Nome: " + pessoa.getNome());
    }
}