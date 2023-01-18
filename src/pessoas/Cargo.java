package pessoas;

public enum Cargo {
	NEURO("Neurologista"), 
	CIRURGIAO("Cirurgião"), 
	CLINICO_GERAL("Clinico Geral");
	
	private String cargo;
	
	Cargo(String cargo){
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}
}
