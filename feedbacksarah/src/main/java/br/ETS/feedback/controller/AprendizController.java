package br.ETS.feedback.controller;


import br.ETS.feedback.model.aprendiz.Aprendiz;
import br.ETS.feedback.model.aprendiz.AprendizRepository;
import br.ETS.feedback.model.aprendiz.dto.DadosCadastroAprendiz;
import br.ETS.feedback.model.aprendiz.dto.DadosListagemAprendiz;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/aprendiz")
public class AprendizController {

    @Autowired
    private AprendizRepository aprendizRepository;

    @PostMapping
    public ResponseEntity<DadosListagemAprendiz> cadastrar(@RequestBody @Valid DadosCadastroAprendiz dadosCadastroAprendiz, UriComponentsBuilder uriComponentsBuilder){
        var aprendiz = new Aprendiz(dadosCadastroAprendiz);
        aprendizRepository.save(aprendiz);
        var uri = uriComponentsBuilder.path("aprendiz/{id}").buildAndExpand(aprendiz.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemAprendiz(aprendiz));
    }

}
