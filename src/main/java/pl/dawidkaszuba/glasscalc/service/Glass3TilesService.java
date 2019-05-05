package pl.dawidkaszuba.glasscalc.service;

import pl.dawidkaszuba.glasscalc.entity.Glass3Tiles;

import java.util.List;

public interface Glass3TilesService {
    void save(Glass3Tiles glass3Tiles);
    void delete(Long id);
    List<Glass3Tiles> findAll();
    Glass3Tiles findById(Long id);
    double getPrice(Glass3Tiles glass3Tiles);
    List<Glass3Tiles> findAllByUserId();
}
