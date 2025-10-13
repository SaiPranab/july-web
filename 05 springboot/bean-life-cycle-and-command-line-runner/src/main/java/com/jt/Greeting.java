package com.jt;

import org.springframework.stereotype.Component;

@Component
public class Greeting {

  public Greeting() {
    System.out.println("Greeting is Instantiated");
  }
}
