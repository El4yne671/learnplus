package br.edu.learnplus.model;

import br.edu.learnplus.service.Autenticavel;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Autenticavel {
    private String disciplina;
    private boolean autenticado;
    private List<Conteudo> conteudosCriados = new ArrayList<>();

    public Professor(Long id, String nome, String email, String senhaHash, String disciplina) {
        super(id, nome, email, senhaHash);
        this.disciplina = disciplina;
        this.autenticado = false;
    }

    @Override
    public String getTipoPerfil() {
        return "PROFESSOR";
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
    public void logout() { this.autenticado = false; }

    @Override
    public boolean isAutenticado() { return autenticado; }

    private String hash(String senha) {
        return Integer.toHexString(senha.hashCode());
    }

    public void adicionarConteudo(Conteudo c) {
        conteudosCriados.add(c);
    }

    public String getDisciplina() { return disciplina; }
    public List<Conteudo> getConteudosCriados() { return conteudosCriados; }
}
