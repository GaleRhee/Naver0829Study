package day1109.test6.anno;

import org.springframework.stereotype.Component;

@Component //xml 에 자동으로 bean 등록 - id 가 클래스명이 아이디가 된다 
//(첫글자가 자동으로 소문자 : annoCanadaTire)
public class AnnoCanadaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "어노테이션 캐나다 타이어";
	}

}
