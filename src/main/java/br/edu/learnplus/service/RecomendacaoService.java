package br.edu.learnplus.service;

import br.edu.learnplus.model.*;
import java.util.ArrayList;
import java.util.List;

public class RecomendacaoService {
    private static final double LIMITE_DIFICULDADE = 60.0;

    public List<Recomendacao> recomendar(Estudante estudante, List<Conteudo> disponiveis) {
        List<Recomendacao> recomendacoes = new ArrayList<>();
        for (Conteudo c : disponiveis) {
            double percentual = estudante.getProgresso().getPercentualAcerto(c);
            if (percentual > 0 && percentual < LIMITE_DIFICULDADE) {
                recomendacoes.add(new Recomendacao(c,
                        String.format("Desempenho de %.1f%% — revisar conteúdo", percentual)));
            }
        }
        return recomendacoes;
    }
}
