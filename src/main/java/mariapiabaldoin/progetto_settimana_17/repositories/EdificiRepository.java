package mariapiabaldoin.progetto_settimana_17.repositories;

import mariapiabaldoin.progetto_settimana_17.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, UUID> {


}
