package com.jt.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
  // @Autowired
  // private Engine engine;


  // private Engine engine;
  // @Autowired
  // public void jt(Engine engine) {
  //   // System.out.println("inside constructor" + engine);
  //   this.engine = engine;
  // }


  private Engine engine;
  
  @Autowired
  public Car(@Qualifier("petrolEngine") Engine engine) {
    this.engine = engine;
    System.out.println("Within parameterized constructor");
  }

  public Car() {
    System.out.println("Within non parameterized constructor");
  }

  public void runCar() {
    // Engine engine = new Engine();
    // engine.startEngine();

    System.out.println("//////////////" + engine);
    engine.startEngine();
    System.out.println("Car is running");
  }

  public void stopCar() {
    // Engine engine = new Engine();

    engine.stopEngine();
    System.out.println("Car is being stoppped");
  }
}
