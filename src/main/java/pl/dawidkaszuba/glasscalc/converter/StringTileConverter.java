package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.Tile;
import pl.dawidkaszuba.glasscalc.repository.TileRepository;


public class StringTileConverter implements Converter<String, Tile> {

    @Autowired
    private TileRepository tileRepository;

    @Override
    public Tile convert(String id) {
        return this.tileRepository.findOne(Long.parseLong(id));
    }
}
