package de.flameboard.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sven on 07.11.2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class FlameBoardApi {

  public static void main(String[] args) {
    SpringApplication.run(FlameBoardApi.class, args);
  }
}


