package pl.dawidkaszuba.glasscalc.service;

import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;

import java.util.List;

public interface Glass2TilesService {

    void save(Glass2Tiles glass2Tiles);
    List<Glass2Tiles> findAll();
    Glass2Tiles findById(Long id);
    double getPrice(Glass2Tiles glass2Tiles);
    void delete(Long id);
    List<Glass2Tiles> findAllByUserId();



}
