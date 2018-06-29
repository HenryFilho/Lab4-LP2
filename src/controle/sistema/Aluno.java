package controle.sistema;

/**
 * Aluno, Controle de Alunos (lab 4)
 * 
 * @author Henry Maldiney de Lira Nóbrega Filho - 117210389
 *
 */

public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	/**
	 * @param matricula
	 *            Matrícula do aluno.
	 * @param nome
	 *            Nome do aluno.
	 * @param curso
	 *            Curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Aluno))
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
