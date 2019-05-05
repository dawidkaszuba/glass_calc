package pl.dawidkaszuba.glasscalc.app.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableJpaRepositories("pl.dawidkaszuba")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;


    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(getPasswordEncoder());

        }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return encode(charSequence).equals(s);
            }
        };
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests()
                .antMatchers("/","/configurator2Tiles/**","/configurator3Tiles/**","/tile/**",
                        "/resources/**","/pdfreport2/**","/pdfreport3/**")
                .hasAnyRole("ADMIN","USER")
                .anyRequest()
                .hasAnyRole("ADMIN")
                .antMatchers("/login").permitAll()
                .and()
                .formLogin()
                .successHandler(customLoginSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
    }
}