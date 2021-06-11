import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Team {
    
    /** INSTANCE VARIABLES*/
    
    private Map <Integer,Player> jogadores;
    private double team_overall;
    private String nome_time;
    
    /** -----------------------------------------------*/
    /** CONSTRUCTORS */

    public Team(){
        this.jogadores = new HashMap<>();
        this.team_overall = 0; 
        this.nome_time = "";
    }
   
    public Team(Map<Integer,Player>players,String time){
        this.jogadores = new HashMap<>();
        this.team_overall = 0;
        
        int i = 0;
        for(Player j : players.values()){
            i++;
            this.jogadores.put(j.getNumero_jogador(),j.clone());
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

    public Team(String s){
        this.jogadores = new HashMap<>();
        this.team_overall = 0; 
        this.nome_time = s;
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

    public Map <Integer,Player> getPlayers(){
        Map<Integer,Player> time = new HashMap<>();
        for(Player j : this.jogadores.values()){
            time.put(j.getNumero_jogador(),j.clone());
        }
        return time;
    }

    public Collection<Player> getSetPlayers(){
        return this.jogadores.values();
    }
    
    /*---------------------------------------------------*/

    /*Recalcula o Overall do time*/
    public void recalcOverall()
    {
        int size = this.jogadores.size();
       
        double soma = 0;
        for (Player j : this.jogadores.values())
            soma += j.overall();

        if (soma != 0) this.team_overall = soma/size;
        else this.team_overall = 0.0;
    }

    /*Função para garantir que o jogador possui uma camisa valida no time*/
    public void checkShirt(Player p)
    {
        ArrayList<Integer> lst = new ArrayList<>();
        for(Player pl : this.jogadores.values())
            lst.add(pl.getNumero_jogador());

        while(lst.contains(p.getNumero_jogador()))
        {
            int number = (int) (Math.random() * 100);
            p.setNumero_jogador(number);
        }

    }

    // Função que verifica se o nome do jogador já existe
    public int existeNome(String nome){
        Iterator<Player> it = this.jogadores.values().iterator(); // percorre os valores da lista
        int flag = 0;
        while (it.hasNext() && flag == 0) { // enquanto houver elementos na lista
            if(it.next().getNome().equals(nome))
                flag = 1;
        }
        return flag;
    }
    
    /*Função para incrementar o time com um novo jogador*/
    public void addPlayer_time(Player p) throws JogadorExisteException{
        if (this.existeNome(p.getNome()) == 1)
            throw new JogadorExisteException(p.getNome());
        else
        {
            this.checkShirt(p);
            p.setHistorico(p.getHistorico()+this.getNome_time()+"\n");
            this.jogadores.put(p.getNumero_jogador(),p.clone());
            this.recalcOverall();
        }
    }

    /*Função para remover um determinado jogador do time*/
    public void removePlayer_time(Player p) throws NoPlayerException
    {
        if (this.jogadores.containsKey(p.getNumero_jogador()))
        {
            this.jogadores.remove(p.getNumero_jogador());
            this.recalcOverall();
        }

        else
            throw new NoPlayerException(p.getNome());
        
    }

    /*Função clone*/
    public Team clone()
    {
        return new Team(this);
    }

    /*----------------------------------------------------------------------------------*/
    /*
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
    */
}
