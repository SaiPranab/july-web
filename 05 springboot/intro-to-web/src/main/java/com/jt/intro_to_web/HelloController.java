package com.jt.intro_to_web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

  @RequestMapping("/form")
  public String form() {
    return "form";
  }

  // @RequestMapping("/submit")
  // public String submit(@RequestParam(name = "user", defaultValue = "Java
  // Technocrat") String username,
  // @RequestParam String password, Model model) {
  // System.out.println("Submit method");
  // System.out.println("Username is :- " + username);
  // System.out.println("Password is :- " + password);

  // model.addAttribute("user", username);
  // model.addAttribute("pass", password);
  // return "details";
  // }

  // @RequestMapping(path = "/submit", method = RequestMethod.POST)
  @PostMapping("/submit")
  public String submit1(@ModelAttribute LoginCredentials credentials, Model model) {

    model.addAttribute("user", credentials.getUsername());
    model.addAttribute("pass", credentials.getPassword());
    return "details";
  }

  @GetMapping("/multi-submit")
  public String submit2(Model model) {
    LoginCredentials credential1 = new LoginCredentials("JT", "1234");
    LoginCredentials credential2 = new LoginCredentials("JavaTechnocrat", "5678");
    LoginCredentials credential3 = new LoginCredentials("Sai", "3456");

    model.addAttribute("credentials", List.of(credential1, credential2, credential3));
    return "credentials";
  }
}
