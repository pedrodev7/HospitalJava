import pessoas.*;
import salas.*;

public class hospital {

	public static void main(String[] args) {
		// Gerando novos Pacientes
		Paciente paciente1 = new Paciente("Ana", "321321-10", "Hapvida");
		Paciente paciente2 = new Paciente("Benício", "987789-30", "Bradesco");
		Paciente paciente3 = new Paciente("Conceição", "000000-7", "Unimed");
		
		// Gerando Atendente
		Atendente atendente = new Atendente("Domingos", "1930", "1");
		
		// Gerando Sala
		Atendimento salaUm = new Atendimento("Z311", atendente);
		
		// Gerando Medicos
		Neuro neuro = new Neuro("Dra. Eliana", "00001-3", "2", "9001");
		Neuro neuro2 = new Neuro("Dr. Fabio", "00001-4", "2", "9002");
		ClinicoGeral clinicoGeral = new ClinicoGeral("Dra. Graça", "00002-5", "3", "5185");
		Cirurgiao cirurgiao  = new Cirurgiao("Dr. Hugo", "00003-7", "4","9753");	
		
		// Procedimento de ATENDIMENTO		
		atendente.iniciarAtendimento(salaUm, paciente1);
		atendente.iniciarAtendimento(salaUm, paciente2);
		atendente.iniciarAtendimento(salaUm, paciente3);
		
		// Utilizando Equals
//		System.out.println(neuro.equals(clinicoGeral)); //false
//		System.out.println(neuro.equals(cirurgiao)); // false
//		System.out.println(neuro.equals(neuro2)); // false
//		System.out.println(neuro.equals(neuro)); // true
		
		salaUm.listarPacientesNaFila();	
		
		// Atendimento com clinico geral
		clinicoGeral.realizarDiagnostico(salaUm, clinicoGeral.resgatarPacienteNaFila(salaUm));
		clinicoGeral.realizarDiagnostico(salaUm, clinicoGeral.resgatarPacienteNaFila(salaUm));
		clinicoGeral.realizarDiagnostico(salaUm, clinicoGeral.resgatarPacienteNaFila(salaUm));
		
		salaUm.listarPacientesNaFila();
		
		// Atendimento com Neuro e Cirurgiao
		neuro.realizarDiagnostico(salaUm, neuro.resgatarPacienteNaFila(salaUm));
		cirurgiao.realizarDiagnostico(salaUm, cirurgiao.resgatarPacienteNaFila(salaUm));
		neuro.realizarDiagnostico(salaUm, neuro.resgatarPacienteNaFila(salaUm));
		cirurgiao.realizarDiagnostico(salaUm, cirurgiao.resgatarPacienteNaFila(salaUm));
		
	}

}
