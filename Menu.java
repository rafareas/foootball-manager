import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public int menuPrincipal(){
        int opcao = -1;
        showMenuPrincipal();
        while(opcao == -1){
            opcao = lerOpcaoMenu(4);
        }
        if(opcao == 4) opcao = -1;
        return opcao;
    }

    public void showMenuPrincipal(){
        System.out.println("\n *** Menu Principal de Jogo *** \n\n");
        System.out.println("*Opções:\n");
        System.out.println("-> 1. Ver os times do jogo\n");
        System.out.println("-> 2. Fazer uma transferência\n");
        System.out.println("-> 3. Ver o Histórico de times de um jogador\n");
        System.out.println("-> 4. Sair do Jogo\n\n");
    }

    public int lerOpcaoMenu(int nopcoes){
        int op;
        Scanner is = new Scanner(System.in);
        
        System.out.print("Opção: ");
        try {
            op = is.nextInt();
        }
        catch (InputMismatchException e) { // Não foi inscrito um int
            op = -1;
        }
        if (op<=0 || op > nopcoes) {
            System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }

    public String menuTimes(Equipas eq){
        showtimes(eq);
        String time = "";
        while(time.equals("")){
            time = lerTime(eq);
        }
        return time;

    }




    public void showtimes(Equipas eq){
        System.out.println("\n *** Lista de times do Jogo *** \n\n");
        for( String t : eq.getNomes()){
            System.out.println("."+t+"\n");
        }
        System.out.println("\n");
    }
    
    public String lerTime(Equipas eq){
        String op;
        Scanner is = new Scanner(System.in);
        
        System.out.print("Digite um time: ");
        op = is.nextLine();
        if(eq.existeTime(op) == 0){
            op = "";
            System.out.println("Este time não existe, tente novamente\n");
        } 
        
        return op;
    }


    public int menuPlayers(Team t){
        showJogadores(t);
        int op = -1;
        System.out.println("\n\nDeseja fazer o que agora??\n");
        System.out.println("1 -> Voltar para o menu principal\n");
        System.out.println("2 -> Sair do jogo\n");
        while(op == -1){
            op = lerOpcaoMenu(2);
        }
        if(op == 2) op = -1; 
        return op;
    }    

    public void showJogadores(Team t){
        System.out.println("\n *** Elenco: *** \n\n");
        System.out.println("*Overall da equipa: " + t.getTeamOverall() + "\n");
        for (Player p : t.getSetPlayers()){
            System.out.println("| " + p.getNome() + " ( " + p.getNumero_jogador() + " )    Overall: " + p.overall() + "\n");
        }
        System.out.println("\n");
    }
}
