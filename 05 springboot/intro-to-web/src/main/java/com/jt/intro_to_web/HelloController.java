package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

  @RequestMapping("/hello")
  public void sayHello(PrintWriter writer) {
    System.out.println("Hello To Web");
    writer.println("Hello To Web In Browser");
  }  
}
