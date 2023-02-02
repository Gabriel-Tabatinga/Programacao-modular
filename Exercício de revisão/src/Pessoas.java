
public class Pessoas {
	
	/* ATRIBUTOS */
	private String nome;
	private Habilidades habilidade;
	
	
	/* CONSTRUTORES */
	public Pessoas() {
		nome = null;
		habilidade = null;
	}
	
	public Pessoas(String nome, Habilidades habilidade) {
		this.nome = nome;
		this.habilidade = habilidade;
	}
	
	public Pessoas(String nome, String habilidades[], int valores[]) throws Exception {
		this.nome = nome;
		try {
			this.habilidade = new Habilidades(habilidades, valores);
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

	public Habilidades getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidades habilidade) {
		this.habilidade = habilidade;
	}
}
