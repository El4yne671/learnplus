package br.edu.learnplus.model;

import java.time.LocalDateTime;

public class Tentativa {
    private Long id;
    private Exercicio exercicio;
    private Alternativa resposta;
    private boolean acertou;
    private LocalDateTime dataHora;

    public Tentativa(Long id, Exercicio exercicio, Alternativa resposta, boolean acertou) {
        this.id = id;
        this.exercicio = exercicio;
        this.resposta = resposta;
        this.acertou = acertou;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Exercicio getExercicio() { return exercicio; }
    public Alternativa getResposta() { return resposta; }
    public boolean isAcertou() { return acertou; }
    public LocalDateTime getDataHora() { return dataHora; }
}
