import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        //Titulo do jogo 
        System.out.println("+---------------------------+\n\nwelcome to football manager!\n\n+---------------------------+\n");
    
    /*    
        //Criação de 2 jogadores com seus determinados atributos
        Player jog_1 = new Player(82,78,70,75,76,60,70,0,"Atacante","jog_1",9);
        Player jog_2 = new Player(35,20,90,9,1,2,1,30,"Goleiro","jog_2",7);
        
        //Teste de criação de 1 time com os dados jogadores
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(jog_1.clone());
        Team time = new Team(players,"POO F.C.");
        time.addPlayer_time(jog_2);

        //Informações do time
        System.out.println(time.getNome_time());
        for(Player i : time.getPlayers()){
            System.out.println(i.getNome()+"\n"+ i.overall_player());
        }


        //Cálculo do overall dos jogadores
        float ovrl_1 = jog_1.overall_player();
        float ovrl_2= jog_2.overall_player();
        System.out.println("Batalha de overall:\n\n"+
                           "  1      x      2\n"+
                              ovrl_1 +"           "+ovrl_2);

        //Teste de jogada de um determinado jogador
        double teste_1 = jog_1.teste_de_jogada(jog_1.getRemate());
        System.out.println("\nJog 1 chutou com: "+teste_1);
*/
        Lateral lt = new Lateral("Gerson", 10 , 30 , 73, 42, 57, 45, 17, 82, 51);
        System.out.println("Este é o: "+lt.getNome()+ ". Seu overall é: "+lt.overall());
    }
}
