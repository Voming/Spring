package kh.mclass.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		System.out.println("== main start");
		SpringApplication.run(Demo1Application.class, args);
		System.out.println("== main started");
	}

}
