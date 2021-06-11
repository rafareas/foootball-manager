import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Equipas {

	/*INSTANCE VARIABLES*/
    private Map <String,Team> times;

    /*  CONSTRUCTORS   */

    public Equipas(){
    	this.times = new HashMap<>();
    }

    public Equipas(Map<String,Team> ntimes){
    	this.times = new HashMap<>();

    	for (Team t : ntimes.values())
    		this.times.put(t.getNome_time(),t.clone());
    }

    public Equipas(Equipas e)
    {
    	this.times = e.getTimes();
    }

    /*---------------------------------------------------*/

    /*CLASS FUNCTIONS*/


    public Team getElenco(String t){
        return this.times.get(t);
    }


    public Map<String,Team> getTimes()
    {
    	Map<String,Team> ntimes = new HashMap<>();
    	for (Team t : this.times.values())
    		ntimes.put(t.getNome_time(),t.clone());

    	return ntimes;
    }

    public int existeTime(String t){
        return (this.times.containsKey(t))? 1 : 0 ;
    }

    public Set<String> getNomes(){
        return getTimes().keySet();
    }

    public void addTeam(Team t)
    {
    	this.times.put(t.getNome_time(), t.clone());
    }

    public Equipas clone()
    {
    	return new Equipas(this);
    }

    public void transfer(Player p, String oldTeam, String newTeam) throws TransferError
    {
    	try{
    		this.times.get(oldTeam).removePlayer_time(p);
    	}
    	catch(NoPlayerException n){
            throw new TransferError(p.getNome());
        }

    	try{
    		this.times.get(newTeam).addPlayer_time(p);
    	}
    	catch(JogadorExisteException j){
            throw new TransferError(p.getNome());
        }

    }

    

    /*-------------------------------------------------------*/
}
