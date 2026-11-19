package br.edu.learnplus.model;

public abstract class Conteudo {
    private Long id;
    private String titulo;
    private String descricao;

    public Conteudo(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public abstract String getTipoConteudo();

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
}
