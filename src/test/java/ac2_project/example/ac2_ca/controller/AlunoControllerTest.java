package ac2_project.example.ac2_ca.controller;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AlunoControllerTest {

    @InjectMocks
    private AlunoController alunoController;

    @Mock
    private AlunoService alunoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser () {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setName("testUser ");
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setUsername("testUser ");

        when(alunoService.createAluno(alunoDTO)).thenReturn(aluno);

        ResponseEntity<Aluno> response = alunoController.createUser (alunoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(aluno, response.getBody());
    }

    @Test
    public void testGetAllAlunos() {
        List<AlunoDTO> alunos = new ArrayList<>();
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setName("testUser ");
        alunos.add(alunoDTO);

        when(alunoService.getAllAlunos()).thenReturn(alunos);

        ResponseEntity<List<AlunoDTO>> response = alunoController.getAllAlunos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(alunos, response.getBody());
    }
}