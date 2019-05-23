package com.onesquare.vmonesquare.config;

import com.onesquare.vmonesquare.domain.usercase.VmonesquareAppUsercase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeans {

    @Bean
    public VmonesquareAppUsercase vmonesquareAppUsercase(){
        return new VmonesquareAppUsercase();
    }

}
