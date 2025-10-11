package com.jt.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DieselEngine implements Engine{
  @Override
  public void startEngine() {
    System.out.println("Diesel Engine Started");
  }

  @Override
  public void stopEngine() {
    System.out.println("Diesel Engine Stopped");
  }
}
