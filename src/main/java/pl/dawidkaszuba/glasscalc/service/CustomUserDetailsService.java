package pl.dawidkaszuba.glasscalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.glasscalc.entity.User;
import pl.dawidkaszuba.glasscalc.model.CustomUserDetail;
import pl.dawidkaszuba.glasscalc.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(name);

        optionalUser
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return  optionalUser
                .map(CustomUserDetail::new).get();

    }
}
