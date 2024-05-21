package kh.mclass.demo5;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo5Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo5Application.class, args);
		// 주입된 객체들 확인  //filter 로 확인(내가 보고싶은것만 볼수있게 설정)
//		Arrays.stream(context.getBeanDefinitionNames()).filter(s -> s.contains("board")).forEach(System.out::println);
		// controller service repository dto entity

	}

}
