
package Entities;

import java.util.HashMap;

public class Client {

	private static HashMap<Integer, Client> clients = new HashMap<Integer, Client>();
	public static HashMap<Integer, Client> getClients() { return clients; }
	
	public static void inserir(Client client) {
		Integer cpf = client.getCpf();
		if(clients.get(cpf) == null) {
			clients.put(cpf, client);
		}
		else {
		System.out.println("Error -> Cliente ja cadastrado com o cpf: " + cpf);
		}
	}
	
	private String nome;
	private Integer cpf;
	private Integer rg;
	private Integer celular;
	private Endereco endereco;
	
	public Client() {
	}

	public Client(String nome, Integer cpf, Integer rg, Integer celular, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.celular = celular;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	
	public String toString() {
		return	nome + 
				" - RG: " 
				+ rg
				+ " - CPF: " 
				+ cpf
				+ " - Telefone Para Contato: " 
				+ String.valueOf(celular) 
				+ "\n- Local de Residencia:: " 
				+ String.valueOf(endereco);
	}
}
