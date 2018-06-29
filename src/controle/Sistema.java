package controle;

import java.util.ArrayList;
import java.util.HashMap;

import controle.sistema.Aluno;
import controle.sistema.Grupo;

/**
 * Sistema, Controle de Alunos (lab 4)
 * 
 * @author Henry Maldiney de Lira Nóbrega Filho - 117210389
 *
 */

public class Sistema {

	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<Aluno> responderam;

	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.responderam = new ArrayList<>();
	}

	/**
	 * Cadastra um aluno no sistema.
	 * 
	 * @param matricula
	 *            Matrícula do aluno.
	 * @param nome
	 *            Nome do aluno.
	 * @param curso
	 *            Curso do aluno.
	 */
	public void cadastraAluno(String matricula, String nome, String curso) {
		if (alunos.containsKey(matricula))
			throw new RuntimeException("MATRÍCULA JÁ CADASTRADA!");
		if (matricula.equals("") || nome.equals("") || curso.equals(""))
			throw new RuntimeException("ENTRADA VAZIA!");
		alunos.put(matricula, new Aluno(matricula, nome, curso));
	}

	/**
	 * Consulta um aluno desejado.
	 * 
	 * @param matricula
	 *            Matrícula do aluno.
	 * @return Aluno: aluno.toString()
	 */
	public String consultaAluno(String matricula) {
		if (alunos.containsKey(matricula))
			return "Aluno: " + alunos.get(matricula).toString();
		throw new RuntimeException("Aluno não cadastrado.");
	}

	/**
	 * Cadastra um grupo no sistema.
	 * 
	 * @param nome
	 *            Nome do grupo.
	 */
	public void cadastraGrupo(String nome) {
		if (grupos.containsKey(nome))
			throw new RuntimeException("GRUPO JÁ CADASTRADO!");
		if (nome.equals(""))
			throw new RuntimeException("ENTRADA VAZIA!");
		grupos.put(nome, new Grupo(nome));
	}

	/**
	 * Aloca um aluno ao grupo desejado.
	 * 
	 * @param matricula
	 *            Matrícula do aluno.
	 * @param grupo
	 *            Nome do grupo.
	 */
	public void alocaAluno(String matricula, String grupo) {
		if (alunos.containsKey(matricula)) {
			if (grupos.containsKey(grupo)) {
				grupos.get(grupo).addAluno(alunos.get(matricula));
			} else {
				throw new RuntimeException("Grupo não cadastrado.");
			}
		} else {
			throw new RuntimeException("Aluno não cadastrado.");
		}

	}

	/**
	 * Lista os alunos do grupo desejado.
	 * 
	 * @param grupo
	 *            Nome do grupo.
	 * @return Alunos do grupo (nome do grupo): grupo.toString()
	 */
	public String imprimeAlunos(String grupo) {
		if (grupos.containsKey(grupo)) {
			return "Alunos do grupo " + grupo + ":\n" + grupos.get(grupo).toString();
		} else {
			throw new RuntimeException("Grupo não cadastrado.");
		}
	}

	/**
	 * Registra um aluno que respondeu questões no quadro.
	 * 
	 * @param matricula
	 *            Matrícula do aluno.
	 */
	public void respondeAluno(String matricula) {
		if (alunos.containsKey(matricula)) {
			responderam.add(alunos.get(matricula));
		} else {
			throw new RuntimeException("Aluno não cadastrado.");
		}

	}

	/**
	 * Lista os alunos que responderam questões no quadro.
	 * 
	 * @return N. aluno.toString()
	 */
	public String listaResposta() {
		String retorno = "";
		for (int i = 0; i < responderam.size(); i++) {
			retorno += (i + 1) + ". " + responderam.get(i).toString() + System.lineSeparator();
		}
		return retorno;
	}

}
