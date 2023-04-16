/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
public class Pizza {


	private int valorAdicionais;
	private String sabor;
	
	Pizza(){
		this.sabor = "Queijo";
		this.valorAdicionais = 0;
	}

	public void adicionarIngrediente() {
		if(valorAdicionais != 32)
			this.valorAdicionais += 4;
		
	}

	public int getValorAdicionais() {
		return valorAdicionais;
	}

	public void escolherSaborCalabresa() {
		this.sabor = "Calabresa";
	}

	public String getSabor() {
		return this.sabor;
	}

	public void escolherSaborQueijo() {
		this.sabor = "Queijo";
		
	}

	public String getNota() {
		int total = valorAdicionais + 25;
		String nota = sabor + " R$" + total;
		return nota;
	}
	
}
