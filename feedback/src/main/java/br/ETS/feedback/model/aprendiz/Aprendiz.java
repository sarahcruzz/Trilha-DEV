package br.ETS.feedback.model.aprendiz;

import br.ETS.feedback.model.Curso;
import br.ETS.feedback.model.aprendiz.dto.DadosAtualizacaoAprendiz;
import br.ETS.feedback.model.aprendiz.dto.DadosCadastroAprendiz;
import br.ETS.feedback.model.informacoes.Informacoes;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Entity(name = "Aprendiz")
@Table(name = "tb_aprendizes")
public class Aprendiz {
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded
    private Informacoes informacoes;

    private Boolean ferias;
    private boolean ativo;


    public Aprendiz(DadosCadastroAprendiz dadosCadastroAprendiz){
        this.nome = dadosCadastroAprendiz.nome();
        this.email = dadosCadastroAprendiz.email();
        this.edv = dadosCadastroAprendiz.edv();
        this.curso = dadosCadastroAprendiz.curso();
        this.informacoes = new Informacoes(dadosCadastroAprendiz.informacoes());
        this.ferias = dadosCadastroAprendiz.ferias();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoAprendiz dadosAtualizacaoAprendiz){
        if (dadosAtualizacaoAprendiz.nome() != null){
            this.nome = dadosAtualizacaoAprendiz.nome();
        }

        if (dadosAtualizacaoAprendiz.email() != null){
            this.email = dadosAtualizacaoAprendiz.email();
        }

        if (dadosAtualizacaoAprendiz.edv() != null){
            this.edv = dadosAtualizacaoAprendiz.edv();
        }

        if (dadosAtualizacaoAprendiz.curso() != null){
            this.curso = dadosAtualizacaoAprendiz.curso();
        }

        if (dadosAtualizacaoAprendiz.ferias() != null){
            this.ferias = dadosAtualizacaoAprendiz.ferias();
        }

        if (dadosAtualizacaoAprendiz.informacoes() != null){
            this.informacoes.atualizarAprendiz(dadosAtualizacaoAprendiz.informacoes());
        }

    }

    public void excluir(){
        this.ativo = false;
    }





}
