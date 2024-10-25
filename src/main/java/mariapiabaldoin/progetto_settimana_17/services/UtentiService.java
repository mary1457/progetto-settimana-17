package mariapiabaldoin.progetto_settimana_17.services;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.progetto_settimana_17.entities.Utente;
import mariapiabaldoin.progetto_settimana_17.exceptions.ValidationException;
import mariapiabaldoin.progetto_settimana_17.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UtentiService {
    @Autowired
    private UtentiRepository utentiRepository;

    public void saveUtente(Utente newUtente) {


        if (utentiRepository.existsByEmail(newUtente.getEmail()) && utentiRepository.existsByUsername(newUtente.getUsername()))
            throw new ValidationException("Email e Username già in uso!");
        utentiRepository.save(newUtente);

        log.info("L'utente " + newUtente.getNome() + " è stato salvato correttamente!");
    }

    public List<Utente> findAll() {
        return utentiRepository.findAll();
    }

    public Utente filterByEmail(String email) {
        return utentiRepository.findByEmail(email);
    }

}
