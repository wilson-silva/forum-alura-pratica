package br.com.alura.forum.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne
    private Topico topico;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    private Usuario autor;

    private Boolean solucao = false;
}
