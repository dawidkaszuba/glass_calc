package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.Foil;
import pl.dawidkaszuba.glasscalc.repository.FoilRepository;

public class StringFoilConverter implements Converter<String, Foil> {

    @Autowired
    private FoilRepository foilRepository;

    @Override
    public Foil convert(String id) {
        return this.foilRepository.findOne(Long.parseLong(id));
    }
}
