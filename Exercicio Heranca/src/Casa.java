import java.util.Calendar;

/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
public class Casa extends Imovel{
	private double valorSegIncendio;
	private static final double PERC_ALUGUEL = 0.005;
	
	/**
	 * @param endereco endereco do imovel
	 * @param cpfProprietario cpf do proprietario do imovel
	 * @param valorVenda valor total do imovel
	 * @param anoContrucao ano no qual o imovel foi contruido
	 * @param valorSegIncendio valor anual do seguro incendio
	 * */
	Casa(String endereco, String cpfProprietario, double valorSegIncendio, double valorVenda, int anoContrucao){
		super(endereco, cpfProprietario, valorVenda, anoContrucao);
		this.valorSegIncendio = valorSegIncendio;
	}
	
	@Override
	/**
	 * Calcular valor total do aluguel ja com seus descontos
	 * 
	 * @return valor total do aluguel
	 * 
	 * */
	public double valorAluguel(){
		double valor = ((valorVenda*PERC_ALUGUEL) + (valorSegIncendio / 12));
		Calendar dataAtual = Calendar.getInstance();
		int ano = dataAtual.get(Calendar.YEAR);
		int diferenca = ano - getAnoContrucao();
		double desconto = 0;
		if( diferenca >= 5) {
			while(diferenca >= 5 && desconto < DESC_MAX_DATA) {
				desconto += 0.05;
				diferenca -= 5;
			}
		}
		return valor - (valor * desconto);
	}
	
	

}
