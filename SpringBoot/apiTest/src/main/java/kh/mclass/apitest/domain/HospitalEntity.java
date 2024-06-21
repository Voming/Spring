package kh.mclass.apitest.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class HospitalEntity {
	private String yadmNm;
	private String telno;
	private String postNo;
}
