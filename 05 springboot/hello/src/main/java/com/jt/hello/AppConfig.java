package com.jt.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  Teacher teacher() {
    return new Teacher();
  }

  /**
   * We should only use @Bean to provide the a Object of the predefined class
   * to Spring Container (so that it can use custom behavior of that object 
   *                          instead of predefined behavior)
   */
}
