package br.ETS.feedback.infra;

import br.ETS.feedback.model.aprendiz.Aprendiz;
import br.ETS.feedback.model.informacoes.Informacoes;
import br.ETS.feedback.model.Curso;
import br.ETS.feedback.model.instrutor.Instrutor;

public record DadosInformacoesCompletas(
        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        boolean ferias,
        boolean ativo,
        Informacoes informacoes
) {

    public DadosInformacoesCompletas(Instrutor instrutor){
        this(
            instrutor.getId(),
            instrutor.getNome(),
            instrutor.getEmail(),
            instrutor.getEdv(),
            instrutor.getCurso(),
            instrutor.getFerias(),
            instrutor.isAtivo(),
            instrutor.getInformacoes()
        );
    }

    public DadosInformacoesCompletas(Aprendiz aprendiz){
        this(aprendiz.getId(),
                aprendiz.getNome(),
                aprendiz.getEmail(),
                aprendiz.getEdv(),
                aprendiz.getCurso(),
                aprendiz.getFerias(),
                aprendiz.isAtivo(),
                aprendiz.getInformacoes());
    }

}
