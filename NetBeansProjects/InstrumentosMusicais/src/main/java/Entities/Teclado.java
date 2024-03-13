package Entities;

import java.util.HashMap;

import Entities.enums.Tipo;
import java.util.Collection;

public class Teclado {
	
	 private static HashMap<Integer, Teclado> teclados = new HashMap<Integer, Teclado>();
	 public static HashMap<Integer, Teclado> getTeclados() { return teclados; }

	 public static void inserir(Teclado teclado) {
     Integer id = teclado.getIdProduto();
	 teclados.put(id, teclado);
	 //System.out.println("Erro -> Teclado já cadastrado com ID : " + id);
	 }

	private Integer idProduto;
	private String marca;
	private Tipo tipo;
	private Integer numeroTeclas;
	private Double peso;
	private Boolean contemInterfaceLed;
	
	public Teclado() {
	}

	public Teclado(Integer idProduto, String marca, Tipo tipo, Integer numeroTeclas, Double peso,
			Boolean contemInterfaceLed) {
		this.idProduto = idProduto;
		this.marca = marca;
		this.tipo = tipo;
		this.numeroTeclas = numeroTeclas;
		this.peso = peso;
		this.contemInterfaceLed = contemInterfaceLed;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Integer getNumeroTeclas() {
		return numeroTeclas;
	}

	public void setNumeroTeclas(Integer numeroTeclas) {
		this.numeroTeclas = numeroTeclas;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Boolean getContemInterfaceLed() {
		return contemInterfaceLed;
	}

	public void setContemInterfaceLed(Boolean contemInterfaceLed) {
		this.contemInterfaceLed = contemInterfaceLed;
	}
	
	@Override
	
	public String toString() {
		
		return "Marca: " + marca + " -- tipo de teclado: " + tipo + " - quantidade de teclas: "
	               + String.valueOf(numeroTeclas) + " - peso: " + String.valueOf(peso)
	               + " " + contemInterface();
	}
	
	public String contemInterface() {
		if (contemInterfaceLed == true) {
			return "- contem interface led";
		}
		else {
			return "";
		}
	}
}
