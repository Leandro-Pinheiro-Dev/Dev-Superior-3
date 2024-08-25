package ApplicationInformaçõesDoCaminhodoArquivo;

import java.io.File;
import java.util.Scanner;

public class Program {
 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		// CRIA UM OBJETO File COM BASE NO CAMINHO DIGITADO PELO USUÁRIO
		File path = new File(strPath);
		
		// IMPRIME O CAMINHO COMPLETO DO ARQUIVO OU DIRETÓRIO
		System.out.println("getPath: " + path.getPath());
		// IMPRIME O CAMINHO DO PAI DO ARQUIVO OU DIRETÓRIO
		System.out.println("getParent: " + path.getParent());
		// IMPRIME O NOME DO ARQUIVO OU DIRETÓRIO
		System.out.println("getName: " + path.getName());
		
		sc.close();
	}
}
