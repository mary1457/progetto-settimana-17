package mariapiabaldoin.progetto_settimana_17.runners;


import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.progetto_settimana_17.entities.Postazione;
import mariapiabaldoin.progetto_settimana_17.entities.Prenotazione;
import mariapiabaldoin.progetto_settimana_17.entities.Utente;
import mariapiabaldoin.progetto_settimana_17.exceptions.NotFoundException;
import mariapiabaldoin.progetto_settimana_17.exceptions.ValidationException;
import mariapiabaldoin.progetto_settimana_17.services.EdificiService;
import mariapiabaldoin.progetto_settimana_17.services.PostazioniService;
import mariapiabaldoin.progetto_settimana_17.services.PrenotazioniService;
import mariapiabaldoin.progetto_settimana_17.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {

    @Autowired
    private UtentiService utentiService;

    @Autowired
    private PrenotazioniService prenotazioniService;

    @Autowired
    private PostazioniService postazioniService;

    @Autowired
    private EdificiService edificiService;

    @Override
    public void run(String... args) throws Exception {
/*        Utente mario = new Utente("mario_bros", "Mario", "mario@nintendo.com");
        Utente luigi = new Utente("luigi_bros", "Luigi", "luigi@nintendo.com");
        Utente peach = new Utente("princess_peach", "Peach", "peach@nintendo.com");

        Edificio edificio1 = new Edificio("Palazzo Rosso", "Via Roma 10", "Mushroom Kingdom");
        Edificio edificio2 = new Edificio("Castello Blu", "Via Luigi 22", "Luigi's Mansion");

        Postazione postazione1 = new Postazione("Sala Riunioni 1", Tipo.SALA_RIUNIONI, 3, edificio1);
        Postazione postazione2 = new Postazione("Ufficio Individuale", Tipo.PRIVATO, 1, edificio1);
        Postazione postazione3 = new Postazione("Area Co-working", Tipo.OPEN_SPACE, 10, edificio2);

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.of(2024, 11, 1), mario, postazione1);
        Prenotazione prenotazione2 = new Prenotazione(LocalDate.of(2024, 11, 2), luigi, postazione2);*/
        try {
           /* utentiService.saveUtente(mario);
            utentiService.saveUtente(luigi);
            utentiService.saveUtente(peach);
            edificiService.saveEdificio(edificio1);
            edificiService.saveEdificio(edificio2);
            postazioniService.savePostazione(postazione1);
            postazioniService.savePostazione(postazione2);
            postazioniService.savePostazione(postazione3);
            prenotazioniService.savePrenotazione(prenotazione1);
            prenotazioniService.savePrenotazione(prenotazione2);
*/
            List<Utente> utenti = utentiService.findAll();
            List<Postazione> postazioni = postazioniService.filterTipoCitta("PRIVATO", "Mushroom Kingdom");
            System.out.println(postazioni.stream().toList());
            if (prenotazioniService.controlloPostazione(LocalDate.of(2024, 11, 1), postazioni.getFirst())) {
                if (prenotazioniService.controlloUtente(LocalDate.of(2024, 11, 1), utenti.getFirst())) {
                    Prenotazione nuovaPrenotazione = new Prenotazione(LocalDate.now(), utenti.getFirst(), postazioni.getFirst());
                    prenotazioniService.savePrenotazione(nuovaPrenotazione);
                } else {

                    throw new ValidationException("L'utente ha già una prenotazione per questa data");
                }

            } else {
                throw new NotFoundException(postazioni.getFirst().getPostazioneId());
            }


        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

    }
}
