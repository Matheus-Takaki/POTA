import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PesquisaPorNome {

    private String[] arquivoDados = new String[5824];
    private int numeroDeComparacao = 0;
    private int indiceDoArray = 0;

    public PesquisaPorNome(File userData) {
        try {
            Scanner leitor = new Scanner(userData);

            while (leitor.hasNextLine()) {
                String data = leitor.nextLine();
                arquivoDados[indiceDoArray] = data;
                indiceDoArray++;
            }
            leitor.close();

        } catch (IOException error) {
            System.err.println(error.getMessage());
            System.exit(0);
        }
    }

    public void menuDeOpcoes(String action){
        Scanner leitor = new Scanner(System.in);
        String nome = "";

        System.out.println("Nome para pesquisa: ");
        nome = leitor.nextLine();

        if (action.equals("A")){
            pegarPrimeiroNomeEncontrado(nome);
        } else if(action.equals("B")){
            procurarTodosOsDados(nome);
        } else if (action.equals("exit")) {
            System.out.println("Programa foi finalizado");
        } else {
            System.out.println("Opção não localizada, programa foi finalizado para evitar erros!");
        } 
    
    }

    public void pegarDadosDoUsuario(String dadosDoUsuario){
        String[] dadosDoUsuario1 = dadosDoUsuario.split(",");
        
        for (int i = 0; i < dadosDoUsuario1.length; i++) {
            System.out.println(dadosDoUsuario1[i]);
        }
    }

    public void pegarPrimeiroNomeEncontrado(String nome) {
        numeroDeComparacao = 0;
        boolean encontrouPessoa = false;
        for (int i = 0; i < arquivoDados.length; i++) {
            numeroDeComparacao++;
            if (arquivoDados[i].contains(nome)) {
                pegarDadosDoUsuario(arquivoDados[i]);
                encontrouPessoa = true;
            }
        }
        if(!encontrouPessoa) System.err.println("Usuário não localizado.");
    }
    
    public void procurarTodosOsDados(String nome) {
        boolean encontrouPessoa = false;
        for (int i = 0; i < arquivoDados.length; i++) {
            if (arquivoDados[i].contains(nome)) {
                pegarDadosDoUsuario(arquivoDados[i]);
                encontrouPessoa = true;
                break; 
            }
        }
        if(!encontrouPessoa) System.err.println("Usuário não localizado.");

    }
}
