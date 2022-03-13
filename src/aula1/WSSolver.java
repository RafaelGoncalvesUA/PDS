package aula1;
import java.util.*;
import java.io.*;

public class WSSolver {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Número inválido de argumentos.");
			System.exit(1);
		}
		try (Scanner sc = new Scanner(new File(args[0]))) {
			List<String> searchList = new ArrayList<>();
			int size = sc.nextLine().length();
			int l = 1;
			while (l < size) {
				String line = sc.nextLine();
				System.out.println(line);
				if (!line.matches("^[A-Z]+$")) {
					System.out.println(line);
					System.out.println("As letras do puzzle não estão em maiúscula.");
					System.exit(1);
				}
				l++;
			}
			String first = sc.nextLine();
			if (first.matches("^[A-Z]+$")) {
				System.out.println("Puzzle não é quadrado.");
				System.exit(1);
			}
			searchList.addAll(List.of(first.split("[\s;,]")));
			do {
				String atual = sc.nextLine();
				if (atual.matches("^[a-z]$")) {
					System.out.println("A lista de palavras");
					System.exit(1);
				}
				searchList.addAll(List.of(atual.split("[\s;]")));
			} while (sc.hasNextLine());
			for (int i = 0; i < searchList.size(); i++) System.out.println(searchList.get(i));
		} catch (FileNotFoundException e) {
			System.out.println("Ficheiro não encontrado.");
			e.printStackTrace();
		}
	}
}
