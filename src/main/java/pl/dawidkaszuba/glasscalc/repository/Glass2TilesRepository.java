package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;

import java.util.List;

public interface Glass2TilesRepository extends JpaRepository<Glass2Tiles,Long> {
    List<Glass2Tiles> findAllByUserId(Long id);
}
