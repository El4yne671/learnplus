package br.edu.learnplus.service;

public interface Autenticavel {
    boolean login(String email, String senha);
    void logout();
    boolean isAutenticado();
}
