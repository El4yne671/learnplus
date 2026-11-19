package br.edu.learnplus.model;

import java.util.Objects;

public class Alternativa {
    private Long id;
    private String texto;

    public Alternativa(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Long getId() { return id; }
    public String getTexto() { return texto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alternativa)) return false;
        Alternativa that = (Alternativa) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
