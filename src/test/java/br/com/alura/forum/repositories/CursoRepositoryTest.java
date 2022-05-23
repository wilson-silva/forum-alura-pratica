package br.com.alura.forum.repositories;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloNome(){
        String nomeCurso = "HTML 5";
        Curso curso = repository.findByNome(nomeCurso);
        assertNotNull(curso);
        assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void naoDeveriaCarregarUmCursoAoBuscarPeloNome(){
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);
        assertNull(curso);

    }

}