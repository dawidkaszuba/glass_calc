package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;
import pl.dawidkaszuba.glasscalc.repository.Glass2TilesRepository;

public class StringGlass2TileConverter implements Converter<String,Glass2Tiles> {

    @Autowired
    private Glass2TilesRepository glass2TilesRepository;


    @Override
    public Glass2Tiles convert(String id) {
        return this.glass2TilesRepository.findOne(Long.parseLong(id));
    }
}
