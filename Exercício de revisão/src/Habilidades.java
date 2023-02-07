
public class Habilidades {
	/* ATRIBUTOS */
	static String habilidades[];
	private int valores[];
	
	/* CONSTRUTORES */
	public Habilidades() {
		this.valores = null;
	}
	
	public Habilidades(int valores[]) throws Exception {
		if (habilidades.length != valores.length)
			throw new Exception("quantidade de habilidades nao condiz com quantidade de valores fornecidos");
		this.valores = valores;
	}

	/* METODOS */
	public String getHabilidades(int i) {
		return habilidades[i];
	}

	public int[] getValores() {
		return valores;
	}
	
	public int getValores(int i) {
		return valores[i];
	}
	
	public void setValores(int i[]) {
		this.valores = i;
	}
	
	public void updateValorUnico(int valor, int posicao) {
		this.valores[posicao] = valor;
	}
	public void updateValores(int valores[]) {
		this.valores = valores;
	}
	
	
}
