package com.jt.intro_to_web;

public class LoginCredentials {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    System.out.println("Mapping username");
    this.username = username;
  }

  public void setPassword(String password) {
    System.out.println("Mapping password");
    this.password = password;
  }
}
