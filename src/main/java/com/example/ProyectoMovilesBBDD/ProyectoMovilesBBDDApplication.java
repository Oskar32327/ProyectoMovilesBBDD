package com.example.ProyectoMovilesBBDD;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.ProyectoMovilesBBDD.control.ObjectMother;
import com.example.ProyectoMovilesBBDD.modelo.Movil;
import com.example.ProyectoMovilesBBDD.modelo.MovilRepository;

@SpringBootApplication
public class ProyectoMovilesBBDDApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoMovilesBBDDApplication.class, args);
		
	}
	
    @Bean
    public CorsFilter corsFilter() {
        System.err.println("Arrancando el Bean corsFilter");
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow_Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorizacion", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        //springframework import
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
 

}
