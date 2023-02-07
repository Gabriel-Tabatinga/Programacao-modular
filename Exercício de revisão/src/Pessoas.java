
public class Pessoas{
	
	/* ATRIBUTOS */
	private String nome;
	private Habilidades habilidade;
	
	
	/* CONSTRUTORES */
	public Pessoas() {

	}
	
	public Pessoas(String nome) {
		this.nome = nome;
		this.habilidade = new Habilidades();
	}
	
	public Pessoas(String nome, int valores[]) throws Exception {
		this.nome = nome;
		try {
			this.habilidade = new Habilidades(valores);
		}catch(Exception e) {
			throw new Exception("Erro ao criar a classe habilidades");
		}

	}
	
	/* METODOS */
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValores(int i[]) {
		this.habilidade.setValores(i);
	}

	public Habilidades getHabilidade() {
		return habilidade;
	}

}
