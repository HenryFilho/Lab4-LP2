package controle.sistema;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Grupo, Controle de Alunos (lab 4)
 * 
 * @author Henry Maldiney de Lira Nóbrega Filho - 117210389
 *
 */

public class Grupo {

	private String nome;
	private HashSet<Aluno> alunos;

	/**
	 * @param nome
	 *            Nome do grupo.
	 */
	public Grupo(String nome) {
		this.nome = nome;
		this.alunos = new HashSet<>();
	}

	/**
	 * Adiciona um aluno ao grupo.
	 * 
	 * @param aluno
	 *            Aluno desejado.
	 */
	public void addAluno(Aluno aluno) {
		if (!alunos.contains(aluno))
			alunos.add(aluno);
	}

	@Override
	public String toString() {
		String retorno = "";
		Iterator<Aluno> itr = alunos.iterator();
		while (itr.hasNext()) {
			retorno += "* " + itr.next().toString() + System.lineSeparator();
		}
		return retorno;
	}

	//Não uso pra absolutamente nada, mas já que é obrigado, ta ai. rs
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Grupo))
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
