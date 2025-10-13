package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Greet {
  private Greeting greeting;

  public Greet() {
    System.out.println("Greet is instantiated");
  }

  @Autowired
  public void setGreeting(Greeting greeting) {
    System.out.println("Greeting Object Injected");
    this.greeting = greeting;
  }

  @PostConstruct
  public void init() {
    System.out.println("This method is called after Dependency Injection");
  }

  public void greet() {
    System.out.println("Hello Everyoneeeeee!");
  }

  @PreDestroy
  public void destroyGreet() {
    System.out.println("Greet bean destroyed");    
  }
}
