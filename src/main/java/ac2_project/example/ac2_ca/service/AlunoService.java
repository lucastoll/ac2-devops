package ac2_project.example.ac2_ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;
import ac2_project.example.ac2_ca.entity.Aluno_Registro_Academico;
import ac2_project.example.ac2_ca.repository.Aluno_Repository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private Aluno_Repository alunoRepository; 

    public Aluno createAluno(AlunoDTO alunoDTO) {
        Aluno user = new Aluno();
        user.setUsername(alunoDTO.getName());
        user.setRa(new Aluno_Registro_Academico(alunoDTO.getRa()));
        user.setEmail(new Aluno_Email(alunoDTO.getEmail()));
        return alunoRepository.save(user);
    }

    public List<AlunoDTO> getAllAlunos() { 
        return alunoRepository.findAll().stream()
                .map(aluno -> {
                	AlunoDTO dto = new AlunoDTO();
                    dto.setName(aluno.getUsername());
                    dto.setRa(aluno.getRa().getRa());
                    dto.setEmail(aluno.getEmail().getEmailAddress());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}