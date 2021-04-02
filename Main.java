
public class Main{
    public static void main(String[] args){
        System.out.println("+---------------------------+\n\nwelcome to football manager!\n\n+---------------------------+\n");
        Player gabigordo = new Player(82,78,70,75,76,60,70,0,"Atacante");
        Player bruninMatador = new Player(35,20,90,9,1,2,1,30,"Goleiro");

        float ovrlGabi = gabigordo.overall_player();
        float ovrlBrunin = bruninMatador.overall_player();
        System.out.println("Batalha de overall:\n\n"+
                           "Gabigordo x BruninMatador\n"+
                              ovrlGabi +"           "+ovrlBrunin);

    }
}