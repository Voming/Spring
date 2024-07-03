package kh.mclass.demo8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class Demo8ApplicationTests { // 누군가가 호출해서 돌릴 것이 아니기 때문에 접근 제한자를 붙이지 않음
	//Mock Mvc - controller 가능, service, repository 불가
	private MockMvc mockMvc; // 다른데서 달라고 해서 받는게 아님

	@Autowired
	private WebApplicationContext wac; //돌고있는 Demo8ApplicationTests

	private EmpService empService;
	
//	private static EmpService empService; static 메소드 안에서 쓰려면 필드도 static
//	@BeforeAll
//	static void setup2() {
//		// 주로 service 객체 생성
//		empService = new EmpService();
//		System.out.println("============setup2");
//	}

	// 테스트 롤리기전에...
	@BeforeEach // JUnit 4의 Before , 랜덤한 순서로
	void setup() {
		// 이 시점에서 mockMvc 생성
		// this.mockMvc = MockMvcBuilders.standaloneSetup(new Demo8Controller()).build(); //Demo8Controller 가지고 기본 생성
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //광범위하게 사용 가능
		
		// 주로 service 객체 생성
		this.empService = new EmpService();
		System.out.println("============@BeforeEach--@ Test 돌릴 준비 완료");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("============@AfterEach");
	}
	
	@Test
	void loginTest() { //Object...형태는 가변인자 1개 이상의 매개변수를 쓸 수 있다.
		try {
			mockMvc.perform(get("/login")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test // test의 개수 만큼 테스트 실행함
	void contextLoads1() {
		System.out.println("============contextLoads1");
		String a = "aaa";
		assertNotNull(a);
	}

	@Test
	void contextLoads2() {
		System.out.println("============contextLoads2");
		String a = "aaa";
		String b = "aaa";
		// 이 사이에 복잡한 코드가...
		assertEquals(a, b);

		// assert를 붙여서 테스트
		// assertNotNull(a);
		// 둘이 같이쓰면 테스트가 둘다 실행되지 않음 -> 따라서 분리
	}

}
