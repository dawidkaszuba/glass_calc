package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.Coating;
import pl.dawidkaszuba.glasscalc.repository.CoatingRepository;

public class StringCoatingConverter implements Converter<String, Coating> {

    @Autowired
    private CoatingRepository coatingRepository;

    @Override
    public Coating convert(String id) {
        return this.coatingRepository.findOne(Long.parseLong(id));
    }
}
