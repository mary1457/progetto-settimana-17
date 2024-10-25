package mariapiabaldoin.progetto_settimana_17.repositories;

import mariapiabaldoin.progetto_settimana_17.entities.Postazione;
import mariapiabaldoin.progetto_settimana_17.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, UUID> {

    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta =:citta  ")
    List<Postazione> filterByTipoCitta(Tipo tipo, String citta);
}
