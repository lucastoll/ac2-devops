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
        // Criando o DTO com dados de teste
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setName("testUser  ");
        alunoDTO.setRa("123456");
        alunoDTO.setEmail("test@example.com");

        // Criando o objeto Aluno a partir do DTO
        Aluno aluno = new Aluno();
        aluno.setId(1L); // Definindo um ID fictício
        aluno.setUsername(alunoDTO.getName());
        aluno.setRa(new Aluno_Registro_Academico(alunoDTO.getRa()));
        aluno.setEmail(new Aluno_Email(alunoDTO.getEmail()));

        // Simulando o comportamento do repositório
        when(alunoRepository.save(aluno)).thenReturn(aluno);

        // Chamando o método a ser testado
        Aluno createdAluno = alunoService.createAluno(alunoDTO);

        // Verificando se os dados retornados estão corretos
        assertEquals(aluno.getUsername(), createdAluno.getUsername());
        assertEquals(aluno.getRa().getRa(), createdAluno.getRa().getRa());
        assertEquals(aluno.getEmail().getEmailAddress(), createdAluno.getEmail().getEmailAddress());
    }

    @Test
    public void testGetAllAlunos() {
        // Criando uma lista de alunos para o teste
        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setUsername("testUser  ");
        aluno.setRa(new Aluno_Registro_Academico("123456"));
        aluno.setEmail(new Aluno_Email("test@example.com"));
        alunos.add(aluno);

        // Simulando o comportamento do repositório
        when(alunoRepository.findAll()).thenReturn(alunos);

        // Chamando o método a ser testado
        List<AlunoDTO> alunoDTOs = alunoService.getAllAlunos();

        // Verificando se os dados retornados estão corretos
        assertEquals(1, alunoDTOs.size());
        assertEquals(aluno.getUsername(), alunoDTOs.get(0).getName());
        assertEquals(aluno.getRa().getRa(), alunoDTOs.get(0).getRa());
        assertEquals(aluno.getEmail().getEmailAddress(), alunoDTOs.get(0).getEmail());
    }
}