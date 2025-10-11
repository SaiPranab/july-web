package com.jt.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.Bike;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class DiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DiApplication.class, args);
		Car car = context.getBean(Car.class);
		car.runCar();
		car.stopCar();

		Bike bike = context.getBean(Bike.class);
		bike.runBike(); 
	}

}
