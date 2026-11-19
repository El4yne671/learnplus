package br.edu.learnplus.model;

public class Aula extends Conteudo {
    private String urlVideo;
    private int duracaoMinutos;

    public Aula(Long id, String titulo, String descricao, String urlVideo, int duracaoMinutos) {
        super(id, titulo, descricao);
        this.urlVideo = urlVideo;
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String getTipoConteudo() { return "AULA"; }

    public String getUrlVideo() { return urlVideo; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
}
