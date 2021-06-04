public class GuardaRedes extends Player {

	private float elasticidade;

	public GuardaRedes(){
		super();
		this.elasticidade = 0;
	}
    
    public GuardaRedes (String nNome, int nnum,float nremate, float nvelocidade, float nresistencia, float ndestreza, 
    					float nimpulsao, float njogo_cabeca, float ncapac_passe,float nelast){

    	super(nNome, nnum, nremate, nvelocidade, nresistencia, ndestreza, nimpulsao, njogo_cabeca, ncapac_passe);
    	this.elasticidade = nelast;
    }

    public float getElast()
    {
    	return this.elasticidade;
    }

    public void setElast(float nelast)
    {
    	this.elasticidade = nelast;
    }

    /*Calcula o Overall do jogador por media ponderada ,onde os pesos são:
    -----0.400 para o atributo mais imortante
    -----0.250 para o segundo
    -----0.150 para o terceiro
    -----0.100 para o quarto
    -----0.025 para os restantes 
    */

    public double overall()
    {
        double overall = 0;

     	overall += 0.4   * this.getElast();
        overall += 0.25  * super.getResistencia();
        overall += 0.15  * super.getCapac_passe();
        overall += 0.1   * super.getVelocidade();
        overall += 0.025 * super.getRemate();
        overall += 0.025 * super.getDestreza();
        overall += 0.025 * super.getImpulsao();
        overall += 0.025 * super.getJogo_cabeca();

     	return overall;
    }

}
