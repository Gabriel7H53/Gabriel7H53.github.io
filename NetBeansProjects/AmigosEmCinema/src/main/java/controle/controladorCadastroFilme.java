/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Filme;
import interfaces.JanelaCadastroFilmes;

/**
 *
 * @author felip
 */
public class controladorCadastroFilme {

    public controladorCadastroFilme() {
        new JanelaCadastroFilmes(this).setVisible(true);
    }

    public String alterarFilme(Filme filme) {
        Filme filme1 = Filme.buscarFilme(filme.getSequencial());
        if (filme1 != null) {
            return Filme.alterarFilme(filme);
        } else {
            return "título do filme não cadastrado";
        }
    }

    public String removerFilme(int sequencial) {
        Filme sequencial1 = Filme.buscarFilme(sequencial);
        if (sequencial1 != null) {
            return Filme.removerFilme(sequencial1);
        } else {
            return "título do filme não cadastrado";
        }
    }

    public String inserirFilme(Filme filme) {
        if (!Filme.existeFilmeMesmosAtributos(filme)) {
            return Filme.inserirFilme(filme);
        } else {
            return "Já existe um filme com os mesmos atributos";
        }
    }
}
