package mariapiabaldoin.progetto_settimana_17.services;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.progetto_settimana_17.entities.Postazione;
import mariapiabaldoin.progetto_settimana_17.entities.Prenotazione;
import mariapiabaldoin.progetto_settimana_17.entities.Utente;
import mariapiabaldoin.progetto_settimana_17.exceptions.ValidationException;
import mariapiabaldoin.progetto_settimana_17.repositories.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class PrenotazioniService {
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    public void savePrenotazione(Prenotazione newPrenotazione) {


        if (newPrenotazione.getDataInizio().isBefore(LocalDate.now()))
            throw new ValidationException("Data precedente ad oggi");
        prenotazioniRepository.save(newPrenotazione);

        log.info("La prenotazione " + newPrenotazione + " è stata salvata correttamente!");
    }

    public boolean controlloPostazione(LocalDate data, Postazione postazione) {
        List<Prenotazione> prenotazioni = filterPostazione(postazione.getPostazioneId(), data);
        if (prenotazioni.size() == postazione.getNumeroOccupanti()) {
            return false;
        } else {
            return true;
        }

    }

    public boolean controlloUtente(LocalDate data, Utente utente) {
        List<Prenotazione> prenotazioni = filterUtenteData(utente.getUtenteId(), data);
        if (prenotazioni.size() >= 1) {
            return false;
        } else {
            return true;
        }

    }

    public List<Prenotazione> filterPostazione(UUID id, LocalDate data) {
        return prenotazioniRepository.filterByPostazioneId(id, data);
    }

    public List<Prenotazione> filterUtenteData(UUID utenteId, LocalDate data) {
        return prenotazioniRepository.filterByUtenteData(utenteId, data);
    }


}
