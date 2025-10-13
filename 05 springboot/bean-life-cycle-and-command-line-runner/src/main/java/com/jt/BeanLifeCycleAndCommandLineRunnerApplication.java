package com.jt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifeCycleAndCommandLineRunnerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BeanLifeCycleAndCommandLineRunnerApplication.class, args).getBean(Greet.class).greet();
	}

	@Override
	public void run(String... args) throws Exception {
		// the run() of commandlinerunner is executed after the SpringContainer is fully initialized(prepared)
		// we can populate the data inside database ✅
		// we can perform some startup checks or logging
		// test small piece of code ✅
		// we can load some cache
		System.out.println("run method of CommandLineRunner is called");
	}

}

/**
 * beans are managed by SpringContainer (IOC Container) -> bean lifecycle
 * 
 * Bean Instantion
 * Dependency Injection 
 * Bean Initialized 
 * Bean Used
 * Bean Destroyed
 */