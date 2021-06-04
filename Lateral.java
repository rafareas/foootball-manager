public class Lateral extends Player {

	private float cruzamento;

	public Lateral()
	{
		super();
		this.cruzamento = 0;
	}

	public Lateral (String nNome, int nnum,float nremate, float nvelocidade, float nresistencia, float ndestreza, 
    					float nimpulsao, float njogo_cabeca, float ncapac_passe,float ncruz){

    	super(nNome, nnum, nremate, nvelocidade, nresistencia, ndestreza, nimpulsao, njogo_cabeca, ncapac_passe);
    	this.cruzamento = ncruz;
    }

    public float getCruz()
    {
    	return this.cruzamento;
    }

    public void setCruz(float ncruz)
    {
    	this.cruzamento = ncruz;
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

        overall += 0.4   * super.getVelocidade();
        overall += 0.25  * this.getCruz();
        overall += 0.15  * super.getDestreza();
        overall += 0.1   * super.getCapac_passe();
        overall += 0.025 * super.getRemate();
        overall += 0.025 * super.getResistencia();
        overall += 0.025 * super.getImpulsao();
        overall += 0.025 * super.getJogo_cabeca();

        return overall;
    }
    
}
