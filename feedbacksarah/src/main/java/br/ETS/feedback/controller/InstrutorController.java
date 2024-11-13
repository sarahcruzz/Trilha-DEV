package br.ETS.feedback.controller;

import br.ETS.feedback.infra.DadosInformacoesCompletas;
import br.ETS.feedback.model.instrutor.Instrutor;
import br.ETS.feedback.model.instrutor.InstrutorRepository;
import br.ETS.feedback.model.instrutor.dto.DadosAtualizacaoInstrutor;
import br.ETS.feedback.model.instrutor.dto.DadosCadastroInstrutor;
import br.ETS.feedback.model.instrutor.dto.DadosListagemInstrutor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public ResponseEntity<DadosListagemInstrutor> cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor, UriComponentsBuilder uriComponentsBuilder ){
        var instrutor = new Instrutor(dadosCadastroInstrutor);
        instrutorRepository.save(instrutor);
        var uri = uriComponentsBuilder.path("/instrutor/{id}").buildAndExpand(instrutor.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosListagemInstrutor(instrutor));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listar (@PageableDefault( size = 5, sort = {"edv"} ) Pageable pageable){
        var page = instrutorRepository.findAllByAtivoTrue(pageable).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor){
        var instrutor = instrutorRepository.getReferenceById(dadosAtualizacaoInstrutor.id());
        instrutor.atualizar(dadosAtualizacaoInstrutor);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Instrutor> excluir(@PathVariable int id){
        var instrutor = instrutorRepository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosInformacoesCompletas> detalharInstrutor(@PathVariable int id){
        var instrutor = instrutorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosInformacoesCompletas(instrutor));
    }








}
