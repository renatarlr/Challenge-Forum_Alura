package estudante.alura.forum.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarTopico(

    Long id,
    @NotBlank
    String titulo,
    @NotBlank
    String mensagem,
    String status,
    @NotBlank
    String autor,
    @NotBlank
    String curso){

}

