package controle;

import entidade.Cliente;
import interfaces.JanelaCadastroClientes;

public class ControladorCadastroClientes {

    public ControladorCadastroClientes(){
        new JanelaCadastroClientes(this).setVisible(true);
    }
    
    public String inserirCliente(Cliente cliente) {
        if (!Cliente.existeClientesMesmosAtributos(cliente)) {
            return Cliente.inserirCliente(cliente);
        } else {
            return "Já existe um Cliente com os mesmos atributos";
        }
    }

    public String alterarCliente(Cliente cliente) {
        Cliente cliente1 = Cliente.buscarCliente(cliente.getCpf());
        if (cliente1 != null) {
            return Cliente.alterarCliente(cliente);
        } else {
            return "Cpf do Cliente não cadastrado";
        }
    }

    public String removerCliente(String cpf) {
        Cliente cliente1 = Cliente.buscarCliente(cpf);
        if (cliente1 != null) {
            return Cliente.removerCliente(cpf);
        } else {
            return "Sequencial do Cliente não cadastrado";
        }
    }

}
