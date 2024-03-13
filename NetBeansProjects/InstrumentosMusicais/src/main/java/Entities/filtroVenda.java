
package Entities;

import Entities.enums.Tipo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class filtroVenda {
    
   
    private static HashMap<Integer, Venda> teclados = Venda.getVendas();
    private static ArrayList<HashMap<Integer, Venda>> tecladoFiltrado  = new ArrayList<>();
    
    public static ArrayList<HashMap<Integer, Venda>> filtrarTeclados(Tipo tipoTeclado){
    for (Map.Entry<Integer, Venda> entry : teclados.entrySet()) {
        if (entry.getValue().getTeclado().getTipo() == tipoTeclado) {
            HashMap<Integer, Venda> tecladoHashMap = new HashMap<>();
            tecladoHashMap.put(entry.getKey(), entry.getValue());
            tecladoFiltrado.add(tecladoHashMap);
        }
    }

    return tecladoFiltrado;
}
    public static ArrayList<HashMap<Integer, Venda>> filtrarTeclados(Tipo tipoTeclado, Double Peso){
    for (Map.Entry<Integer, Venda> entry : teclados.entrySet()) {
        if (entry.getValue().getTeclado().getTipo() == tipoTeclado && entry.getValue().getTeclado().getPeso() < Peso) {
            HashMap<Integer, Venda> tecladoHashMap = new HashMap<>();
            tecladoHashMap.put(entry.getKey(), entry.getValue());
            tecladoFiltrado.add(tecladoHashMap);
        }
    }

    return tecladoFiltrado;
}
    public static ArrayList<HashMap<Integer, Venda>> filtrarTeclados(Tipo tipoTeclado, Double Peso, Boolean contemLed){
    for (Map.Entry<Integer, Venda> entry : teclados.entrySet()) {
        if (entry.getValue().getTeclado().getTipo() == tipoTeclado && entry.getValue().getTeclado().getPeso() < Peso && entry.getValue().getTeclado().getContemInterfaceLed() == contemLed) {
            HashMap<Integer, Venda> tecladoHashMap = new HashMap<>();
            tecladoHashMap.put(entry.getKey(), entry.getValue());
            tecladoFiltrado.add(tecladoHashMap);
        }
    }

    return tecladoFiltrado;
}	
}