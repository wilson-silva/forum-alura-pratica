package br.com.alura.forum.controller;


import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public TopicosController() {
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Cacheable(value = "listaDeTopicos")
    public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso,
                                 @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
                                         Pageable paginacao) {
        if (nomeCurso == null) {
            Page<Topico> topicos = topicoRepository.findAll(paginacao);
            return TopicoDto.converter(topicos);
        } else {
            Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form,
                                               UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Altera um topico pelo ID")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            Topico topico = form.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
