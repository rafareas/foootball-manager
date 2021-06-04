public class Defesa extends Player {

	private float protecao;

    public Defesa()
	{
		super();
		this.protecao = 0;
	}

	public Defesa (String nNome, int nnum,float nremate, float nvelocidade, float nresistencia, float ndestreza, 
    					float nimpulsao, float njogo_cabeca, float ncapac_passe,float nprot){

    	super(nNome, nnum, nremate, nvelocidade, nresistencia, ndestreza, nimpulsao, njogo_cabeca, ncapac_passe);
    	this.protecao = nprot;
    }

    public float getProt()
    {
    	return this.protecao;
    }

    public void setProt(float nprot)
    {
    	this.protecao = nprot;
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

        overall += 0.4   * this.getProt();
        overall += 0.25  * super.getCapac_passe();
        overall += 0.15  * super.getResistencia();
        overall += 0.1   * super.getJogo_cabeca();
        overall += 0.025 * super.getRemate();
        overall += 0.025 * super.getVelocidade();
        overall += 0.025 * super.getDestreza();
        overall += 0.025 * super.getImpulsao();

        return overall;
    }
}
