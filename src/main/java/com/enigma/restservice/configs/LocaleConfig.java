/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enigma.restservice.configs;

import java.util.Locale;
import static java.util.Locale.US;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author CODE.ID
 */
public class LocaleConfig implements WebMvcConfigurer{
    @Bean
    public SessionLocaleResolver localeResolver(){
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.US);
        return resolver;
    }
    public void addInterceptor(InterceptorRegistry registry){
       LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
       interceptor.setParamName("Language");
       registry.addInterceptor(interceptor);
        
    
    }
    
}
