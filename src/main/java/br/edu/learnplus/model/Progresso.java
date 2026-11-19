package br.edu.learnplus.model;

import java.util.HashMap;
import java.util.Map;

public class Progresso {
    private Estudante estudante;
    private Map<Conteudo, Integer> acertosPorConteudo = new HashMap<>();
    private Map<Conteudo, Integer> tentativasPorConteudo = new HashMap<>();

    public Progresso(Estudante estudante) {
        this.estudante = estudante;
    }

    public void registrar(Conteudo conteudo, boolean acertou) {
        tentativasPorConteudo.merge(conteudo, 1, Integer::sum);
        if (acertou) {
            acertosPorConteudo.merge(conteudo, 1, Integer::sum);
        }
    }

    public double getPercentualAcerto(Conteudo conteudo) {
        int tentativas = tentativasPorConteudo.getOrDefault(conteudo, 0);
        if (tentativas == 0) return 0.0;
        int acertos = acertosPorConteudo.getOrDefault(conteudo, 0);
        return (acertos * 100.0) / tentativas;
    }

    public Estudante getEstudante() { return estudante; }
}
