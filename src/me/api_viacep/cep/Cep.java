package me.api_viacep.cep;

public class Cep {
	private String cep;
	private String bairro;
	private String logadouro;
	private String localidade;
	private String uf;
	private String ddd;
	
	
	public Cep(CepViacep cep){
		this.cep = cep.cep();
		this.bairro = cep.bairro();
		this.ddd = cep.ddd();
		this.localidade = cep.localidade();
		this.logadouro = cep.logradouro();
		this.uf = cep.uf();
		
	}
	

	public String getCep() {
		return cep;
	}
	public String getBairro() {
		return bairro;
	}
	public String getLogadouro() {
		return logadouro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public String getUf() {
		return uf;
	}
	public String getDdd() {
		return ddd;
	}
	@Override
	public String toString() {
		return 
				  "DDD "+ getDdd()
				+ "Bairro " + getBairro()
				+ "Logadouro " + getLogadouro()
				+ "Localidade "+ getLocalidade()
				+ "UF " + getUf()
				+ "CEP " + getCep();
				
	}
	
}
