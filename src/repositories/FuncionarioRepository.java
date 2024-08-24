package repositories;
//classe para acessar e manipular arquivos ou banco de dados

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import entities.Funcionario;

public class FuncionarioRepository {

	// Método para gravar os dados do funcionário em arquivo

	public void exportarDados(Funcionario funcionario) {
		try {

			var fileWriter = new FileWriter("c:\\temp\\funcionarios.txt", true);

			var printWriter = new PrintWriter(fileWriter);
			printWriter.write("\nId do funcionario..: " + funcionario.getId());
			printWriter.write("\nNome...............: " + funcionario.getNome());
			printWriter.write("\nMatricula..........: " + funcionario.getMatricula());
			printWriter.write("\nData de Admissão...: " + funcionario.getDataAdmissao());
			printWriter.write("\nTipo de contração..: " + funcionario.getTipoContratacao());
			printWriter.write("\n");
			printWriter.close();

			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");

		} catch (Exception e) {
			System.out.println("\nFalha ao gravar o arquivo" + e.getMessage());
		}
	}

}
