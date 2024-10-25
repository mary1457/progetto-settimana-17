package mariapiabaldoin.progetto_settimana_17.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor


public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "prenotazione_id")
    private long id;

    @Column(nullable = false)
    private LocalDate dataInizio;

    @Column(nullable = false)
    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;

    public Prenotazione(LocalDate dataInizio, Utente utente, Postazione postazione) {
        this.dataInizio = dataInizio;
        this.dataFine = dataInizio.plusDays(1);
        this.utente = utente;
        this.postazione = postazione;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", utente=" + utente +
                ", postazione=" + postazione +
                '}';
    }
}
