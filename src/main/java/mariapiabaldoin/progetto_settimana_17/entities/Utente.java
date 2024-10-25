package mariapiabaldoin.progetto_settimana_17.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor


public class Utente {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "utente_id")
    private UUID utenteId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazione;

    public Utente(String username, String nome, String email) {
        this.username = username;
        this.nome = nome;
        this.email = email;

    }

    @Override
    public String toString() {
        return "Utente{" +
                "userId=" + utenteId +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


