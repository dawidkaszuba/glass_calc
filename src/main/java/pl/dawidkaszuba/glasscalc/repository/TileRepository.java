package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Tile;

public interface TileRepository extends JpaRepository<Tile, Long> {
}
