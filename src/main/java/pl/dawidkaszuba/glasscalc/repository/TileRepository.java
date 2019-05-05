package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Tile;

import java.util.List;

public interface TileRepository extends JpaRepository<Tile, Long> {
    List<Tile> findAllByGroupId(Long id);

    List<Tile> findAllByNameContainingIgnoreCase(String name);
}
