package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.glasscalc.entity.Gas;
import pl.dawidkaszuba.glasscalc.repository.GasRepository;

public class StringGasConverter implements Converter<String, Gas> {

    @Autowired
    private GasRepository gasRepository;

    @Override
    public Gas convert(String id) {
        return this.gasRepository.findOne(Long.parseLong(id));
    }
}
