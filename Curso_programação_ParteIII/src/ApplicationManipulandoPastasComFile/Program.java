package ApplicationManipulandoPastasComFile;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// SOLICITA AO USUÁRIO QUE DIGITE O CAMINHO DA PASTA
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		// CRIA UM OBJETO File COM BASE NO CAMINHO DA PASTA INFORMADO PELO USUÁRIO
		File path = new File(strPath);

		// LISTA TODOS OS DIRETÓRIOS (PASTAS) NO CAMINHO INFORMADO
		// File::isDirectory É UMA REFERÊNCIA DE MÉTODO QUE RETORNA TRUE SE O ARQUIVO FOR UM DIRETÓRIO
		File[] folders = path.listFiles(File::isDirectory);	   
		System.out.println("FOLDERS:");
		// IMPRIME O CAMINHO DE CADA DIRETÓRIO ENCONTRADO
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		// LISTA TODOS OS ARQUIVOS NO CAMINHO INFORMADO
		// File::isFile É UMA REFERÊNCIA DE MÉTODO QUE RETORNA TRUE SE O ARQUIVO FOR UM ARQUIVO
		File[] files = path.listFiles(File::isFile);  		
		System.out.println("FILES:");
		// IMPRIME O CAMINHO DE CADA ARQUIVO ENCONTRADO
		for(File file : files) {
			System.out.println(file); 
		}
		
		// TENTA CRIAR UM NOVO DIRETÓRIO CHAMADO "subdir" NO CAMINHO INFORMADO
		// mkdir() RETORNA TRUE SE A CRIAÇÃO DO DIRETÓRIO FOR BEM-SUCEDIDA, CASO CONTRÁRIO, RETORNA FALSE
		boolean sucess = new File(strPath + "\\subdir").mkdir();
		System.out.println("Directory created successfully: " + sucess);
		
		// FECHA O SCANNER PARA LIBERAR RECURSOS
		sc.close();
	}
}
