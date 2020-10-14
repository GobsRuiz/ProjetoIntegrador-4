package com.fatec.projetoIntegrador4;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoIntegrador4Application {

	// @Bean                 
    // public LocaleResolver localeResolver() {

    //     SessionLocaleResolver localResolver=new SessionLocaleResolver();
    //     localResolver.setDefaultLocale(Locale.US);
    //     return localResolver;
    // }

    // @Bean
    // public MessageSource messageSource() {
    //     ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    //     messageSource.setBasename("classpath:messages");
    //     messageSource.setCacheSeconds(10); //reload messages every 10 seconds
    //     return messageSource;
    // }

	public static void main(String[] args) {
		SpringApplication.run(ProjetoIntegrador4Application.class, args);
	}

}
