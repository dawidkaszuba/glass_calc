package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Coating;

public interface CoatingRepository extends JpaRepository<Coating, Long> {
}
