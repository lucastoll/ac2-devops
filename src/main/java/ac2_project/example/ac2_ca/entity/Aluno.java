package ac2_project.example.ac2_ca.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    private String username;
    private int moedas = 0;
    private boolean premium = false;


    @Embedded
    private Aluno_Email email;
    
    @Embedded
    private Aluno_Registro_Academico ra;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    
    public void concluirCurso() {
        if (premium) {
            moedas += 3;
        }
    }

    public int getMoedas() {
        return moedas;
    }
    
    public boolean isPremium() {
        return premium;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public Aluno_Email getEmail() {
        return email;
    }

    public void setEmail(Aluno_Email email) {
        this.email = email;
    }
    
    public Aluno_Registro_Academico getRa() {
        return ra;
    }
    
    
    public void setRa(Aluno_Registro_Academico ra) {
        this.ra = ra;
    }

	public void setPremium(boolean b) {
		this.premium = b;
	}

	public void setMoedas(int i) {
		this.moedas = i;
	}
}