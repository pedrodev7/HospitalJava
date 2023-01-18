package pessoas;

public abstract class Pessoa {
	private String nome;
	private String identidade;

	public Pessoa(String nome, String identidade) {
		super();
		this.nome = nome;
		this.identidade = identidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

}
