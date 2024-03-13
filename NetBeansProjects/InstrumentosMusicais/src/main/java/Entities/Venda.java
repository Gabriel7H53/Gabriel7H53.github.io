package Entities;

import java.time.LocalDate;
import java.util.HashMap;

public class Venda {

	private static HashMap<Integer, Venda> vendas = new HashMap<>();
	public static HashMap<Integer, Venda> getVendas() {return vendas;}
	
	private Client client;
	private Teclado teclado;
	private Double desconto;
	private Double price;
	private Double finalPrice;
	private LocalDate data;
	
	public static String InserirVenda(Integer cpf, Integer id, Double precoVendido, Double desconto, LocalDate dataVenda) {
	HashMap<Integer, Client> clients = Client.getClients();
	HashMap<Integer, Teclado> teclados = Teclado.getTeclados();
	;
		for(Integer x : clients.keySet() ) {
			if(!clients.containsKey(cpf)) {
				return "Cliente nao existe";	
			}
			else {
				for(Integer y : teclados.keySet() ) {
					if(!teclados.containsKey(id)) {
						return "Teclado nao existe";	
					}
					else {
							Venda venda = new Venda(clients.get(cpf), teclados.get(id), precoVendido ,desconto, dataVenda, precoVendido - precoVendido * desconto);
							vendas.put(cpf, venda);
							return "Venda concluida";
					}	
				}
			}
		}
		return "";
	}
	public Venda() {
	}
	
	
	
	public Venda(Client client, Teclado teclado, Double price, Double desconto, LocalDate data, Double finalPrice) {
		this.client = client;
		this.teclado = teclado;
		this.desconto = desconto;
		this.price = price;
		this.data = data;
		this.finalPrice = finalPrice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Teclado getTeclado() {
		return teclado;
	}

	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Double setFinalPrice() {
		if(desconto != null) {
			finalPrice = price - price * desconto;
		}
		else {
			finalPrice = price;
		}
		return finalPrice;
	}
	
	@Override
    public String toString() {
        StringBuilder vendaStr = new StringBuilder(" - Venda registrada :: " + teclado + "\n");
        vendaStr.append("- Dados da Venda:: ").append(precoToString())
                .append(" - Data da compra: ").append(data)
                .append("\n- Comprador:: ").append(client);
        return vendaStr.toString();
    }
	
	
    private String precoToString() {
    	
        String precoStr = "Preço: R$" + price  + " - Desconto atribuído: ";
        if(desconto != null) {
        	precoStr += desconto * 100 + "% " + "FinalPrice:" + setFinalPrice();
        }
        else {
        	precoStr += "Nenhum.";
        }
        return precoStr;
    }
}
