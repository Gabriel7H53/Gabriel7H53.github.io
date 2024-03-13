package Entities;

public class Endereco {

	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private Integer cep;
	
	public Endereco() {
	}

	public Endereco(String rua, Integer numero, String bairro, String cidade, Integer cep) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	@Override
	
	public String toString() {
		String enderecoStr = rua + " - " + String.valueOf(numero);
		enderecoStr += " - bairro: " + bairro + " - " + cidade + " - CEP: " + cep;
		return enderecoStr;
	}
}
