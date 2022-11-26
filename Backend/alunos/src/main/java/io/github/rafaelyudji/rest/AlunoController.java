package io.github.rafaelyudji.rest;

import io.github.rafaelyudji.model.entity.Aluno;
import io.github.rafaelyudji.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private AlunoRepository repository;

    @Autowired
    public AlunoController(AlunoRepository repository) {

        this.repository = repository;
    }
    @Autowired
    public void setRepository(AlunoRepository repository){

        this.repository = repository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salver(@RequestBody @Valid Aluno aluno){
    return repository.save(aluno);
    }
    @GetMapping("{id}")
    public Aluno acharPorId(@PathVariable Integer id){
    return repository
            .findById(id)
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(aluno -> {
                    repository.delete(aluno);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException (HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Aluno alunoAtualizado){
        repository
                .findById(id)
                .map(aluno -> {
                aluno.setNome(alunoAtualizado.getNome());
                aluno.setTelefone(alunoAtualizado.getTelefone());
                aluno.setCidade(alunoAtualizado.getCidade());
                aluno.setEstado(alunoAtualizado.getEstado());
                aluno.setCurso(alunoAtualizado.getCurso());
                aluno.setCodCurso(alunoAtualizado.getCodCurso());
                aluno.setEmail(alunoAtualizado.getEmail());
                 return repository.save(aluno);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }
}
