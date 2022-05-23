package br.com.alura.forum.repositories;


import br.com.alura.forum.modelo.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
