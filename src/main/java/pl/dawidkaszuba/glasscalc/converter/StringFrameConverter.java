package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.Frame;
import pl.dawidkaszuba.glasscalc.repository.FrameRepository;

public class StringFrameConverter implements Converter<String, Frame> {

    @Autowired
    private FrameRepository frameRepository;

    @Override
    public Frame convert(String id) {
        return this.frameRepository.findOne(Long.parseLong(id));
    }
}
