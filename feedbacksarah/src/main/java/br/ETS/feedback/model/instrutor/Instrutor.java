package br.ETS.feedback.model.instrutor;

import br.ETS.feedback.model.Curso;
import br.ETS.feedback.model.informacoes.Informacoes;
import br.ETS.feedback.model.instrutor.dto.DadosAtualizacaoInstrutor;
import br.ETS.feedback.model.instrutor.dto.DadosCadastroInstrutor;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Entity(name = "Instrutor")
@Table(name = "tb_instrutores")
public class Instrutor {
    // atributos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Instrutor(DadosCadastroInstrutor dadosCadastroInstrutor){
        this.nome = dadosCadastroInstrutor.nome();
        this.email = dadosCadastroInstrutor.email();
        this.edv = dadosCadastroInstrutor.edv();
        this.curso = dadosCadastroInstrutor.curso();

        this.informacoes = new Informacoes(dadosCadastroInstrutor.informacoes());

        this.ferias = dadosCadastroInstrutor.ferias();
        this.ativo=true;
    }

    public void atualizar(DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor){
        if (dadosAtualizacaoInstrutor.nome() != null){
            this.nome = dadosAtualizacaoInstrutor.nome();
        }

        if (dadosAtualizacaoInstrutor.email() != null){
            this.email = dadosAtualizacaoInstrutor.email();
        }

        if (dadosAtualizacaoInstrutor.edv() != null){
            this.edv = dadosAtualizacaoInstrutor.edv();
        }

        if (dadosAtualizacaoInstrutor.curso() != null){
            this.curso = dadosAtualizacaoInstrutor.curso();
        }

        if (dadosAtualizacaoInstrutor.ferias() != null){
            this.ferias = dadosAtualizacaoInstrutor.ferias();
        }

        if (dadosAtualizacaoInstrutor.informacoes() != null){
            this.informacoes.atualizar(dadosAtualizacaoInstrutor.informacoes());
        }

    }

    public void excluir(){
        this.ativo = false;
    }

}