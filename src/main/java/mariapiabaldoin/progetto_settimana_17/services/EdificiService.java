package mariapiabaldoin.progetto_settimana_17.services;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.progetto_settimana_17.entities.Edificio;
import mariapiabaldoin.progetto_settimana_17.repositories.EdificiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EdificiService {
    @Autowired
    private EdificiRepository edificiRepository;

    public void saveEdificio(Edificio newEdificio) {


        edificiRepository.save(newEdificio);

        log.info("L'edificio " + newEdificio + " è stato salvato correttamente!");
    }


}
