package br.edu.learnplus.model;

import br.edu.learnplus.service.Autenticavel;

import java.util.ArrayList;
import java.util.List;

public class Estudante extends Usuario implements Autenticavel {
    private int nivel;
    private boolean autenticado;
    private Progresso progresso;
    private List<Tentativa> tentativas = new ArrayList<>();

    public Estudante(Long id, String nome, String email, String senhaHash) {
        super(id, nome, email, senhaHash);
        this.nivel = 1;
        this.autenticado = false;
        this.progresso = new Progresso(this);
    }

    @Override
    public String getTipoPerfil() {
        return "ESTUDANTE";
    }

    @Override
    public boolean login(String email, String senha) {
        if (getEmail().equals(email) && getSenhaHash().equals(hash(senha))) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        this.autenticado = false;
    }

    @Override
    public boolean isAutenticado() {
        return autenticado;
    }

    private String hash(String senha) {
        return Integer.toHexString(senha.hashCode());
    }

    public void registrarTentativa(Tentativa t) {
        tentativas.add(t);
    }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public Progresso getProgresso() { return progresso; }
    public List<Tentativa> getTentativas() { return tentativas; }
}
