package com.jt.di;

import org.springframework.stereotype.Component;

// @Component
// public class Engine {
//   public void startEngine() {
//     System.out.println("Engine Started");
//   }

//   public void stopEngine() {
//     System.out.println("Engine Stopped");
//   }
// }

public interface Engine {
  void startEngine();

  void stopEngine();
}