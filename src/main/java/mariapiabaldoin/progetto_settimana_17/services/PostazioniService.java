package mariapiabaldoin.progetto_settimana_17.services;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.progetto_settimana_17.entities.Postazione;
import mariapiabaldoin.progetto_settimana_17.entities.Tipo;
import mariapiabaldoin.progetto_settimana_17.exceptions.NotFoundException;
import mariapiabaldoin.progetto_settimana_17.exceptions.ValidationException;
import mariapiabaldoin.progetto_settimana_17.repositories.PostazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class PostazioniService {
    @Autowired
    private PostazioniRepository postazioniRepository;

    public void savePostazione(Postazione newPostazione) {


        if (newPostazione.getNumeroOccupanti() < 0)
            throw new ValidationException("Deve esserci almeno un posto prenotabile");
        postazioniRepository.save(newPostazione);

        log.info("La postazione " + newPostazione + " è stata salvata correttamente!");
    }

    public List<Postazione> filterTipoCitta(String tipo, String citta) {
        List<Postazione> postazione = postazioniRepository.filterByTipoCitta(Tipo.valueOf(tipo), citta);
        if (postazione.size() == 0)
            throw new ValidationException("Non ci sono postazioni");
        return postazioniRepository.filterByTipoCitta(Tipo.valueOf(tipo), citta);
    }

    public Postazione findById(UUID postazioneId) {

        return postazioniRepository.findById(postazioneId).orElseThrow(() -> new NotFoundException(postazioneId));
    }


}
