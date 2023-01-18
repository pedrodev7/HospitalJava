package pessoas;

import salas.Atendimento;

public final class Atendente extends Funcionario {
	private Integer qtdAtendimento;

	public Atendente(String nome, String identidade, String idFuncionario) {
		super(nome, identidade, idFuncionario);
		qtdAtendimento = 0;
	}

	public Integer getQtdAtendimento() {
		return qtdAtendimento;
	}

	public void setQtdAtendimento() {
		qtdAtendimento += 1;
	}
	
	public void iniciarAtendimento(Atendimento sala, Paciente paciente) {
		setQtdAtendimento();
		sala.reservar(11, 12, 2023);
		sala.adicionarPacienteNaFila(paciente);
	}
	
}
