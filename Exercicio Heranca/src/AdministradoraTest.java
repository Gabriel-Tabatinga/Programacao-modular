import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
class AdministradoraTest {

	private Administradora admin;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		admin = new Administradora();
	}

	@Test
	void valoresPorProprietarioCasaCompatibilidadeDaHeranca() {
		Casa casa = new Casa("rua pedro bairro eustaquio n7", "12345678901", 120, 800000, 2022);
		admin.addImovel(casa);
		assertEquals("Total arrecadado: 4010.0\n"
				+ "Total Liquido: 3528.8", admin.totalArrecPorPropriet("12345678901"));
	}
	@Test
	void valoresPorProprietarioVariosImoveis() {
		Casa casa = new Casa("rua pedro bairro eustaquio n7", "12345678901", 120, 800000, 2022);
		Apartamento apartamento = new Apartamento("rua claudio bairro manoel n101", "12345678901", 400, 800000, 2018);
		Casa casa2 = new Casa("rua joao bairro caram n2", "12345678901", 120, 800000, 2018);
		admin.addImovel(casa);
		admin.addImovel(apartamento);
		admin.addImovel(casa2);
		assertEquals("Total arrecadado: 11239.5\n"
				+ "Total Liquido: 9890.76", admin.totalArrecPorPropriet("12345678901"));
	}
	
	
	
	@Test
	void imprimirDadosImoveis2018() {
		Casa casa = new Casa("rua pedro bairro eustaquio n7", "12345678901", 120, 800000, 2022);
		Apartamento apartamento = new Apartamento("rua claudio bairro manoel n101", "10987654321", 400, 800000, 2018);
		admin.addImovel(casa);
		admin.addImovel(apartamento);
		assertEquals("Imovel: 2\n"
				+ "Endereco: rua claudio bairro manoel n101\n"
				+ "Cpf do proprietario: 10987654321\n"
				+ "Ano de Contrucao: 2018\n"
				+ "Valor de venda: 800000.0\n"
				+ "Valor do aluguel: 3420.0", admin.imprimirDadosImovelPorAno(2018));
		
	}
	@Test
	void imprimirDadosImoveis2018Varios() {
		Casa casa = new Casa("rua pedro bairro eustaquio n7", "12345678901", 120, 800000, 2022);
		Apartamento apartamento = new Apartamento("rua claudio bairro manoel n101", "10987654321", 400, 800000, 2018);
		Casa casa2 = new Casa("rua joao bairro caram n2", "12345678901", 120, 800000, 2018);
		admin.addImovel(casa);
		admin.addImovel(apartamento);
		admin.addImovel(casa2);
		assertEquals("Imovel: 8\n"
				+ "Endereco: rua claudio bairro manoel n101\n"
				+ "Cpf do proprietario: 10987654321\n"
				+ "Ano de Contrucao: 2018\n"
				+ "Valor de venda: 800000.0\n"
				+ "Valor do aluguel: 3420.0\n"
				+ "Imovel: 9\n"
				+ "Endereco: rua joao bairro caram n2\n"
				+ "Cpf do proprietario: 12345678901\n"
				+ "Ano de Contrucao: 2018\n"
				+ "Valor de venda: 800000.0\n"
				+ "Valor do aluguel: 3809.5", admin.imprimirDadosImovelPorAno(2018));
		
	}
	
}
