package Control;

import java.time.LocalDate;
import java.util.HashMap;

import Entities.Client;
import Entities.Endereco;
import Entities.Teclado;
import Entities.Venda;
import Entities.enums.Tipo;
import Entities.filtroVenda;
import java.util.ArrayList;

public class loja_instrumentos_musicais {

	public static void main(String[] args) {
		
		Integer contador;
				
		Endereco enderec = new Endereco("Rua pedro de alencar", 200, "C3", "Dourados", 79839303);
		Client y = new Client("Gabriel", 858458, 2465512, 99655109, enderec);
		Client w = new Client("Joao", 858459, 2465511, 99645107, enderec);
		Client z = new Client("Lucas", 789856, 2465513, 99635108, enderec);
		
		Teclado.inserir(new Teclado(1, "Zeus", Tipo.ARRANJADOR, 8, 18.5, true));
		Teclado.inserir(new Teclado(2, "Yamaha", Tipo.OUTROS, 4, 16.5, false));
		Teclado.inserir(new Teclado(3, "Luke", Tipo.ARRANJADOR, 16, 36.5, false));
		Teclado.inserir (new Teclado(4, "Shaw", Tipo.ARRANJADOR, 16, 16.5, false));
                
		Client.inserir(y);
		Client.inserir(w);
		Client.inserir(z);
		
		Venda.InserirVenda(858458, 1, 4000.0, 0.10, LocalDate.now());
		Venda.InserirVenda(858459, 3, 4000.0, 0.10, LocalDate.now());
                Venda.InserirVenda(789856, 4, 4000.0, 0.10, LocalDate.now());
                
		HashMap<Integer, Client> clients = Client.getClients();
		HashMap<Integer, Teclado> teclados = Teclado.getTeclados();
		HashMap<Integer, Venda> vendas = Venda.getVendas();
		
		System.out.println("\n-- Teclados Catalogados");
		contador = 1;
		for(Integer x : teclados.keySet() ) {
			System.out.println(contador +" - "+ teclados.get(x));
		}
		
		System.out.println("\n-- Clientes Cadastrados");
		contador = 1;
		for(Integer x : clients.keySet() ) {
			System.out.println(contador +" - "+ clients.get(x));
		}
		
		contador = 1;
		System.out.println("\n-- Vendas Realizadas");
		for(Integer x : vendas.keySet() ) {
			System.out.println(contador +""+ vendas.get(x));
			contador++;
		}
                System.out.println("\n-- Vendas Realizadas Filtros Tipo Teclado:ARRANJADOR");
                ArrayList<HashMap<Integer, Venda>> tecladoFiltrado  = new ArrayList<>();

                tecladoFiltrado = filtroVenda.filtrarTeclados(Tipo.ARRANJADOR);
                for(HashMap<Integer, Venda> Type : tecladoFiltrado) {
                    System.out.println(Type);
		}
                System.out.println("\n-- Vendas Realizadas Filtros Tipo Teclado:ARRANJADOR : PESO < 20");
                tecladoFiltrado.clear();
                tecladoFiltrado = filtroVenda.filtrarTeclados(Tipo.ARRANJADOR, 20.0);
                    for(HashMap<Integer, Venda> Type : tecladoFiltrado) {
                    System.out.println(Type);
		}
                System.out.println("\n-- Vendas Realizadas Filtros Tipo Teclado:ARRANJADOR : PESO < 20 : CONTEM LED");
                tecladoFiltrado.clear();
                tecladoFiltrado = filtroVenda.filtrarTeclados(Tipo.ARRANJADOR, 20.0, true);
                    for(HashMap<Integer, Venda> Type : tecladoFiltrado) {
                    System.out.println(Type);
		}
	}

}
