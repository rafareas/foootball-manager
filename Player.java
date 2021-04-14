import java.lang.Math;

public class Player{
    
    /** INSTANCE VARIABLES */

    private float remate;
    private float velocidade;
    private float resistencia;
    private float destreza;
    private float impulsao;
    private float jogo_cabeca;
    private float capac_passe;
    private float elasticidade;

    private String posicao;
    private String nome;
    private int numero_jogador;
    
    /** -----------------------------------------------*/

    /* CONSTRUCTORS */ 

    public Player(){
        this.remate = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogo_cabeca = 0;
        this.capac_passe = 0;
        this.elasticidade = 0;
        this.posicao = "n/a";
        this.nome = "n/a";
        this.numero_jogador = 0;
    }

    public Player(float nremate, float nvelocidade, float nresistencia, float ndestreza, float nimpulsao, float njogo_cabeca, float ncapac_passe,
                    float nelasticidade, String nposicao, String nNome, int nnum){
            
        this.remate = nremate;
        this.velocidade = nvelocidade;
        this.resistencia = nresistencia;
        this.destreza = ndestreza;
        this.impulsao = nimpulsao;
        this.jogo_cabeca = njogo_cabeca;
        this.capac_passe = ncapac_passe;
        this.elasticidade = nelasticidade;
        this.posicao = nposicao;
        this.nome = nNome;
        this.numero_jogador = nnum;
    }

    public Player(Player info){
        this.remate = info.getRemate();
        this.velocidade = info.getVelocidade();
        this.resistencia = info.getResistecia();
        this.destreza = info.getDestreza();
        this.impulsao = info.getImpulsao();
        this.jogo_cabeca = info.getJogo_cabeca();
        this.capac_passe = info.getCapac_passe();
        this.elasticidade = info.getElasticidade();
        this.posicao = info.getPosicao();
        this.nome = info.getNome();
        this.numero_jogador = info.getNumero_jogador();
    }

    /** -----------------------------------------------*/

    /**  GETTERS AND SETERS */

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

    public float getResistecia(){
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

    public float getElasticidade(){
        return this.elasticidade;
    }

    public void setElasticidade(float elas){
        this.elasticidade = elas;
    }

    public String getPosicao(){
        return this.posicao;
    }

    public void setPosicao(String pos){
        this.posicao = pos;
    }

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
    
    /** -----------------------------------------------*/

    /** EQUALS AND CLONE */
    public boolean equals(Object o){

        if(this == o) return true;
        if((o == null) || this.getClass() != o.getClass())return false;

        Player t = (Player) o;

        return (this.remate == t.getRemate() && this.velocidade == t.getVelocidade() && this.resistencia == t.getResistecia() &&
                this.resistencia == t.getResistecia() && this.destreza == t.getDestreza() && this.impulsao == t.getImpulsao() && 
                this.jogo_cabeca == t.getJogo_cabeca() && this.capac_passe == t.getCapac_passe() && 
                this.elasticidade == t.getElasticidade() && this.posicao.equals(t.getPosicao()));
    
    }

    public Player clone(){
        return new Player(this);
    }

    /** -----------------------------------------------*/

    /** Calcula o overall do jogador , que é a média de todos os seus atributos  */

    public float overall_player(){
        float remate=this.getRemate();
        float velocidade=this.getVelocidade();
        float resistencia=this.getResistecia();
        float destreza=this.getDestreza();
        float impulsao=this.getImpulsao();
        float jogo_cabeca=this.getJogo_cabeca();
        float capac_passe=this.getCapac_passe();
        float elasticidade=this.getElasticidade();

        float sum = (remate+velocidade+resistencia+destreza+impulsao+jogo_cabeca+capac_passe) ;
        sum = (elasticidade>0)? (sum+elasticidade)/8 : sum/7;

        return sum;
    }

    /*Criei essa função para realizar os testes quando um jogador fizer uma jogada
    Ela pega um random entre 0 e 0.9999999... e multiplica com o atributo selecionado
    Ou seja, se quisermos saber um chute pro gol colocamos "remate" no atributo, se tocar "capac_passe" e etc.
    Deu bom
    Cumprimentos,
    Vitor
    */
    public double teste_de_jogada(float atributo){
        double teste = Math.random();
        return teste*atributo;

    }
    
}
