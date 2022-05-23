package br.com.alura.forum.controller.form;


import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositories.TopicoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoTopicoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String titulo;

    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String mensagem;

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getById(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }
}
