package ac2_project.example.ac2_ca.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno();
    }

    @Test
    public void testGetSetId() {
        aluno.setId(1L);
        assertEquals(1L, aluno.getId());
    }

    @Test
    public void testGetSetUsername() {
        aluno.setUsername("testUser ");
        assertEquals("testUser ", aluno.getUsername());
    }

    @Test
    public void testGetSetRa() {
        Aluno_Registro_Academico ra = new Aluno_Registro_Academico(); 
        aluno.setRa(ra);
        assertEquals(ra, aluno.getRa());
    }

    @Test
    public void testConcluirCursoPremium() {
        aluno.setPremium(true);
        aluno.concluirCurso();
        assertEquals(3, aluno.getMoedas());
    }

    @Test
    public void testConcluirCursoNotPremium() {
        aluno.setPremium(false);
        aluno.concluirCurso();
        assertEquals(0, aluno.getMoedas());
    }

    @Test
    public void testGetSetMoedas() {
        aluno.setMoedas(5); 
        assertEquals(5, aluno.getMoedas());
    }

    @Test
    public void testIsPremium() {
        aluno.setPremium(true);
        assertTrue(aluno.isPremium());
    }

    @Test
    public void testIsNotPremium() {
        aluno.setPremium(false);
        assertFalse(aluno.isPremium());
    }
}