package controle;

import entidade.Avaliacao;
import interfaces.JanelaCadastroAvaliacoes;

public class controladorCadastroAvaliacao {

    public controladorCadastroAvaliacao() {
        new JanelaCadastroAvaliacoes(this).setVisible(true);
    }

    public String inserirAvalicao(Avaliacao avaliacao) {
        if (!Avaliacao.existeAvaliacaoInserir(avaliacao.getAmigo().getNome(), avaliacao.getFilme().getSequencial())) {
            return Avaliacao.inserirAvaliacao(avaliacao);
        } else {
            return "Avaliacao ja cadastrada";
        }
    }

    public String alterarAvaliacao(Avaliacao avaliacao_informada) {
        Avaliacao avaliacao_cadastradas = Avaliacao.buscarAvaliacao(avaliacao_informada.getSequencial());
        if ((avaliacao_informada.getAmigo().getNome().equals(avaliacao_cadastradas.getAmigo().getNome()))
                && (avaliacao_informada.getFilme().getSequencial()
                == avaliacao_cadastradas.getFilme().getSequencial())) {
            return Avaliacao.alterarAvaliacao(avaliacao_informada);
        } else {
            return "alteracao nao permitida : chave  amigo/filme forma alteradas";
        }
    }

    public String removerAvaliacao(int sequencial) {
        if (Avaliacao.existeAvaliacao(sequencial)) {
            return Avaliacao.removerAvaliacao(sequencial);
        } else {
            return "sequencial nao corresponde a nehuma reserva";
        }
    }
}
