package ac2_project.example.ac2_ca.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ac2_project.example.ac2_ca.entity.Aluno;

@DataJpaTest
public class AlunoRepositoryTest {

    @Autowired
    private Aluno_Repository alunoRepository;

    private Aluno aluno;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno();
        aluno.setUsername("testUser ");
        aluno.setPremium(true);
    }

    @Test
    @Rollback(false) 
    public void testSaveAluno() {
        Aluno savedAluno = alunoRepository.save(aluno);
        assertThat(savedAluno).isNotNull();
        assertThat(savedAluno.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindById() {
        Aluno savedAluno = alunoRepository.save(aluno);
        Aluno foundAluno = alunoRepository.findById(savedAluno.getId()).orElse(null);
        assertThat(foundAluno).isNotNull();
        assertThat(foundAluno.getUsername()).isEqualTo(savedAluno.getUsername());
    }

    @Test
    public void testDeleteAluno() {
        Aluno savedAluno = alunoRepository.save(aluno);
        alunoRepository.delete(savedAluno);
        Aluno foundAluno = alunoRepository.findById(savedAluno.getId()).orElse(null);
        assertThat(foundAluno).isNull();
    }
}