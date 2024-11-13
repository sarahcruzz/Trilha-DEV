package br.ETS.feedback.model.instrutor.dto;

import br.ETS.feedback.model.Curso;
import br.ETS.feedback.model.instrutor.Instrutor;

public record DadosListagemInstrutor(
        String nome,
        String email,
        String edv,
        Boolean ferias,
        Curso curso
) {
    // construtor do dto - receber como parâmetro a entidade e jogar os dados para o dto
    public DadosListagemInstrutor(Instrutor instrutor){
        this(instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getFerias(),
                instrutor.getCurso());
    }

}
