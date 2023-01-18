package pessoas;

public abstract class Funcionario extends Pessoa {
	private String idFuncionario;

	public Funcionario(String nome, String identidade, String idFuncionario) {
		super(nome, identidade);
		this.idFuncionario = idFuncionario;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

}
