package br.ETS.feedback.controller;

import br.ETS.feedback.instrutor.Instrutor;
import br.ETS.feedback.instrutor.InstrutorRepository;
import br.ETS.feedback.instrutor.dto.DadosAtualizacaoInstrutor;
import br.ETS.feedback.instrutor.dto.DadosCadastroInstrutor;
import br.ETS.feedback.instrutor.dto.DadosListagemInstrutor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor){
        instrutorRepository.save(new Instrutor(dadosCadastroInstrutor));
    }

    @GetMapping
    public Page<DadosListagemInstrutor> listar (@PageableDefault( size = 5, sort = {"edv"} ) Pageable pageable){
        return  instrutorRepository.findAll(pageable).map(DadosListagemInstrutor::new);
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor){
        var instrutor = instrutorRepository.getReferenceById(dadosAtualizacaoInstrutor.id());
        instrutor.atualizar(dadosAtualizacaoInstrutor);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        instrutorRepository.deleteById(id);
    }






}
