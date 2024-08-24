package controllers;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Funcionario;
import enums.TipoContratacao;
import repositories.FuncionarioRepository;

//classe de controle para realizar a entrada
//dos dados do funcionario informado pelo usuario

public class FuncionarioController {

	public void cadastrarFuncionario() {

		// criando um objeto para funcionario

		var funcionario = new Funcionario();

		try {
			funcionario.setId(UUID.randomUUID());
			funcionario.setNome(JOptionPane.showInputDialog("Nome do funcionario"));
			funcionario.setMatricula(JOptionPane.showInputDialog("Matricula do funcionario"));
			funcionario.setDataAdmissao(
					new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Data de admissão")));

			var opcao = JOptionPane.showInputDialog("Informe (1)Estágio, (2)CLT ou (3)Terceirizado");

			switch (opcao) {
			case "1":
				funcionario.setTipoContratacao(TipoContratacao.ESTAGIO);
				break;
			case "2":
				funcionario.setTipoContratacao(TipoContratacao.CLT);
				break;
			case "3":
				funcionario.setTipoContratacao(TipoContratacao.TERCEIRIZADO);
				break;

			}

			var funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.exportarDados(funcionario);

		} catch (Exception e) {

			System.out.println("\nFalha ao capturar os dados: " + e.getMessage());

		}

	}

}
