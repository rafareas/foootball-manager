import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        System.out.println("+---------------------------+\n\nwelcome to football manager!\n\n+---------------------------+\n");
        Player gabigordo = new Player(82,78,70,75,76,60,70,0,"Atacante","gabigordo",9);
        Player bruninMatador = new Player(35,20,90,9,1,2,1,30,"Goleiro","bruninMatador",7);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(gabigordo.clone());
        Team joguin = new Team(players,"flasco");
        joguin.addPlayer_time(bruninMatador);

        System.out.println(joguin.getNome_time());
        
        for(Player i : joguin.getPlayers()){
            System.out.println(i.getNome()+"\n"+ i.overall_player());
        }

        float ovrlGabi = gabigordo.overall_player();
        float ovrlBrunin = bruninMatador.overall_player();
        System.out.println("Batalha de overall:\n\n"+
                           "Gabigordo x BruninMatador\n"+
                              ovrlGabi +"           "+ovrlBrunin);

        double teste_do_gabi = gabigordo.teste_de_jogada(gabigordo.getRemate());
        System.out.println("\nEle chutou com:"+teste_do_gabi);

    }
}
/*To do:
-comentar as funçoes [feito]

-Classe dos times (
    - construtores, seters and getters [feito]
    - fazer as funcionalidades do time
)

-Classe da partida
*/