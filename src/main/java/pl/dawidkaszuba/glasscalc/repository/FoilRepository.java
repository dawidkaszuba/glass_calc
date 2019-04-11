package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Foil;

public interface FoilRepository extends JpaRepository<Foil, Long> {
}
