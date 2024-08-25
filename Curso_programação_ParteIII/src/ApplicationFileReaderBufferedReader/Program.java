package ApplicationFileReaderBufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String path = "C:\\temp\\in.txt";// DEFINE O CAMINHO DO ARQUIVO QUE SERÁ LIDO
		BufferedReader br = null; // INICIALIZA O BufferedReader COMO NULO
		FileReader fr = null; // INICIALIZA O FileReader COMO NULO
		
		try {
			fr = new FileReader(path);		// CRIA UM FileReader PARA O ARQUIVO ESPECIFICADO
			br = new BufferedReader(fr);	// CRIA UM BufferedReader PARA MELHORAR A LEITURA DO ARQUIVO
			 
			String line = br.readLine(); 	// LÊ A PRIMEIRA LINHA DO ARQUIVO
			

			while (line != null) {			// CONTINUA LENDO LINHAS ENQUANTO HOUVER LINHAS A SEREM LIDAS
				System.out.println(line);	// IMPRIME A LINHA LIDA
				line = br.readLine();		// LÊ A PRÓXIMA LINHA DO ARQUIVO
			}
		}
		catch (IOException e) {		// CAPTURA E IMPRIME EXCEÇÕES DE ENTRADA/Saída, CASO OCORRAM
			System.out.println("Error: " + e.getMessage());			// IMPRIME A MENSAGEM DE ERRO ASSOCIADA À EXCEÇÃO
		}
		finally {		// BLOCO FINALMENTE GARANTE O FECHAMENTO DOS RECURSOS
			try {
				if (br != null) {	// FECHA O BufferedReader SE NÃO FOR NULO
					br.close();
				}
				if (fr != null) {	// FECHA O FileReader SE NÃO FOR NULO
					fr.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();// IMPRIME A PILHA DE CHAMADAS DA EXCEÇÃO, SE OCORRER UM ERRO AO FECHAR OS RECURSOS
			}
		}
	}
}
