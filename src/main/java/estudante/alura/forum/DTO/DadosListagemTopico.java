package estudante.alura.forum.DTO;

import estudante.alura.forum.modelo.Topico;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        String status,
        String autor,
        String curso) {
   public DadosListagemTopico( Topico topico){
   this(topico.getId(), topico.getTitulo(),topico. getMensagem(),topico.getStatus(),topico.getAutor(),topico.getCurso());
   }
}
