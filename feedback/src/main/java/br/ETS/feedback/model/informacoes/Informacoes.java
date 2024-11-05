package br.ETS.feedback.model.informacoes;


import br.ETS.feedback.model.aprendiz.dto.DadosInformacoesAprendiz;
import br.ETS.feedback.model.instrutor.dto.DadosInformacoes;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter // faz métodos get para todos os atributos
@Setter // faz métodos set para todos os atriutos
@AllArgsConstructor // cria um construtor com todos os parâmetros de atributo da classe
@NoArgsConstructor // cria um construtor padrão sem atributos
@EqualsAndHashCode // faz o métodos equals e hashcode
@Embeddable
public class Informacoes {

    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;

    public Informacoes(DadosInformacoes dadosInformacoes){
        this.disciplina = dadosInformacoes.disciplina();
        this.trilha = dadosInformacoes.trilha();
        this.faculdade = dadosInformacoes.faculdade();
        this.turma = dadosInformacoes.turma();
    }


    // criar um novo dto para informação sem a disciplina
    public Informacoes(DadosInformacoesAprendiz dadosInformacoesAprendiz){
        this.trilha = dadosInformacoesAprendiz.trilha();
        this.faculdade = dadosInformacoesAprendiz.faculdade();
        this.turma = dadosInformacoesAprendiz.turma();
    }

    public void atualizar(DadosInformacoes dadosInformacoes){
        this.disciplina = dadosInformacoes.disciplina() != null ? dadosInformacoes.disciplina() : this.disciplina;
        this.trilha = dadosInformacoes.trilha() != null ? dadosInformacoes.trilha() : this.trilha;
        this.faculdade = dadosInformacoes.faculdade() != null ? dadosInformacoes.faculdade() : this.faculdade;
        this.turma = dadosInformacoes.turma() != null ? dadosInformacoes.turma() : this.turma;
    }

    public void atualizarAprendiz(DadosInformacoesAprendiz dadosInformacoesAprendiz){
        this.trilha = dadosInformacoesAprendiz.trilha() != null ? dadosInformacoesAprendiz.trilha() : this.trilha;
        this.faculdade = dadosInformacoesAprendiz.faculdade() != null ? dadosInformacoesAprendiz.faculdade() : this.faculdade;
        this.turma = dadosInformacoesAprendiz.turma() != null ? dadosInformacoesAprendiz.turma() : this.turma;
    }

}
