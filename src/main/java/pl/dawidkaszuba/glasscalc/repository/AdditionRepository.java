package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Addition;

public interface AdditionRepository extends JpaRepository<Addition, Long> {
}
