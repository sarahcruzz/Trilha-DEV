package br.ETS.feedback.controller;

import br.ETS.feedback.instrutor.Instrutor;
import br.ETS.feedback.instrutor.InstrutorRepository;
import br.ETS.feedback.instrutor.dto.DadosCadastroInstrutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor){
        instrutorRepository.save(new Instrutor(dadosCadastroInstrutor));
    }
}
