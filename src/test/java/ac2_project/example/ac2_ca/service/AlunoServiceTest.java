package ac2_project.example.ac2_ca.service;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;
import ac2_project.example.ac2_ca.entity.Aluno_Registro_Academico;
import ac2_project.example.ac2_ca.repository.Aluno_Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private Aluno_Repository alunoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAluno() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setName("testUser  ");
        alunoDTO.setRa("123456");
        alunoDTO.setEmail("test@example.com");

        Aluno aluno = new Aluno();
        aluno.setId(1L); 
        aluno.setUsername(alunoDTO.getName());
        aluno.setRa(new Aluno_Registro_Academico(alunoDTO.getRa()));
        aluno.setEmail(new Aluno_Email(alunoDTO.getEmail()));

        when(alunoRepository.save(aluno)).thenReturn(aluno);

        Aluno createdAluno = alunoService.createAluno(alunoDTO);
    }

    @Test
    public void testGetAllAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setUsername("testUser  ");
        aluno.setRa(new Aluno_Registro_Academico("123456"));
        aluno.setEmail(new Aluno_Email("test@example.com"));
        alunos.add(aluno);

        when(alunoRepository.findAll()).thenReturn(alunos);

        List<AlunoDTO> alunoDTOs = alunoService.getAllAlunos();

        assertEquals(1, alunoDTOs.size());
        assertEquals(aluno.getUsername(), alunoDTOs.get(0).getName());
        assertEquals(aluno.getRa().getRa(), alunoDTOs.get(0).getRa());
        assertEquals(aluno.getEmail().getEmailAddress(), alunoDTOs.get(0).getEmail());
    }
}