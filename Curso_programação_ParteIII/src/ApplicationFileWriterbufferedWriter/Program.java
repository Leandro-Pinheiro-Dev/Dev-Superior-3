package ApplicationFileWriterbufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	
	public static void main(String[] args) {
		
		// CRIA UM ARRAY DE STRINGS COM LINHAS DE TEXTO A SEREM ESCRITAS NO ARQUIVO
		String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };
		
		// DEFINE O CAMINHO DO ARQUIVO ONDE O TEXTO SERÁ ESCRITO
		String path = "C:\\temp\\out.txt";
		
		// TENTA CRIAR UM BufferedWriter PARA ESCREVER NO ARQUIVO ESPECIFICADO
		// O BufferedWriter ENCAPSULA O FileWriter E MELHORA O DESEMPENHO AO ESCREVER VÁRIAS VEZES NO ARQUIVO
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			
			// ITERA SOBRE CADA LINHA NO ARRAY
			for (String line : lines) {
				// ESCREVE A LINHA NO ARQUIVO
				bw.write(line);
				// ADICIONA UMA QUEBRA DE LINHA APÓS CADA LINHA ESCRITA
				bw.newLine();
			}
		} 
		// CAPTURA E IMPRIME EXCEÇÕES DE ENTRADA/Saída, CASO OCORRAM
		catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
