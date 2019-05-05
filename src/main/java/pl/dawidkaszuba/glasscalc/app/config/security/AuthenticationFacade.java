package pl.dawidkaszuba.glasscalc.app.config.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuthentication();
}
