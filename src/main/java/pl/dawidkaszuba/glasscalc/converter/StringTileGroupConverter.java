package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.TileGroup;
import pl.dawidkaszuba.glasscalc.repository.TileGroupRepository;

public class StringTileGroupConverter implements Converter<String, TileGroup> {

    @Autowired
    private TileGroupRepository tileGroupRepository;

    @Override
    public TileGroup convert(String id) {
        return this.tileGroupRepository.findOne(Long.parseLong(id));
    }
}
