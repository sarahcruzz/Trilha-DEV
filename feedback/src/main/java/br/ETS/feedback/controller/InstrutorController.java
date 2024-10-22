package br.ETS.feedback.controller;

import br.ETS.feedback.instrutor.dto.DadosCadastroInstrutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroInstrutor dadosCadastroInstrutor){
        System.out.println(dadosCadastroInstrutor);
    }
}
