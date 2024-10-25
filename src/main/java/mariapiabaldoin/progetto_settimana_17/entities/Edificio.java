package mariapiabaldoin.progetto_settimana_17.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "edifici")
@Getter
@Setter
@NoArgsConstructor


public class Edificio {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "edificio_id")
    private UUID edificioId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazione;

    public Edificio(String nome, String indirizzo, String citta) {

        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;

    }

    @Override
    public String toString() {
        return "Edificio{" +
                "edificioId=" + edificioId +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta +
                '}';
    }
}
