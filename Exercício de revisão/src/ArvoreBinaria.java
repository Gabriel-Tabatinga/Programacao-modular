import java.util.Arrays;

public class ArvoreBinaria {

	private No raiz;
	private int comparacoes;
	private int movimentacoes;
	/*private String[] passouPesquisa = new String[30];*/
	private String maior[];
	private int maiorHabili;
	private String melhorMedia[];
	private int contador = 0;
	private int melhorMediaInt;
	
	public ArvoreBinaria() {
		
		raiz = null;
		comparacoes = 0;
		movimentacoes = 0;
	}
	
	public int getMovimentacoes() {
		return movimentacoes;
	}

	public int getComparacoes() {
		return comparacoes;
	}
	
	/*public void printPassouPesquisa() {
		//IMPRIMIR MODELO [The 100] - [Game of Thrones] - [Anne] - [12 Monkeys]
		for(int i=0;i<contador;i++) {
			System.out.print("[" + this.passouPesquisa[i] +"] ");
			if(!(i<contador-1)) {
				System.out.print("- ");
			}
		}
		passouPesquisa = null;
		this.contador = 0;
	}*/

	public Pessoas pesquisar(String chave) {
		return pesquisar(this.raiz, chave);
	}
	
	private Pessoas pesquisar(No raizSubarvore, String chave) {
		String nome;
		if (raizSubarvore == null)
			return null;
		else if (chave.compareTo(raizSubarvore.getItem().getNome()) == 0) 
		{
			nome = raizSubarvore.getItem().getNome();
			System.out.print("[" + nome +"] - ");
			this.comparacoes++;
			return raizSubarvore.getItem();
		}
		else if (chave.compareTo(raizSubarvore.getItem().getNome()) > 0) {
			nome = raizSubarvore.getItem().getNome();
			System.out.print("[" + nome +"] - ");
			this.comparacoes++;
			return pesquisar(raizSubarvore.getDireita(), chave);
		}
		else {
			nome = raizSubarvore.getItem().getNome();
			System.out.print("[" + nome +"] - ");
			this.comparacoes++;
			return pesquisar(raizSubarvore.getEsquerda(), chave);
		}
	}
	
	public void inserirAVL(Pessoas novo) throws Exception {
		this.raiz = inserirAVL(this.raiz, novo);
	}
	
	private No inserirAVL(No raizSubarvore, Pessoas novo) throws Exception{
		
		if (raizSubarvore == null)
			raizSubarvore = new No(novo);
		else if (novo.getNome().compareTo(raizSubarvore.getItem().getNome()) == 0)
			throw new Exception("N�o foi poss�vel inserir o item na �rvore: chave j� inseriada anteriormente!");
		else if (novo.getNome().compareTo(raizSubarvore.getItem().getNome()) < 0) {
			raizSubarvore.setEsquerda(inserirAVL(raizSubarvore.getEsquerda(), novo));
		}
		else {
			raizSubarvore.setDireita(inserirAVL(raizSubarvore.getDireita(), novo));
		}
			
		return balancear(raizSubarvore);
	}
	
	public void inserir(Pessoas novo) throws Exception {
		this.raiz = inserir(this.raiz, novo);
	}
	
