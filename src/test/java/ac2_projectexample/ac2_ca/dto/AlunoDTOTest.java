package ac2_projectexample.ac2_ca.dto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ac2_project.example.ac2_ca.dto.AlunoDTO;

import static org.junit.jupiter.api.Assertions.*;


public class AlunoDTOTest {

    private AlunoDTO alunoDTO;

    @BeforeEach
    public void setUp() {
        alunoDTO = new AlunoDTO();
    }

    @Test
    public void testGetSetName() {
        String name = "Test Name";
        alunoDTO.setName(name);
        assertEquals(name, alunoDTO.getName());
    }

    @Test
    public void testGetSetEmail() {
        String email = "test@example.com";
        alunoDTO.setEmail(email);
        assertEquals(email, alunoDTO.getEmail());
    }

    @Test
    public void testGetSetRa() {
        String ra = "123456";
        alunoDTO.setRa(ra);
        assertEquals(ra, alunoDTO.getRa());
    }
}