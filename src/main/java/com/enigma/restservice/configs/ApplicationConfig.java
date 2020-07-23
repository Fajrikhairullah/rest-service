package com.enigma.restservice.configs;

import com.enigma.restservice.entities.Item;
import com.enigma.restservice.entities.Stock;
import com.enigma.restservice.entities.Transaction;
//import com.enigma.restservice.entities.Stock;
import com.enigma.restservice.entities.Unit;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import com.enigma.restservice.entities.Unit;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ApplicationConfig {

    @Bean
    public LocalValidatorFactoryBean validatorFactory(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
    
    @Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		// Don't do this in production, use a proper list of allowed origins
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

//    @Bean
//    public List<Item> itemBean() {
//        return new ArrayList<>();
//
//    }
//
//    @Bean
//    public List<Unit> unitBean() {
//        return new ArrayList<>();
//
//    }
//
//    @Bean
//    public List<Stock> stockBean(List<Item> items, List<Unit> units) {
//        return new ArrayList<>();
//    }
//
//    @Bean
//    public List<Transaction> transactionBean() {
//        return new ArrayList<>();
//    }
////        return units;
//
//    }
//    @Bean
//    public List<Stock> stockBean(List<Item> items, List<Unit> units) {
//        List<Stock> stocks = new ArrayList<>();
//        stocks.add(new Stock(items.get(0), 5, units.get(1)));
//
//        return stocks;
//    }
    }
