package controle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {
	
	Sistema sistema;
	
	@Before
	public void criarSistema() {
		this.sistema = new Sistema();
		sistema.cadastraAluno("117210389", "Henry Filho", "Ciência da Computação");
		sistema.cadastraAluno("117210919", "Gyovanna Costa", "Ciência da Computação");
		sistema.cadastraAluno("999999999", "Fulano Sicrano", "Ciência de Foguetes");
		
		sistema.cadastraGrupo("Guardians");
		sistema.alocaAluno("117210919", "Guardians");
		
		sistema.respondeAluno("117210389");
		sistema.respondeAluno("117210919");
	}

	@Test
	public void testConsultaAluno() {
		assertEquals(sistema.consultaAluno("117210389"), "Aluno: 117210389 - Henry Filho - Ciência da Computação");
	}
	
	@Test(expected=RuntimeException.class)
	public void testConsultaAlunoErro() {
		sistema.consultaAluno("111111111");
	}

	@Test
	public void testImprimeAlunos() {
		assertEquals(sistema.imprimeAlunos("Guardians"), "Alunos do grupo Guardians:\n"
													   + "* 117210919 - Gyovanna Costa - Ciência da Computação\n");
	}

	@Test(expected=RuntimeException.class)
	public void testImprimeAlunosErro() {
		sistema.imprimeAlunos("NãoExiste");
	}

	@Test
	public void testListaResposta() {
		assertEquals(sistema.listaResposta(), "1. 117210389 - Henry Filho - Ciência da Computação\n"
											+ "2. 117210919 - Gyovanna Costa - Ciência da Computação\n");
	}
	
}
