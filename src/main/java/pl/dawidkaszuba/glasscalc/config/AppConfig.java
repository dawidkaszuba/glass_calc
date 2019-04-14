package pl.dawidkaszuba.glasscalc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.dawidkaszuba.glasscalc.converter.*;

import javax.persistence.EntityManagerFactory;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("pl.dawidkaszuba")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.dawidkaszuba.glasscalc.repository")
public class AppConfig extends WebMvcConfigurerAdapter {


    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("glasscalc");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringCoatingConverter());
        registry.addConverter(stringTileGroupConverter());
        registry.addConverter(stringFoilConverter());
        registry.addConverter(stringTileConverter());
        registry.addConverter(stringFrameConverter());
        registry.addConverter(stringGlass2TileConverter());
        registry.addConverter(stringGasConverter());

    }

    @Bean
    public StringTileGroupConverter stringTileGroupConverter(){
        return new StringTileGroupConverter();
    }

    @Bean
    StringCoatingConverter stringCoatingConverter(){
        return  new StringCoatingConverter();
    }

    @Bean
    StringFoilConverter stringFoilConverter(){
        return new StringFoilConverter();
    }

    @Bean
    StringTileConverter stringTileConverter(){
        return new StringTileConverter();
    }

    @Bean
    StringFrameConverter stringFrameConverter(){
        return new StringFrameConverter();
    }

    @Bean
    StringGlass2TileConverter stringGlass2TileConverter(){
        return new StringGlass2TileConverter();
    }

    @Bean
    StringGasConverter stringGasConverter() {
        return new StringGasConverter();
    }
}