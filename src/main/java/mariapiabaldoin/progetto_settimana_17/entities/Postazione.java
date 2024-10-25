package mariapiabaldoin.progetto_settimana_17.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor


public class Postazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "postazione_id")
    private UUID postazioneId;

    @Column(nullable = false)
    private String descrizione;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(nullable = false)
    private int numeroOccupanti;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazione;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, Tipo tipo, int numeroOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroOccupanti = numeroOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazioni{" +
                "UUID=" + postazioneId +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", numeroOccupanti=" + numeroOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
