package controle;

import java.util.Scanner;

/**
 * Controle de Alunos (Lab 4)
 * 
 * @author Henry Maldiney de Lira Nóbrega Filho - 117210389
 *
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada;
		String[] aEntrada;
		Sistema sistema = new Sistema();
		
		while(true) {
			System.out.print("(C)adastrar Aluno\n"
						   + "(E)xibir Aluno\n"
						   + "(N)ovo Grupo\n"
						   + "(A)locar Aluno no Grupo e Imprimir Grupos\n"
						   + "(R)egistrar Aluno que Respondeu\n"
						   + "(I)mprimir Alunos que Responderam\n"
						   + "(O)ra, vamos fechar o programa!\n"
						   + "\n"
						   + "Opção> ");
			
			entrada = sc.nextLine().toLowerCase();
			if(entrada.equals("c")) {
				aEntrada = new String[3];
				System.out.print("Matrícula: ");
				aEntrada[0] = sc.nextLine();
				System.out.print("Nome: ");
				aEntrada[1] = sc.nextLine();
				System.out.print("Curso: ");
				aEntrada[2] = sc.nextLine();
				try {
					sistema.cadastraAluno(aEntrada[0],aEntrada[1],aEntrada[2]);
					System.out.println("CADASTRO REALIZADO!\n");
				}catch(RuntimeException e) {
					System.out.println(e.getMessage() + System.lineSeparator());
				}
				
			}else if(entrada.equals("e")) {
				System.out.print("Matrícula: ");
				entrada = sc.nextLine();
				try {
					System.out.println(System.lineSeparator() + sistema.consultaAluno(entrada) + System.lineSeparator());
				}catch(RuntimeException e) {
					System.out.println(System.lineSeparator() + e.getMessage() + System.lineSeparator());
				}
				
			}else if(entrada.equals("n")) {
				System.out.print("Grupo: ");
				entrada = sc.nextLine();
				try {
					sistema.cadastraGrupo(entrada);
					System.out.println("CADASTRO REALIZADO!\n");
				}catch(RuntimeException e) {
					System.out.println(e.getMessage() + System.lineSeparator());
				}
				
			}else if(entrada.equals("a")) {
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				entrada = sc.nextLine().toLowerCase();
				if(entrada.equals("a")) {
					aEntrada = new String[2];
					System.out.print("Matrícula: ");
					aEntrada[0] = sc.nextLine();
					System.out.print("Grupo: ");
					aEntrada[1] = sc.nextLine();
					try {
						sistema.alocaAluno(aEntrada[0],aEntrada[1]);
						System.out.println("ALUNO ALOCADO!\n");
					}catch(RuntimeException e) {
						System.out.println(e.getMessage() + System.lineSeparator());
					}
				}else if(entrada.equals("i")) {
					System.out.print("Grupo: ");
					entrada = sc.nextLine();
					try {
						System.out.println(sistema.imprimeAlunos(entrada));
					}catch(RuntimeException e) {
						System.out.println(e.getMessage() + System.lineSeparator());
					}
				}else {
					System.out.println("Entrada inválida!\n");
				}
				
			}else if(entrada.equals("r")) {
				System.out.print("Matrícula: ");
				entrada = sc.nextLine();
				try {
					sistema.respondeAluno(entrada);
					System.out.println("ALUNO REGISTRADO!\n");
				}catch(RuntimeException e) {
					System.out.println(e.getMessage() + System.lineSeparator());
				}
				
			}else if(entrada.equals("i")) {
				System.out.println(sistema.listaResposta());
				
			}else if(entrada.equals("o")) {
				break;
			}
		}
		sc.close();
	}
}
