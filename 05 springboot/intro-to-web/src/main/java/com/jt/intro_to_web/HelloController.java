package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

  @RequestMapping("/hello")
  public void sayHello(PrintWriter writer) {
    System.out.println("Hello To Web");
    writer.println("Hello To Web In Browser");
  }

  @RequestMapping({ "/", "/home" })
  public String home() {
    System.out.println("Home method1");
    return "index";
  }

  @RequestMapping("/contact")
  public String contact(Model model) {
    model.addAttribute("name1", "Java Technocrat");
    model.addAttribute("phone", "9437056780");
    return "contact";
  }
}
