package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.TileGroup;

public interface TileGroupRepository extends JpaRepository<TileGroup, Long> {
}
