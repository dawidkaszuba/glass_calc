package pl.dawidkaszuba.glasscalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Frame;

import java.util.List;

public interface FrameRepository extends JpaRepository<Frame, Long> {
    List<Frame> findAllByGroupId(Long id);
}
