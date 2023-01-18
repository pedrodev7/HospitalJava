package pessoas;

import salas.Atendimento;

public abstract class Medico extends Funcionario {
	private String crm;

	public Medico(String nome, String identidade, String idFuncionario, String crm) {
		super(nome, identidade, idFuncionario);
		this.crm = crm;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Medico && this.getCrm() == ((Medico)obj).getCrm()) {
			return true;
		}
		return false;
	}

	public abstract void realizarDiagnostico(Atendimento sala, Paciente paciente);

	public abstract Paciente resgatarPacienteNaFila(Atendimento sala);
}
