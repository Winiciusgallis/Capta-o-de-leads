package io.github.rafaelyudji.rest;

import io.github.rafaelyudji.model.entity.Cliente;
import io.github.rafaelyudji.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {

        this.repository = repository;
    }
    @Autowired
    public void setRepository(ClienteRepository repository){

        this.repository = repository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salver(@RequestBody Cliente cliente){
    return repository.save(cliente);
    }
    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
    return repository
            .findById(id)
            .orElseThrow( () -> new RuntimeException(String.valueOf(HttpStatus.NOT_FOUND)) );
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new RuntimeException(String.valueOf(HttpStatus.NOT_FOUND)) );
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        repository
                .findById(id)
                .map(cliente -> {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setCpf(clienteAtualizado.getCpf());
                 return repository.save(cliente);
                })
                .orElseThrow( () -> new RuntimeException(String.valueOf(HttpStatus.NOT_FOUND)) );
    }
}
