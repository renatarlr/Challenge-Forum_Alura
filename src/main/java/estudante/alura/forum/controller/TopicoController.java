package estudante.alura.forum.controller;

import estudante.alura.forum.DTO.DadosAtualizarTopico;
import estudante.alura.forum.DTO.DadosCadastroTopico;
import estudante.alura.forum.DTO.DadosListagemTopico;
import estudante.alura.forum.modelo.*;
import estudante.alura.forum.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topico")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        repository.save(new Topico(dados));
        System.out.println("Chegou o cadastro de topico");
        System.out.println(dados);
    }

    @GetMapping
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"curso"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }

      @PutMapping
      @Transactional

      public void atualizar(@RequestBody @Valid DadosAtualizarTopico dados){
      var atualizando = repository.getReferenceById(dados.id());
      atualizando.atualizarinformacoes(dados);
       }

       @DeleteMapping("/{id}")
       @Transactional
        public void excluir(@PathVariable Long id){
        repository.deleteById(id);
       }
}


