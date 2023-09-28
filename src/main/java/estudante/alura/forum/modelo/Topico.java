package estudante.alura.forum.modelo;

import estudante.alura.forum.DTO.DadosAtualizarTopico;
import estudante.alura.forum.DTO.DadosCadastroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Table (name = "topico")
@Entity (name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")

public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String status;
    private String autor;
    private String curso;

    public Topico (DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.status = dados.status();
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

    public void atualizarinformacoes(@NotNull DadosAtualizarTopico dados) {
        if(dados.titulo() != null ) {
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null ) {
            this.mensagem = dados.mensagem();
        }
        if(dados.status() != null ) {
            this.status = dados.status();
        }
        if(dados.autor() != null ) {
            this.autor = dados.autor();
        }
        if(dados.curso() != null ) {
            this.curso = dados.curso();
        }
    }
}
