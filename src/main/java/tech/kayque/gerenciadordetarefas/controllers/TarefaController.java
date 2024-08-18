package tech.kayque.gerenciadordetarefas.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.kayque.gerenciadordetarefas.models.Tarefa;
import tech.kayque.gerenciadordetarefas.services.TarefaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tarefas")
@Validated
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        return new ResponseEntity<>(tarefaService.listarTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa tarefa){
        return new ResponseEntity<>(tarefaService.criarTarefa(tarefa), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> obterTarefaPorId(@PathVariable UUID id) {
        return new ResponseEntity<>(tarefaService.obterPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable UUID id, @Valid @RequestBody Tarefa tarefa){
        return new ResponseEntity<>(tarefaService.atualizarTarefa(id, tarefa), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable UUID id) {
        tarefaService.deletarTarefa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
