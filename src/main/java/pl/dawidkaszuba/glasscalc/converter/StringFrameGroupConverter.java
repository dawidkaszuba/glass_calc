package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.FrameGroup;
import pl.dawidkaszuba.glasscalc.repository.FrameGroupRepository;

public class StringFrameGroupConverter implements Converter<String, FrameGroup> {

    @Autowired
    private FrameGroupRepository frameGroupRepository;

    @Override
    public FrameGroup convert(String id) {
        return frameGroupRepository.findOne(Long.parseLong(id));
    }
}
