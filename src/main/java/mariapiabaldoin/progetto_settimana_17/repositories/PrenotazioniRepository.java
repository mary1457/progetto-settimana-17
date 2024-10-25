package mariapiabaldoin.progetto_settimana_17.repositories;

import mariapiabaldoin.progetto_settimana_17.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, Long> {

    @Query("SELECT p FROM Prenotazione p WHERE p.postazione.id = :id AND p.dataInizio =:data  ")
    List<Prenotazione> filterByPostazioneId(UUID id, LocalDate data);

    @Query("SELECT p FROM Prenotazione p WHERE p.utente.id = :utenteId AND p.dataInizio =:data  ")
    List<Prenotazione> filterByUtenteData(UUID utenteId, LocalDate data);
}
