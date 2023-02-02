
public class Habilidades {
	/* ATRIBUTOS */
	private String habilidades[];
	private int valores[];
	
	/* CONSTRUTORES */
	public Habilidades() {
		this.habilidades = null;
		this.valores = null;
	}
	
	public Habilidades(String habilidades[], int valores[]) throws Exception {
		if (habilidades.length != valores.length)
			throw new Exception("quantidade de habilidades nao condiz com quantidade de valores fornecidos");
		this.habilidades = habilidades;
		this.valores = valores;
	}

	/* METODOS */
	public String[] getHabilidades() {
		return habilidades;
	}

	public int[] getValores() {
		return valores;
	}
	
	public void updateValorUnico(int valor, int posicao) {
		this.valores[posicao] = valor;
	}
	public void updateValores(int valores[]) {
		this.valores = valores;
	}
}
