package br.ETS.feedback.model.aprendiz.dto;

import br.ETS.feedback.model.Curso;
import br.ETS.feedback.model.aprendiz.Aprendiz;

public record DadosListagemAprendiz(
        String nome,
        String email,
        String edv,
        Boolean ferias,
        Curso curso
) {

    public DadosListagemAprendiz(Aprendiz aprendiz){
        this(aprendiz.getNome(),
                aprendiz.getEmail(),
                aprendiz.getEdv(),
                aprendiz.getFerias(),
                aprendiz.getCurso());
    }
}
