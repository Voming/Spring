package kh.mclass.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		// 이 자체가 Bean을 만들고 spring 부트에게 관리해달라고 하는 것
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// csrf(cross site request forgery attack) : 웹 보안 공격중 하나를 방지해주는 기능
//		http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable()); //보안 기능을 안쓰겠다 //람다식 
		http.csrf(aaa -> aaa.disable());
//		http.csrf(AbstractHttpConfigurer :: disable);

		// 클릭재킹 공격 방지 기능
		http.headers(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer
				.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin()));

		// login + logout 을 HttpSecurity 객체에게 맡김
		http.formLogin(fr -> 
			fr
			.loginPage("/my/login")
			.defaultSuccessUrl("home")
			.failureUrl("/my/login")	
			.usernameParameter("email")
		); // .loginPage("/login")
		// 성공 실패 판단하는 곳? ->

		// ExcrptionHandling ->
		// 스프링 시큐리티에서 필터를 다는 방법
		// http.addFilter(fileter);

		// 인터셉터
		// http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
