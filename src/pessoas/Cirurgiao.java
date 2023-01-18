package pessoas;

import java.util.Scanner;

import salas.Atendimento;

public class Cirurgiao extends Medico {
	private Cargo cargo;
	private Scanner sc;

	public Cirurgiao(String nome, String identidade, String idFuncionario, String crm) {
		super(nome, identidade, idFuncionario, crm);
		cargo = Cargo.CIRURGIAO;
		sc = new Scanner(System.in);
	}

	@Override
	public void realizarDiagnostico(Atendimento sala, Paciente paciente) {

		try {
			paciente.removerSintomas();
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
			} else {
				paciente.setTrauma(false);
			}

			System.out.print("O paciente possui Lesao?(S/N): ");
			if (sc.nextLine().charAt(0) == 'S') {
				paciente.setLesao(true);
			} else {
				paciente.setLesao(true);
			}

			if (!(paciente.isLesao() || paciente.isTrauma())) {
				sala.removerPacienteDaFila(paciente);

			}

			this.escreverReceitaMedica(paciente);
		} catch (Exception e) {
			System.err.println("Não existe(m) paciente(s) na fila atualmente com necessidade de " + this.getCargo());
		}

	}

	public void escreverReceitaMedica(Paciente paciente) {
		System.out.println("==========================================================");
		System.out.printf(
				"O paciente %s apresentou um total de %d sintoma(s)\n"
						+ "com isso será necessario ter os seguintes cuidados ou procedimentos: \n",
				paciente.getNome(), paciente.getSintomas().size());

		if (paciente.getSintomas().size() <= 1) {
			System.out.println("- Repouso");
			System.out.println("- Paracetamol somente ao sentir febre ou dores");
		} else if (paciente.getSintomas().size() <= 2) {
			System.out.println("- Repouso");
			System.out.println("- Trocar Curativos 6/6h");
			System.out.println("- Lavagem com Soro no local do Procedimento");
			System.out.println("- Paracetamol somente ao sentir febre ou dores");
		} else {
			System.out.println("- Repouso");
			System.out.println("- Trocar Curativos 4/4h");
			System.out.println("- Remoção dos pontos 15 dias após procedimento, se houver necessidade");
			System.out.println("- Lavagem com Soro no local do Procedimento");
			System.out.println("- Amtibiotico de 24/24h durante 7 Dias");
			System.out.println("- Paracetamol somente ao sentir febre ou dores");
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