	private No inserir(No raizSubarvore, Pessoas novo) throws Exception{
		
		if (raizSubarvore == null)
			raizSubarvore = new No(novo);
		else if (novo.getNome().compareTo(raizSubarvore.getItem().getNome()) == 0)
			throw new Exception("N�o foi poss�vel inserir o item na �rvore: chave j� inseriada anteriormente!");
		else if (novo.getNome().compareTo(raizSubarvore.getItem().getNome()) < 0) {
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));
		}
		else {
			raizSubarvore.setDireita(inserir(raizSubarvore.getDireita(), novo));
		}
			
		return raizSubarvore;
	}
	
	public void remover(String chaveRemover) throws Exception {
		this.raiz = remover(this.raiz, chaveRemover);
	}
	
	private No remover(No raizSubarvore, String chaveRemover) throws Exception {
		
		if (raizSubarvore == null)
			throw new Exception("N�o foi poss�vel remover o item da �rvore: chave n�o encontrada!");
		else if (chaveRemover.compareTo(raizSubarvore.getItem().getNome()) == 0) {
			if (raizSubarvore.getEsquerda() == null)
				raizSubarvore = raizSubarvore.getDireita();
			else if (raizSubarvore.getDireita() == null)
				raizSubarvore = raizSubarvore.getEsquerda();
			else
				raizSubarvore.setEsquerda(antecessor(raizSubarvore, raizSubarvore.getEsquerda()));
		} else if (chaveRemover.compareTo(raizSubarvore.getItem().getNome()) > 0)
			raizSubarvore.setDireita(remover(raizSubarvore.getDireita(), chaveRemover));
		else
			raizSubarvore.setEsquerda(remover(raizSubarvore.getEsquerda(), chaveRemover));
			
		return raizSubarvore;
	}
	
	private No antecessor(No noRetirar, No raizSubarvore) {
		
		if (raizSubarvore.getDireita() != null)
			raizSubarvore.setDireita(antecessor(noRetirar, raizSubarvore.getDireita()));
		else {
			noRetirar.setItem(raizSubarvore.getItem());
			raizSubarvore = raizSubarvore.getEsquerda();
		}	
		
		return raizSubarvore;
	}
	
	public void caminhamentoEmOrdem() {
		caminhamentoEmOrdem(this.raiz);
	}

	private void caminhamentoEmOrdem(No raizSubarvore) {
		
		if (raizSubarvore != null) {
			caminhamentoEmOrdem(raizSubarvore.getEsquerda());
			//System.out.println(raizSubarvore.getItem().getNome());
			caminhamentoEmOrdem(raizSubarvore.getDireita());
		}
	}
	
	public void encontrarMaior(int i) {
		encontrarMaior(this.raiz, i);
	}

	private void encontrarMaior(No raizSubarvore, int i) {
		
		if (raizSubarvore != null) {
			encontrarMaior(raizSubarvore.getEsquerda(), i);
			if(raizSubarvore.getItem().getHabilidade().getValores(i) > maiorHabili) {
				maiorHabili = raizSubarvore.getItem().getHabilidade().getValores(i);
				contador=0;
				Arrays.fill(maior, null);
				this.maior[contador] = raizSubarvore.getItem().getNome();
			}else if(raizSubarvore.getItem().getHabilidade().getValores(i) == maiorHabili) {
				contador++;
				this.maior[contador] = raizSubarvore.getItem().getNome();
			}
			encontrarMaior(raizSubarvore.getDireita(), i);
		}
	}
	
	
	public void encontrarMedia() {
		encontrarMedia(this.raiz);
	}

	private void encontrarMedia(No raizSubarvore) {
		
		if (raizSubarvore != null) {
			encontrarMedia(raizSubarvore.getEsquerda());
			int soma = 0;
			for(int i = 0; i< Habilidades.habilidades.length;i++) {
				soma += raizSubarvore.getItem().getHabilidade().getValores(i);
			}
			if(soma > melhorMediaInt) {
				melhorMediaInt = soma;
				Arrays.fill(melhorMedia, null);
				contador = 0;
				melhorMedia[contador] = raizSubarvore.getItem().getNome();
			}else if(soma == melhorMediaInt) {
				contador++;
				melhorMedia[contador] = raizSubarvore.getItem().getNome();
			}
			encontrarMedia(raizSubarvore.getDireita());
		}
	}
	
	public int getAltura(){
	      return getAltura(raiz, 0);
	   }


   public int getAltura(No no, int altura){
      if(no == null){
         altura--;
      } else {
         int alturaEsq = getAltura(no.getEsquerda(), altura + 1);
         int alturaDir = getAltura(no.getDireita(), altura + 1);
         altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
      }
      return altura;
   }
   
   public static No balancear(No no) {
        if (no != null) {
            int fator = no.getNivel(no.getDireita()) - no.getNivel(no.getEsquerda());
            if (Math.abs(fator) <= 1) {
                no.setNivel();
            } else if (fator == 2) {
                int fatorFilhoDir = no.getNivel(no.getDireita().getDireita()) - no.getNivel(no.getDireita().getEsquerda());
                if (fatorFilhoDir == -1) {
                    no.setDireita(rotacionarDir(no.getDireita()));
                }
                no = rotacionarEsq(no);
            } else if (fator == -2) {
                int fatorFilhoEsq = no.getNivel(no.getEsquerda().getDireita()) - no.getNivel(no.getEsquerda().getEsquerda());
                if (fatorFilhoEsq == 1) {
                    no.setEsquerda(rotacionarEsq(no.getEsquerda()));
                }
                no = rotacionarDir(no);
            } 
        }
        return no;
    }

    private static No rotacionarDir(No no) {
        No noEsq = no.getEsquerda();
        No noEsqDir = noEsq.getDireita();

        noEsq.setDireita(no);
        no.setEsquerda(noEsqDir);
        no.setNivel(); // Atualizar o nivel do no
        noEsq.setNivel(); // Atualizar o nivel do noEsq

        return noEsq;
    }

    private static No rotacionarEsq(No no) {
        No noDir = no.getDireita();
        No noDirEsq = noDir.getEsquerda();

        noDir.setEsquerda(no);
        no.setDireita(noDirEsq);

        no.setNivel(); // Atualizar o nivel do no
        noDir.setNivel(); // Atualizar o nivel do noDir
        return noDir;
    } 
    
public String[] umaHabilidade(String habilidade) {
		
		int denomin = 0;
		boolean flag = true;
		while(flag) {
			if(Habilidades.habilidades[denomin] == habilidade) {
				flag = false;
			}else {
				denomin++;
			}
		}
		this.maior = new String[99];
		this.maiorHabili=0;
		this.contador=0;
		encontrarMaior(denomin);
		
		return maior;
		
	}
	public String umaObrigUmaImp(String obrigatorio, String importante) {
		
		
		return null;
	}

	public String[] conjuntohabili() {
		melhorMediaInt = 0;
		this.melhorMedia = new String[99];
		this.melhorMedia[0] = raiz.getItem().getNome();
		encontrarMedia();
		return melhorMedia;
	}
}
