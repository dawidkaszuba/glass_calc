package pl.dawidkaszuba.glasscalc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.glasscalc.entity.Role;
import pl.dawidkaszuba.glasscalc.repository.RoleRepository;

public class StringRoleConverter implements Converter<String, Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role convert(String id) {
        return this.roleRepository.findOne(Long.parseLong(id));
    }
}
