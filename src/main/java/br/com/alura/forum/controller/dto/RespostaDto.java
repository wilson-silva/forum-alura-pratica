package br.com.alura.forum.controller.dto;


import br.com.alura.forum.modelo.Resposta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaDto {

    private Long id;

    private String mensagen;

    private LocalDateTime dataCriacao;

    private String nomeAutor;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagen = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

}
