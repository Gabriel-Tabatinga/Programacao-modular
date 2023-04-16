import java.util.LinkedList;

/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
public class Administradora {
	private LinkedList<Imovel> Imoveis;
	
	Administradora (){
		this.Imoveis = new LinkedList<Imovel>();
	}
	
	/**
	 * Adicionar imovel ao sistema da administradora
	 * 
	 * @param imovel Imovel a adicionar
	 * 
	 * */
	public void addImovel(Imovel imovel) {
		Imoveis.add(imovel);
	}
	
	/**
	 * Ganho total da administradora nas comissoes de alugueis
	 * 
	 * @return total de comissao sobre os alugueis
	 * */
	public double ganhoTotal() {
		double total = 0;
		for(Imovel imovel : this.Imoveis) {
			total += imovel.comissaoAluguel();
		}
		return total;
	}
	
	/**
	 * Valor total arrecadado bruto e liquido sobre os alugueis do proprietario
	 * 
	 * @param cpf cpf do proprietario
	 * 
	 * @return Valor arrecadado(bruto) e Valor Liquido(descontando a comissao)
	 * 
	 * */
	public String totalArrecPorPropriet(String cpf) {
		double total = 0;
		double comissao = 0;
		for(Imovel imovel : this.Imoveis) {
			if(imovel.getCpfProprietario().equals(cpf)) {
				total += imovel.valorAluguel();
				comissao += imovel.comissaoAluguel();
			}
		}
		comissao = (comissao - total) * (-1);
		return "Total arrecadado: " + total + "\nTotal Liquido: " + comissao;
	}
	
	/**
	 * Imprimir dados de imoveis pelo seu ano de construcao
	 * 
	 * @param ano ano de construcao para impressao
	 * 
	 * @return String com toda a impressao
	 * 
	 * */
	public String imprimirDadosImovelPorAno(int ano) {
		StringBuilder str = new StringBuilder();
		for(Imovel imovel : this.Imoveis) {
			if(imovel.getAnoContrucao() == ano) {
				str.append(imovel.imprimirDados());
				str.append("\n");
			}
		}
		str.deleteCharAt(str.length()-1);
		return str.toString();
	}
}
