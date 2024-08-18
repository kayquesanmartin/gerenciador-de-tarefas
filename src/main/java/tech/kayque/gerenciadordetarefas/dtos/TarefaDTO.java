package tech.kayque.gerenciadordetarefas.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TarefaDTO {
    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    private boolean concluida;
}
