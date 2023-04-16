import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author gabriel.tabatinga
 *
 */
class PizzaTest {

	Pizza pizza;
	@BeforeEach
	void init() {
		pizza = new Pizza();
	}
	
	@Test
	void adicionarIngrediente() {
		pizza.adicionarIngrediente();
		assertEquals(4,pizza.getValorAdicionais());
		
	}
	
	@Test
	void adicionarIngredienteAcimaMaximo() {
		for(int i =0;i<10;i++)
			pizza.adicionarIngrediente();
		assertEquals(32,pizza.getValorAdicionais());
		
	}
	
	@Test
	void escolherSaborPizzaCalabresa() {
		pizza.escolherSaborCalabresa();
		assertEquals("Calabresa", pizza.getSabor());
	}
	
	@Test
	void escolherSaborPizzaQueijo() {
		pizza.escolherSaborQueijo();
		assertEquals("Queijo", pizza.getSabor());
	}
	
	@Test
	void escolherSaborPizzaCalabresaDepoisQueijo() {
		pizza.escolherSaborCalabresa();
		pizza.escolherSaborQueijo();
		assertEquals("Queijo", pizza.getSabor());
	}
	
	@Test
	void gerarNotaPizza() {
		assertEquals("Queijo R$25", pizza.getNota());
	}
	
	@Test
	void gerarNotaPizzaComAdicional() {
		pizza.adicionarIngrediente();
		assertEquals("Queijo R$29", pizza.getNota());
	}

}
