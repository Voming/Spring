package kh.mclass.ttt.sub.model.dto;


//@Component("testDto") //이름을 정해주는게 조금 더 명확함
public class TestDto {
	private String a1;
	private String a2;
	private TestFileDto testflieDto;
	
	private void init() {
		System.out.println("init");
	}

	@Override
	public String toString() {
		return "TestDto [a1=" + a1 + ", a2=" + a2 + ", testflieDto=" + testflieDto + "]";
	}

	public TestDto() {
		super();
	}

	public TestDto(String a2) {
		super();
		this.a2 = a2;
	}

	public TestDto(String a1, String a2, TestFileDto testflieDto) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.testflieDto = testflieDto;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public TestFileDto getTestflieDto() {
		return testflieDto;
	}

	public void setTestflieDto(TestFileDto testflieDto) {
		this.testflieDto = testflieDto;
	}

}
