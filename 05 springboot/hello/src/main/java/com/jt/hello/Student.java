package com.jt.hello;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // by default every bean created by the Spring Container uses singleton bean
public class Student {
  public void sayHello() {
    System.out.println("Student say's hello");
  }
}
