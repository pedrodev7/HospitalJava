package pessoas;

import java.util.ArrayList;
import java.util.List;

public final class Paciente extends Pessoa {

	private List<String> sintomas;
	private String convenio;
	private boolean trauma;
	private boolean lesao;

	public Paciente(String nome, String identidade, String convenio) {
		super(nome, identidade);
		this.convenio = convenio;
		sintomas = new ArrayList<String>();
		trauma = false;
		lesao = false;
	}

	public List<String> getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas.add(sintomas);
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public boolean isTrauma() {
		return trauma;
	}

	public void setTrauma(boolean trauma) {
		this.trauma = trauma;
	}

	public boolean isLesao() {
		return lesao;
	}

	public void setLesao(boolean lesao) {
		this.lesao = lesao;
	}

	public void listarSintomas() {
		
		for (int i = 0; i < sintomas.size(); i++) {
			System.out.printf("- %s;\n", sintomas.get(i));
		}
		System.out.println("==========================================================");
	}
	
	public void removerSintomas() {
		this.sintomas.removeAll(sintomas);
	}
}
