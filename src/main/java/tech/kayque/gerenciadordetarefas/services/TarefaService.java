package tech.kayque.gerenciadordetarefas.services;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import tech.kayque.gerenciadordetarefas.models.Tarefa;
import tech.kayque.gerenciadordetarefas.repositories.TarefaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTodas(){
        return tarefaRepository.findAll();
    }

    public Tarefa criarTarefa(@Valid Tarefa tarefaDTO){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setConcluida(tarefaDTO.getConcluida());
        return tarefaRepository.save(tarefa);
    }

    public Tarefa obterPorId(UUID id){
        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa atualizarTarefa(UUID id, @Valid Tarefa tarefaDTO){
        Tarefa tarefa = obterPorId(id);
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setConcluida(tarefaDTO.getConcluida());
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(UUID id){
        tarefaRepository.deleteById(id);
    }
}
