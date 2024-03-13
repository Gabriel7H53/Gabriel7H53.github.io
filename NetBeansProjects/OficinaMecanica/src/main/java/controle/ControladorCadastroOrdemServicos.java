package controle;


import entidade.OrdemServico;
import interfaces.JanelaCadastroOrdemServicos;

public class ControladorCadastroOrdemServicos {

    public ControladorCadastroOrdemServicos() {
        new JanelaCadastroOrdemServicos(this).setVisible(true);
    }

    public String inserirOrdemServico(OrdemServico ordemservico) {
        if (!ordemservico.existeOrdemServicoInserir(ordemservico.getCliente().getCpf(), ordemservico.getServico().getSequencial())) {
            return ordemservico.inserirOrdemServico(ordemservico);
        } else {
            return "Ordem de servico ja cadastrada";
        }
    }

    public String alterarOrdemServico(OrdemServico ordemservico_informada) {
        OrdemServico ordemservico_cadastradas = OrdemServico.buscarOrdemServico(ordemservico_informada.getSequencial());
        if ((ordemservico_informada.getCliente().getCpf().equals(ordemservico_cadastradas.getCliente().getCpf()))
                && (ordemservico_informada.getServico().getSequencial()
                == ordemservico_cadastradas.getServico().getSequencial())) {
            return OrdemServico.alterarOrdemServico(ordemservico_informada);
        } else {
            return "alteracao nao permitida";
        }
    }

    public String removerOrdemServico(int sequencial) {
        if (OrdemServico.existeOrdemServico(sequencial)) {
            return OrdemServico.removerOrdemServico(sequencial);
        } else {
            return "sequencial nao corresponde a nenhuma ordem de servico";
        }
    }
}
