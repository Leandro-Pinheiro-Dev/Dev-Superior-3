package ApplicationBlocoTryWithResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		// DEFINE O CAMINHO DO ARQUIVO QUE SERÁ LIDO
		String path = "C:\\temp\\in.txt";
		
		// TENTA CRIAR UM BufferedReader PARA LER O ARQUIVO ESPECIFICADO
		// O BufferedReader ENCAPSULA O FileReader E MELHORA O DESEMPENHO AO LER VÁRIAS VEZES DO ARQUIVO
		// O BLOCO try-with-resources GARANTE QUE O BufferedReader SEJA FECHADO AUTOMATICAMENTE
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			 
			// LÊ A PRIMEIRA LINHA DO ARQUIVO
			String line = br.readLine();
			// CONTINUA LENDO LINHAS ENQUANTO HOUVER LINHAS A SEREM LIDAS
			while (line != null) {
				// IMPRIME A LINHA LIDA
				System.out.println(line);
				// LÊ A PRÓXIMA LINHA DO ARQUIVO
				line = br.readLine();
			}
		}
		// CAPTURA E IMPRIME EXCEÇÕES DE ENTRADA/Saída, CASO OCORRAM
		catch (IOException e) { 
			// IMPRIME A MENSAGEM DE ERRO ASSOCIADA À EXCEÇÃO
			System.out.println("Error: " + e.getMessage());
		}

	}

}
