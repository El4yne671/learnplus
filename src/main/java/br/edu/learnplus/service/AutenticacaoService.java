package br.edu.learnplus.service;

import br.edu.learnplus.exception.AutenticacaoException;
import br.edu.learnplus.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class AutenticacaoService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(Usuario u) {
        usuarios.add(u);
    }

    public Usuario autenticar(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u instanceof Autenticavel) {
                if (((Autenticavel) u).login(email, senha)) {
                    return u;
                }
            }
        }
        throw new AutenticacaoException("Credenciais inválidas para: " + email);
    }

    public void logout(Usuario u) {
        if (u instanceof Autenticavel) {
            ((Autenticavel) u).logout();
        }
    }
}
