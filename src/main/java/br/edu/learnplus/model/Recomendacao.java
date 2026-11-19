package br.edu.learnplus.model;

public class Recomendacao {
    private Conteudo conteudo;
    private String motivo;

    public Recomendacao(Conteudo conteudo, String motivo) {
        this.conteudo = conteudo;
        this.motivo = motivo;
    }

    public Conteudo getConteudo() { return conteudo; }
    public String getMotivo() { return motivo; }

    @Override
    public String toString() {
        return "Recomendação: " + conteudo.getTitulo() + " — " + motivo;
    }
}
