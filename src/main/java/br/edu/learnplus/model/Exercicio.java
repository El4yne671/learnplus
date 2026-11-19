package br.edu.learnplus.model;

import java.util.ArrayList;
import java.util.List;

public class Exercicio extends Conteudo {
    private List<Alternativa> alternativas = new ArrayList<>();
    private Alternativa correta;

    public Exercicio(Long id, String titulo, String descricao) {
        super(id, titulo, descricao);
    }

    public void adicionarAlternativa(Alternativa a) {
        alternativas.add(a);
    }

    public void definirCorreta(Alternativa correta) {
        this.correta = correta;
    }

    public boolean corrigir(Alternativa resposta) {
        return correta != null && correta.equals(resposta);
    }

    @Override
    public String getTipoConteudo() { return "EXERCICIO"; }

    public List<Alternativa> getAlternativas() { return alternativas; }
}
