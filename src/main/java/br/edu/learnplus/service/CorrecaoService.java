package br.edu.learnplus.service;

import br.edu.learnplus.model.*;

public class CorrecaoService {
    public Tentativa corrigir(Estudante estudante, Exercicio exercicio, Alternativa resposta, Long idTentativa) {
        boolean acertou = exercicio.corrigir(resposta);
        Tentativa t = new Tentativa(idTentativa, exercicio, resposta, acertou);
        estudante.registrarTentativa(t);
        estudante.getProgresso().registrar(exercicio, acertou);
        return t;
    }
}
