/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import interfaces.JanelaCadastrarAmigos;

import entidade.Amigo;

/**
 *
 * @author felip
 */
public class controladorCadastroAmigo {

    public controladorCadastroAmigo() {
        new JanelaCadastrarAmigos(this).setVisible(true);
    }
    
    
    public String inserirAmigo(Amigo amigo) {
        Amigo amigol = Amigo.buscarAmigo(amigo.getNome());
        if (amigol == null) {
            return Amigo.inserirAmigo(amigo);
        } else {
            return "Nome de amigo já cadastrado";
        }
    }

    public String alterarAmigo(Amigo amigo) {
        Amigo amigo1 = Amigo.buscarAmigo(amigo.getNome());
        if (amigo1 != null) {
            return Amigo.alterarAmigo(amigo);
        } else {
            return "Nome de amigo não cadastrado";
        }
    }

    public String removerAmigo(String nome) {
        Amigo amigo1 = Amigo.buscarAmigo(nome);
        if (amigo1 != null) {
            return Amigo.removerAmigo(nome);
        } else {
            return "Nome de amigo não cadastrado";
        }
    }

}
