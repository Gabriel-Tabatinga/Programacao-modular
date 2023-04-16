import java.util.Calendar;

/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
public class Imovel {

	private String endereco;
	private String cpfProprietario;
	private final int id;
	private static int parseId;
	
	protected double valorVenda;
	protected int anoContrucao;
	protected final static double DESC_MAX_DATA = 0.3;
	protected final static double COMISSAO_IMOBI = 0.12;
	
	static {
		parseId = 1;
	}
	
	/**
	 * @param endereco endereco do imovel
	 * @param cpfProprietario cpf do proprietario do imovel
	 * @param valorVenda valor total do imovel
	 * @param anoContrucao ano no qual o imovel foi contruido
	 * 
	 * */
	Imovel(String endereco, String cpfProprietario, double valorVenda, int anoContrucao){
		this.id = parseId++;
		this.endereco = endereco;
		this.cpfProprietario = cpfProprietario;
		this.valorVenda = valorVenda;
		this.anoContrucao = anoContrucao;
	}
	
	public int getAnoContrucao(){
		return this.anoContrucao;
	}
	public String getCpfProprietario(){
		return this.cpfProprietario;
	}
	
	/**
	 * Calcular valor total do aluguel ja com seus descontos
	 * 
	 * @return valor total do aluguel
	 * 
	 * */
	public double valorAluguel() {
		//valor não informado para imovel generico, então utilizei 0,5% fixo
		double valor = valorVenda* 0.005;
		
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
	
	/**
	 * Comissao da administradora sobre o aluguel
	 * 
	 * @return valor total comissao
	 * */
	public double comissaoAluguel() {
		return valorAluguel()*COMISSAO_IMOBI;
	}
	
	/**
	 * Imprimir dados do aluguel
	 * 
	 * @return String com os dados
	 * */
	public String imprimirDados() {
		StringBuilder str = new StringBuilder("Imovel: " + this.id);
		str.append("\nEndereco: " + this.endereco);
		str.append("\nCpf do proprietario: " + this.cpfProprietario);
		str.append("\nAno de Contrucao: " + this.anoContrucao);
		str.append("\nValor de venda: " + this.valorVenda);
		str.append("\nValor do aluguel: " + valorAluguel());
		
		return str.toString();
	}
	
}
