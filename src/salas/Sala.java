package salas;

import pessoas.Funcionario;

public abstract class Sala {
	private String numeroDaSala;
	private int dia;
	private int mes;
	private int ano;

	public Sala(String numeroDaSala, Funcionario responsavel) {
		super();
		this.numeroDaSala = numeroDaSala;
	}

	public String getNumeroDaSala() {
		return numeroDaSala;
	}

	public void setNumeroDaSala(String numeroDaSala) {
		this.numeroDaSala = numeroDaSala;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public final void reservar(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
}
