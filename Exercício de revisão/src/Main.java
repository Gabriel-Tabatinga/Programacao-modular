

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Inicio entrada Habilidades //
		ArquivoTextoLeitura input = null;
		try {
			input = new ArquivoTextoLeitura("data1.txt");
		} catch (Exception e) {;}
		
		String leitura;
		String [] saveInput = new String[999];
		int i=0;
		leitura = input.ler();
		saveInput[i] = leitura;
		while(leitura != null) {
			i++;
			//System.out.println(leitura);
			leitura = input.ler();
			saveInput[i] = leitura;
		}
		String [] inputHabilidades =  new String[i];
		for(int j = 0; j < i; j++) {
		    inputHabilidades[j] = saveInput[j];
		    //System.out.println(j);
		}
		input.fecharArquivo();
		
		int tamHabilidades = i;
		
		// Fim entrada Habilidades //
		
		// Inicio entrada pessoas //
		ArquivoTextoLeitura input2 = null;
		try {
			input2 = new ArquivoTextoLeitura("data2.txt");
		} catch (Exception e) {;}
		
		leitura = null;
		String [] saveInput2 = new String[99999];
		i=0;
		leitura = input2.ler();
		saveInput2[i] = leitura;
		while(leitura != null) {
			i++;
			//System.out.println(leitura);
			leitura = input2.ler();
			saveInput2[i] = leitura;
		}
		String [] inputPessoas =  new String[i];
		for(int j = 0; j < i; j++) {
		    inputPessoas[j] = saveInput2[j];
		}
		int tamPessoas = i;
		
		// Fim entrada pessoas //
		
		// Inicialização classe Habilidades //
		
		Habilidades.habilidades = inputHabilidades;

		// Fim da inicialização classe Habilidades //
		
		// Inicialização classe Pessoas //
		Pessoas pessoas[] = new Pessoas[tamPessoas];
		
		for(int j = 0; j < tamPessoas; j++) {
			String [] save = new String[tamHabilidades + 1];
			save = inputPessoas[j].split(";");
			
			int [] k = new int[tamHabilidades];
			for(int o = 0; o < tamHabilidades;o++) {
				save[o+1] = save[o+1].replaceAll(" ","");
				k[o] = Integer.parseInt(save[o+1]);
			}
			pessoas[j] = new Pessoas(save[0], k);
			
		}
		// Fim da inicialização classe Pessoas //
		
		// Testes
		
		/*for(int teste = 0;teste<tamPessoas;teste++) {
			System.out.print("\n"+pessoas[teste].getNome());
			for(int teste2 = 0;teste2<tamHabilidades;teste2++) {
				System.out.print(";"+pessoas[teste].getHabilidade().getValores(teste2));
			}
		}
		
		for(int teste3 = 0;teste3<Habilidades.habilidades.length;teste3++) {
			System.out.println(Habilidades.habilidades[teste3]);
		}*/
		
		// Fim dos testes
		
		//Inserir arvore
		ArvoreBinaria arvore = new ArvoreBinaria();
		for(int j = 0; j<tamPessoas;j++) {
			arvore.inserirAVL(pessoas[j]);
		}
		
		
		// Tela inicial
		new Screen(arvore);

	}

}
