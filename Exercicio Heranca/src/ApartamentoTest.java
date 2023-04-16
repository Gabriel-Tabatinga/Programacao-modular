import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
class ApartamentoTest {


	private Apartamento imovel;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		imovel = new Apartamento("rua pedro bairro eustaquio n7", "12345678901", 400, 800000, 2022);
	}
	
	@Test
	void imprimirDados() {
		assertEquals("Imovel: 2\n"
				+ "Endereco: rua pedro bairro eustaquio n7\n"
				+ "Cpf do proprietario: 12345678901\n"
				+ "Ano de Contrucao: 2022\n"
				+ "Valor de venda: 800000.0\n"
				+ "Valor do aluguel: 3600.0", imovel.imprimirDados());
	}

	@Test
	void testarValorAluguel() {
		assertEquals(3600, imovel.valorAluguel());
	}
	
	@Test
	void testarValorAluguelEm2018() {
		Apartamento imovel2 = new Apartamento("rua pedro bairro eustaquio n7", "12345678901", 400, 800000, 2018);
		assertEquals(3420, imovel2.valorAluguel());
	}
	
	@Test
	void testarValorAluguelEm1800() {
		Apartamento imovel2 = new Apartamento("rua pedro bairro eustaquio n7", "12345678901", 400, 800000, 1800);
		assertEquals(2520, imovel2.valorAluguel());
	}
	
	@Test
	void testarValorComissaoAdministradora() {
		assertEquals(432, imovel.comissaoAluguel());
	}

}
