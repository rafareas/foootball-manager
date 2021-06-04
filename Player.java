import java.lang.Math;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Player{
    
    /** INSTANCE VARIABLES */

    private String nome;
    private int numero_jogador;

    private float remate;
    private float velocidade;
    private float resistencia;
    private float destreza;
    private float impulsao;
    private float jogo_cabeca;
    private float capac_passe;

    //Falta historico de times
    
    /** -----------------------------------------------*/

    /* CONSTRUCTORS */ 

    public Player(){

        this.nome = "n/a";
        this.numero_jogador = 0;
        this.remate = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogo_cabeca = 0;
        this.capac_passe = 0;        
        
    }

    public Player(String nNome, int nnum,float nremate, float nvelocidade, float nresistencia, float ndestreza, 
                    float nimpulsao, float njogo_cabeca, float ncapac_passe){
         
        this.nome = nNome;
        this.numero_jogador = nnum;
        this.remate = nremate;
        this.velocidade = nvelocidade;
        this.resistencia = nresistencia;
        this.destreza = ndestreza;
        this.impulsao = nimpulsao;
        this.jogo_cabeca = njogo_cabeca;
        this.capac_passe = ncapac_passe;
        
    }

    public Player(Player info){

        this.nome = info.getNome();
        this.numero_jogador = info.getNumero_jogador();
        this.remate = info.getRemate();
        this.velocidade = info.getVelocidade();
        this.resistencia = info.getResistencia();
        this.destreza = info.getDestreza();
        this.impulsao = info.getImpulsao();
        this.jogo_cabeca = info.getJogo_cabeca();
        this.capac_passe = info.getCapac_passe();
    }

    /** -----------------------------------------------*/

    /**  GETTERS AND SETERS */

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getNumero_jogador(){
        return this.numero_jogador;
    }

    public void setNumero_jogador(int num){
        this.numero_jogador = num;
    }

    public float getRemate(){
        return this.remate;
    }

    public void setRemate(float rem){
        this.remate = rem;
    }

    public float getVelocidade(){
        return this.velocidade;
    }

    public void setVelocidade(float vel){
        this.velocidade = vel;
    }

    public float getResistencia(){
        return this.resistencia;
    }

    public void setResistencia(float res){
        this.resistencia = res;
    }

    public float getDestreza(){
        return this.destreza;
    }

    public void setDestreza(float dest){
        this.destreza = dest;
    }

    public float getImpulsao(){
        return this.impulsao;
    }

    public void setImpulsao(float imp){
        this.impulsao = imp;
    }

    public float getJogo_cabeca(){
        return this.jogo_cabeca;
    }

    public void setJogo_cabeca(float jc){
        this.jogo_cabeca = jc;
    }

    public float getCapac_passe(){
        return this.capac_passe; 
    }

    public void setCapac_passe(float cp){
        this.capac_passe = cp;
    }
    
    /** -----------------------------------------------*/

    /** EQUALS AND CLONE */
    public boolean equals(Object o){

        if(this == o) return true;
        if((o == null) || this.getClass() != o.getClass())return false;

        Player t = (Player) o;

        return (this.remate == t.getRemate() && this.velocidade == t.getVelocidade() && 
                this.resistencia == t.getResistencia() &&
                this.resistencia == t.getResistencia() && this.destreza == t.getDestreza() && 
                this.impulsao == t.getImpulsao() && 
                this.jogo_cabeca == t.getJogo_cabeca() && this.capac_passe == t.getCapac_passe());
    
    }

    public Player clone(){
        return new Player(this);
    }

    /** -----------------------------------------------*/    
    
}
