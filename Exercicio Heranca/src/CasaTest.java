import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
class CasaTest {

private Casa imovel;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		imovel = new Casa("rua pedro bairro eustaquio n7", "12345678901", 120, 800000, 2022);
	}
	
	@Test
	void imprimirDados() {
		assertEquals("Imovel: 2\n"
				+ "Endereco: rua pedro bairro eustaquio n7\n"
				+ "Cpf do proprietario: 12345678901\n"
				+ "Ano de Contrucao: 2022\n"
				+ "Valor de venda: 800000.0\n"
				+ "Valor do aluguel: 4010.0", imovel.imprimirDados());
	}

	@Test
	void testarValorAluguel() {
		assertEquals(4010, imovel.valorAluguel());
	}
	
	@Test
	void testarValorAluguelEm2018() {
		Casa imovel2 = new Casa("rua pedro bairro eustaquio n7", "12345678901", 120, 800000, 2018);
		assertEquals(3809.5, imovel2.valorAluguel());
	}
	
	@Test
	void testarValorAluguelEm1800() {
		Casa imovel2 = new Casa("rua pedro bairro eustaquio n7", "12345678901", 120, 800000, 1800);
		assertEquals(2807, imovel2.valorAluguel());
	}
	
	@Test
	void testarValorComissaoAdministradora() {
		assertEquals(481.2, imovel.comissaoAluguel());
	}

}
