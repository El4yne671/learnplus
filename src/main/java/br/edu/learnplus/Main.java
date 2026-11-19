package br.edu.learnplus;

import br.edu.learnplus.exception.AutenticacaoException;
import br.edu.learnplus.model.*;
import br.edu.learnplus.service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Learn+ — Demonstração do Fluxo Principal ===\n");

        String senhaPlana = "123456";
        String hash = Integer.toHexString(senhaPlana.hashCode());

        Estudante estudante = new Estudante(1L, "Júlia", "julia@email.com", hash);
        AutenticacaoService authService = new AutenticacaoService();
        authService.cadastrar(estudante);

        try {
            Usuario logado = authService.autenticar("julia@email.com", senhaPlana);
            System.out.println("✔️ Login realizado: " + logado.getNome()
                    + " (" + logado.getTipoPerfil() + ")");
        } catch (AutenticacaoException e) {
            System.out.println("✘ " + e.getMessage());
            return;
        }

        Aula aula = new Aula(1L, "Introdução a Frações",
                "Conceitos básicos de frações", "https://video.ex/aula1", 15);

        Exercicio exercicio = new Exercicio(2L, "Soma de frações",
                "Qual é o resultado de 1/2 + 1/4?");
        Alternativa a1 = new Alternativa(1L, "2/6");
        Alternativa a2 = new Alternativa(2L, "3/4");
        Alternativa a3 = new Alternativa(3L, "1/6");
        exercicio.adicionarAlternativa(a1);
        exercicio.adicionarAlternativa(a2);
        exercicio.adicionarAlternativa(a3);
        exercicio.definirCorreta(a2);

        List<Conteudo> disponiveis = List.of(aula, exercicio);

        CorrecaoService correcao = new CorrecaoService();
        Tentativa t1 = correcao.corrigir(estudante, exercicio, a1, 1L);
        System.out.println("\nTentativa 1 — Resposta: " + t1.getResposta().getTexto()
                + " → " + (t1.isAcertou() ? "ACERTOU" : "ERROU"));

        Tentativa t2 = correcao.corrigir(estudante, exercicio, a1, 2L);
        System.out.println("Tentativa 2 — Resposta: " + t2.getResposta().getTexto()
                + " → " + (t2.isAcertou() ? "ACERTOU" : "ERROU"));

        double perc = estudante.getProgresso().getPercentualAcerto(exercicio);
        System.out.printf("\nDesempenho no exercício: %.1f%%%n", perc);

        RecomendacaoService recService = new RecomendacaoService();
        List<Recomendacao> recs = recService.recomendar(estudante, disponiveis);
        System.out.println("\n--- Recomendações ---");
        if (recs.isEmpty()) {
            System.out.println("Nenhuma recomendação no momento.");
        } else {
            recs.forEach(System.out::println);
        }

        authService.logout(estudante);
        System.out.println("\n✔️ Logout realizado. Autenticado? " + estudante.isAutenticado());
    }
}
