package medya.soft.com.Configuration;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import com.mitchellbosecke.pebble.spring4.extension.SpringExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public Loader templateLoader() {
        return new ClasspathLoader();
    } //ClassPathLoader çalıştırılıyor Pebble için gerekli


    @Bean
    public SpringExtension springExtension() {
        return new SpringExtension();
    } //Spring Extension çalıştırılıyor Pebble için gerekli

    @Bean
    public PebbleEngine pebbleEngine() { //Pebble engine
        return new PebbleEngine.Builder().loader(this.templateLoader())
                .extension(this.springExtension()).build();
    }

    @Bean
    public LocaleResolver localeResolver() { //Dil desteği
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("tr"));
        return slr;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    } //dil değiştirme

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() { // Dil Desteği
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    public ViewResolver viewResolver() { //Pebble engine çalıştırılması
        PebbleViewResolver viewResolver = new PebbleViewResolver();
        viewResolver.setPrefix("templates/");
        viewResolver.setSuffix(".html");
        viewResolver.setPebbleEngine(pebbleEngine());
        return viewResolver;
    }
}
