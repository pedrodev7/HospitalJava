package pessoas;

import java.util.Scanner;

import salas.Atendimento;

public class ClinicoGeral extends Medico {
	private Cargo cargo;
	private Scanner sc;

	public ClinicoGeral(String nome, String identidade, String idFuncionario, String crm) {
		super(nome, identidade, idFuncionario, crm);
		cargo = Cargo.CLINICO_GERAL;
		sc = new Scanner(System.in);
	}

	@Override
	public void realizarDiagnostico(Atendimento sala, Paciente paciente) {
		System.out.printf("Quantos sintomas o paciente %s apresentou?", paciente.getNome());
		int qtdSintomas = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < qtdSintomas; i++) {
			System.out.printf("Informe o [%d]° sintoma: ", (i + 1));
			paciente.setSintomas(sc.nextLine());
		}

		System.out.print("O paciente possui trauma?(S/N): ");
		if (sc.nextLine().charAt(0) == 'S') {
			paciente.setTrauma(true);
		}

		System.out.print("O paciente possui Lesao?(S/N): ");
		if (sc.nextLine().charAt(0) == 'S') {
			paciente.setLesao(true);
		}

		if (!(paciente.isLesao() || paciente.isTrauma())) {
			sala.removerPacienteDaFila(paciente);

		}

		this.escreverReceitaMedica(paciente);
	}

	public void escreverReceitaMedica(Paciente paciente) {
		System.out.println("==========================================================");
		System.out.printf(
				"O paciente %s apresentou um total de %d sintoma(s)\n"
						+ "com isso será necessario ter os seguintes cuidados: \n",
				paciente.getNome(), paciente.getSintomas().size());

		if (paciente.getSintomas().size() == 1) {
			System.out.println("- Sinal de Cansaço (!)");
			System.out.println("- Repouso");
		} else if (paciente.getSintomas().size() > 1 && paciente.getSintomas().size() <= 3) {
			System.out.println("- Gripe ou Resfriado do tipo Leve/Moderado (!)");
			System.out.println("- Repouso");
			System.out.println("- Paracetamol 8/8h - 150mg");
		} else if (paciente.getSintomas().size() > 3 && paciente.getSintomas().size() <= 5) {
			System.out.println("- Gripe ou Resfriado do Tipo Moderado/Grave");
			System.out.println("- Repouso");
			System.out.println("- Paracetamol 8/8h - 150mg");
			System.out.println("- Nimesulida 8/8h - 100mg");
		} else if (paciente.getSintomas().size() > 5) {
			System.out.println("CUIDADO! Suspeita de Covid (!)");
			System.out.println("- Repouso");
			System.out.println("- Isolamento Social Durante 7 Dias");
			System.out.println("- Paracetamol 8/8h - 150mg");
			System.out.println("- Nimesulida 8/8h - 100mg");
			System.out.println("- Vacinação após 15 dias dos sintomas terminarem");
		}

		if (paciente.isLesao() == true && paciente.isTrauma() == true) {
			System.out.println(">>> Você será direcionado para um " + Cargo.NEURO.getCargo());
			System.out.println("Lesão? -= SIM =-");
			System.out.println("Trauma? -= SIM =-");
		} else if (paciente.isLesao() ^ paciente.isTrauma()) {
			System.out.println(">>> Você será direcionado para um " + Cargo.CIRURGIAO.getCargo());
			if (paciente.isLesao()) {
				System.out.println("Lesão? -= SIM =-");
			} else {
				System.out.println("Trauma? -= SIM =-");
			}
		}

		System.out.println("Assinado: " + this.getNome());
		System.out.println(this.getCargo());
		System.out.println("CRM: " + this.getCrm());

		System.out.println("==========================================================");
	}

	public String getCargo() {
		return cargo.getCargo();
	}

	@Override
	public Paciente resgatarPacienteNaFila(Atendimento sala) {
		return sala.getPaciente(this);
	}

}
