//FAZER UM PROGRAMA PARA LER O CAMINHO DE UM ARQUIVO .CSV CONTENDO OS DADOS DE ITENS VENDIDDOS.
//c:\\temp\\input.csv PASTA CRIADA NO VISUAL CODE 
//CADA ITEM POSSUI UM NOME,PREÇO UNITARIO E QUANTIDADE SEPARADOS POR UMA VIRGULA.
//VOCE DEVE GERAR UM NOVO ARQUIVO CHAMADO "SUMMARY.CSV",
//LOCALIZADO EM UMA SUBPASTA CHAMADA "OUT" A PARTIR DA PASTA ORIGINAL DO ARQUIVO ORIGEM, 
//COTENDO APENAS O NOME EO VALOR TOTAL PATA AQUELE ITEM (PREÇO UNITARIO MULTIPLICADO PELA QUANTIDADE)

package ApplicationPraticandoArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import EntitiesPraticandoArquivos.Product;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// CRIA UMA LISTA PARA ARMAZENAR OBJETOS Product
		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		// CRIA UM OBJETO File COM BASE NO CAMINHO DO ARQUIVO DE ORIGEM
		File sourceFile = new File(sourceFileStr);
		// OBTÉM O CAMINHO DA PASTA QUE CONTÉM O ARQUIVO DE ORIGEM
		String sourceFolderStr = sourceFile.getParent();
		
		// TENTA CRIAR UMA NOVA PASTA "out" NA PASTA DO ARQUIVO DE ORIGEM
		// mkdir() RETORNA TRUE SE A CRIAÇÃO DA PASTA FOR BEM-SUCEDIDA
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		// DEFINE O CAMINHO DO ARQUIVO DE DESTINO
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		// TENTA ABRIR O ARQUIVO DE ORIGEM PARA LEITURA
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			// LÊ A PRIMEIRA LINHA DO ARQUIVO
			String itemCsv = br.readLine();
			// CONTINUA LENDO LINHAS ENQUANTO HOUVER LINHAS NO ARQUIVO
			while (itemCsv != null) {

				// DIVIDE A LINHA LIDA EM CAMPOS USANDO A VÍRGULA COMO SEPARADOR
				String[] fields = itemCsv.split(",");
				// OBTÉM O NOME DO PRODUTO
				String name = fields[0];
				// OBTÉM O PREÇO DO PRODUTO E CONVERTE PARA DOUBLE
				double price = Double.parseDouble(fields[1]);
				// OBTÉM A QUANTIDADE DO PRODUTO E CONVERTE PARA INTEIRO
				int quantity = Integer.parseInt(fields[2]);

				// ADICIONA UM NOVO OBJETO Product À LISTA
				list.add(new Product(name, price, quantity));

				// LÊ A PRÓXIMA LINHA DO ARQUIVO
				itemCsv = br.readLine();
			}

			// TENTA ABRIR O ARQUIVO DE DESTINO PARA ESCRITA
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				// ITERA SOBRE CADA PRODUTO NA LISTA
				for (Product item : list) {
					// ESCREVE O NOME DO PRODUTO E O TOTAL FORMATADO NO ARQUIVO DE DESTINO
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					// ADICIONA UMA QUEBRA DE LINHA
					bw.newLine();
				}

				// IMPRIME UMA MENSAGEM INFORMANDO QUE O ARQUIVO FOI CRIADO COM SUCESSO
				System.out.println(targetFileStr + " CREATED!");
				
			} catch (IOException e) {
				// CAPTURA E IMPRIME EXCEÇÕES RELACIONADAS À ESCRITA DO ARQUIVO
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) { 
			// CAPTURA E IMPRIME EXCEÇÕES RELACIONADAS À LEITURA DO ARQUIVO
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}
 