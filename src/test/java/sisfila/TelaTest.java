package sisfila;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import sisfila.pages.TelaPage;

public class TelaTest extends BaseSisfilaTest {

	TelaPage tela;
	
	@Before
	public void setUp() {
		getFactory()
			.resetDatabase()
			.criaCenario()
			.login().get().loginAsRegularUser();
		
		tela = getFactory().tela();
	}

	@Test
	public void insereAlunoComSucesso() {
		tela.get().insereMatriculaNaFila("1");
		
		assertThat(tela.tituloDialog(), containsString("Nome adicionado"));
	}

	@Test
	public void insereDuasVezes() {
		tela.get().insereMatriculaNaFila("1");
		tela.get().insereMatriculaNaFila("1");
		
		assertThat(tela.tituloDialog(), containsString("Você NÃO foi adicionado"));
	}

}
