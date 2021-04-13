import java.util.ArrayList;
import java.util.List;
public class Team {
    
    /** INSTANCE VARIABLES*/
    
    private List <Player> jogadores;
    private float team_overall;
    
    /** -----------------------------------------------*/
    /** CONSTRUCTORS */

    public Team(){
        this.jogadores = new ArrayList<>();
        this.team_overall = 0; 
    }
    public Team(List<Player>players){
        this.jogadores = new ArrayList<>();
        this.team_overall = 0;
        int i = 0;
        for(Player j : players){
            i++;
            this.jogadores.add(j.clone());
            this.team_overall += j.overall_player();
        }
        this.team_overall /= i;
     }

     public Team(Team t){
         this.jogadores = t.getPlayers();
         this.team_overall = t.getOverall();
     }

    /** -----------------------------------------------*/
    /** GETTERS AND SETERS */ 

    public float getOverall(){
        return this.team_overall;
    }

    public void setOverall(float ovr){
        this.team_overall = ovr;
    }

    public List <Player> getPlayers(){
        List<Player> time = new ArrayList<>();
        for(Player j : this.jogadores){
            time.add(j.clone());
        }
        return time;
    }

    
    /** -----------------------------------------------*/


}
