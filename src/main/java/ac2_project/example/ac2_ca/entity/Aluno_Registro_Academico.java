package ac2_project.example.ac2_ca.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class Aluno_Registro_Academico {
    private String ra;

    protected Aluno_Registro_Academico() {}

    public Aluno_Registro_Academico(String ra) {
        if (ra == null || ra.trim().isEmpty()) {
            throw new IllegalArgumentException("RA inválido");
        }
        this.ra = ra;
    }

    public String getRa() {
        return ra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno_Registro_Academico that = (Aluno_Registro_Academico) o;
        return Objects.equals(ra, that.ra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ra);
    }
}