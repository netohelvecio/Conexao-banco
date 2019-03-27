package main;

import java.sql.SQLException;
import java.util.Scanner;

import banco.LivroDAO;
import classe.Livro;

public class MainLivro {

	public static void main(String[] args) throws SQLException {

		LivroDAO livro_db = new LivroDAO();
		Livro Livro = new Livro();

		Scanner input = new Scanner(System.in);
		int escolha = 0;

		do {
			System.out.println();
			System.out.println("-----------BIBLIOTECA-----------");
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Editar");
			System.out.println("[3] Excluir");
			System.out.println("[4] Lista de todos livros");
			System.out.println("[5] Menu de Consulta");
			System.out.println("[6] Sair");
			System.out.println();
			System.out.print("Escolha uma opção: ");
			escolha = input.nextInt();
			System.out.println();

			if (escolha == 1) {
				System.out.print("Nome do Livro: ");
				Livro.setNome(input.next());

				System.out.print("Autor: ");
				Livro.setAutor(input.next());

				System.out.print("Número de pág: ");
				Livro.setPaginas(input.nextInt());

				System.out.print("Ano de Publicação: ");
				Livro.setAno_publicacao(input.nextInt());

				livro_db.salvar(Livro);
			}

			else if (escolha == 2) {
				System.out.println("Lista atual de Livros:");
				livro_db.listar();

				System.out.println();

				System.out.print("Escolha pelo ID qual livro deseja editar: ");
				Livro.setId_livro(input.nextInt());

				System.out.print("Nome do Livro: ");
				Livro.setNome(input.next());

				System.out.print("Autor: ");
				Livro.setAutor(input.next());

				System.out.print("Número de pág: ");
				Livro.setPaginas(input.nextInt());

				System.out.print("Ano de Publicação: ");
				Livro.setAno_publicacao(input.nextInt());
				livro_db.editar(Livro);
				System.out.println();

				System.out.println("Lista Atualizada");
				livro_db.listar();

			} else if (escolha == 3) {
				System.out.println("Lista atual de Livros:");
				livro_db.listar();

				System.out.println();
				System.out.print("Escolha pelo ID qual livro deseja excluir: ");
				Livro.setId_livro(input.nextInt());

				livro_db.excluir(Livro);

				System.out.println();
				System.out.println("Lista Atualizada:");
				livro_db.listar();

			} else if (escolha == 4) {
				System.out.println("Lista atual de Livros:");
				System.out.println();
				livro_db.listar();

			} else if (escolha == 5) {
				System.out.println("[1] ID");
				System.out.println("[2] NOME");
				System.out.print("Escolha uma opção para filtrar: ");
				escolha = input.nextInt();
				System.out.println();

				if (escolha == 1) {
					System.out.print("Informe o ID: ");				
					Livro.setId_livro(input.nextInt());
					System.out.println();

					livro_db.filtrar_id(Livro);

				} else{
					System.out.print("Informe o Nome: ");			
					Livro.setNome(input.next());
					System.out.println();

					livro_db.filtrar_nome(Livro);
				}
			} else if (escolha == 6) {
				System.out.println("SAINDO");
				System.exit(0);
			}
			

		} while (escolha != 6);

	}
}
