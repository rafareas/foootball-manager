import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Team {
    
    /** INSTANCE VARIABLES*/
    
    private List <Player> jogadores;
    private double team_overall;
    private String nome_time;
    
    /** -----------------------------------------------*/
    /** CONSTRUCTORS */

    public Team(){
        this.jogadores = new ArrayList<>();
        this.team_overall = 0; 
        this.nome_time = "";
    }
   
    public Team(List<Player>players,String time){
        this.jogadores = new ArrayList<>();
        this.team_overall = 0;
        
        int i = 0;
        for(Player j : players){
            i++;
            this.jogadores.add(j.clone());
            this.team_overall +=  j.overall();
        }

        this.team_overall /= i;
        this.nome_time = time;
     }
    
     public Team(Team t){
         this.jogadores = t.getPlayers();
         this.team_overall = t.getTeamOverall();
         this.nome_time = t.getNome_time();
     }

    /** -----------------------------------------------*/
    /** GETTERS AND SETERS */ 

    public String getNome_time(){
        return this.nome_time;
    }
    public void setNome_time(String name)
    {
        this.nome_time = name;
    }

    public double getTeamOverall(){
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
    
    /*---------------------------------------------------*/

    /*Recalcula o Overall do time*/
    public void recalcOverall()
    {
        int size = this.jogadores.size();
       
        double soma = 0;
        for (Player j : this.jogadores)
            soma += j.overall();

        if (soma != 0) this.team_overall = soma/size;
        else this.team_overall = 0.0;
    }

    /*Função para garantir que o jogador possui uma camisa valida no time*/
    public void checkShirt(Player p)
    {
        ArrayList<Integer> lst = new ArrayList<>();
        for(Player pl : this.jogadores)
            lst.add(pl.getNumero_jogador());

        while(lst.contains(p.getNumero_jogador()))
        {
            int number = (int) (Math.random() * 100);
            p.setNumero_jogador(number);
        }

    }

    /*Função para incrementar o time com um novo jogador*/
    public void addPlayer_time(Player p){
        if (this.jogadores.contains(p))
            System.out.println(p.getNome()+" já está no time!");

        else
        {
            this.checkShirt(p);
            p.setHistorico(p.getHistorico()+this.getNome_time()+"\n");
            this.jogadores.add(p.clone());
            this.recalcOverall();
        }
    }

    /*Função para remover um determinado jogador do time*/
    public void removePlayer_time(Player p)
    {
        if (this.jogadores.contains(p))
        {
            this.jogadores.remove(p.clone());
            this.recalcOverall();
        }

        else
            System.out.println(p.getNome()+" não está no time!");
        
    }

    /*----------------------------------------------------------------------------------*/

    public void saveToCSV(String fn) throws FileNotFoundException, IOException{
        PrintWriter pw = new PrintWriter(new FileOutputStream(fn));
        pw.flush();
        pw.close(); 
    }

    public void saveToBinary(String fn) throws FileNotFoundException, IOException{
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fn));

        o.writeObject(this);
        o.flush();
        o.close();
    }

    public Team readBinary(String f) throws IOException, ClassNotFoundException{
        ObjectInputStream i = new ObjectInputStream(new FileInputStream(f));
        Team d = (Team) i.readObject();
        i.close();
        return d;
    }
}
