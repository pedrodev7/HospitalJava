package salas;

import java.util.ArrayList;
import java.util.List;

import pessoas.Atendente;
import pessoas.Cirurgiao;
import pessoas.ClinicoGeral;
import pessoas.Medico;
import pessoas.Neuro;
import pessoas.Paciente;

public class Atendimento extends Sala {

	private List<Paciente> pacientes;

	public Atendimento(String numeroDaSala, Atendente responsavel) {
		super(numeroDaSala, responsavel);
		pacientes = new ArrayList<Paciente>();
	}

	public void listarPacientesNaFila() {
		for (int i = 0; i < pacientes.size(); i++) {
			System.out.printf("- %s\n", pacientes.get(i).getNome());
		}
	}

	public void adicionarPacienteNaFila(Paciente paciente) {
		this.pacientes.add(paciente);
	}

	public void removerPacienteDaFila(Paciente paciente) {
		this.pacientes.remove(paciente);
	}

	public Paciente getPaciente(Medico medico) {
		for (int i = 0; i < pacientes.size(); i++) {
			if (medico instanceof Cirurgiao) {
				if (pacientes.get(i).isLesao() ^ pacientes.get(i).isTrauma()) {
					return pacientes.get(i);
				}
			}

			if (medico instanceof Neuro) {
				if (pacientes.get(i).isLesao() && pacientes.get(i).isTrauma()) {
					return pacientes.get(i);
				}
			}

			if (medico instanceof ClinicoGeral) {
				if (!(pacientes.get(i).isLesao() || pacientes.get(i).isTrauma())) {
					return pacientes.get(i);
				}
			}
		}
		return null;
	}
}
