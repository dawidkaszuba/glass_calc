package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Glass3Tiles;

import java.util.List;

public interface Glass3TilesRepository extends JpaRepository<Glass3Tiles, Long> {
    List<Glass3Tiles> findAllByUserId(Long id);
}
