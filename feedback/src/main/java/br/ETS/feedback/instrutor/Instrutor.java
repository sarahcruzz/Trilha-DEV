package br.ETS.feedback.instrutor;

import br.ETS.feedback.informacoes.Informacoes;
import br.ETS.feedback.instrutor.dto.DadosCadastroInstrutor;
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

    public Instrutor(DadosCadastroInstrutor dadosCadastroInstrutor){
        this.nome = dadosCadastroInstrutor.nome();
        this.email = dadosCadastroInstrutor.email();
        this.edv = dadosCadastroInstrutor.edv();
        this.curso = dadosCadastroInstrutor.curso();

        this.informacoes = new Informacoes(dadosCadastroInstrutor.informacoes());

        this.ferias = dadosCadastroInstrutor.ferias();
    }


}
