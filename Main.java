import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String acaoAExecutar = "";
        File arquivo = new File("arquivoDados.csv");
        PesquisaPorNome pesquisa = new PesquisaPorNome(arquivo);
        Scanner leitor = new Scanner(System.in);

        while(!acaoAExecutar.equals("exit")){
            System.out.println("Escolha uma opção:");
            System.out.println("A - Mostrar único ");
            System.out.println("B - Mostrar todos");
            System.out.println("exit - Encerra o programa.");

            String acaoSelecionada = leitor.nextLine();
            pesquisa.menuDeOpcoes(acaoSelecionada);
            acaoAExecutar = acaoSelecionada;
        }
    }   
}
/* Matheus Tsuyoshi Ichimura Takaki - 21353671 */