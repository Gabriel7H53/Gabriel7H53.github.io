package controle;

import entidade.Servico;
import interfaces.JanelaCadastroServicos;

public class ControladorCadastroServicos {
    
    public ControladorCadastroServicos(){
        new JanelaCadastroServicos(this).setVisible(true);
    }
    public String inserirServico(Servico servico) {
        if (!Servico.existeServicoMesmosAtributos(servico)) {
            return Servico.inserirServico(servico);
        } else {
            return "Já existe um servico com os mesmos atributos";
        }
    }
    public String alterarServico(Servico servico){
        Servico servico1 = Servico.buscarServico(servico.getSequencial());
        if(servico1 != null) return Servico.alterarServico(servico);
        else return "Descricao de servico não encontrado";
    }
    public String removerServico(int sequencial){
        Servico servico1 = Servico.buscarServico(sequencial);
        if(servico1 != null) return Servico.removerServico(servico1);
        else return "ID de servico não cadastrado";
    }
}
