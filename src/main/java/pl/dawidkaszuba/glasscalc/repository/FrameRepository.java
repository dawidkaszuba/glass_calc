package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Frame;

public interface FrameRepository extends JpaRepository<Frame, Long> {
}
