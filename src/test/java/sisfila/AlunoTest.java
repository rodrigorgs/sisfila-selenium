package sisfila;

import static org.junit.Assert.assertThat;

import org.junit.Before;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import sisfila.pages.AdminAlunoNewPage;

public class AlunoTest extends BaseSisfilaTest {

	@Before
	public void setUp() {
		getFactory()
			.resetDatabase()
			.login().get().loginAsAdmin();
	}
	
	@Test
	public void novoAlunoApareceNaListagem() {
		getFactory().adminAlunoNew().get().addAluno("Fulano de Tal", "123456789");
		
		String listagem = getFactory().adminAlunoList().get().textoDaListagem();
		
		assertThat(listagem, containsString("Fulano de Tal"));
	}
	
	@Test
	public void naoPodeHaverDoisAlunosComMesmaMatricula() {
		AdminAlunoNewPage page;
		
		getFactory().adminAlunoNew().get().addAluno("Fulano", "123456789");
		
		page = getFactory().adminAlunoNew().get();
		page.addAluno("Sicrano", "123456789");
		assertThat(page.mensagemDeErro(), containsString("Matricula has already been taken"));
	}
}
