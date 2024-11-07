package ac2_project.example.ac2_ca.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Aluno_Email {

    private String emailAddress;

    protected Aluno_Email() {}

    public Aluno_Email(String emailAddress) {
        if (emailAddress == null || !emailAddress.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno_Email email = (Aluno_Email) o;
        return Objects.equals(emailAddress, email.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

	
}