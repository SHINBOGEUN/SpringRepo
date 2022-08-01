package com.korea.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data //Data를 통해서 Getter/Setter/toString 자동 형성
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TestDTO {
	
	//@Setter(onMethod_=@Autowired) //@Autowired는 스트링 내부에서 자신이 특정한 객체에 의존적이므로 자신에게 해당 타입의 빈을 주입해주라는 표시
								 //@Setter(onMethod_=@Autowired)는 setter 매서드 생성시 매서드에 추가할 어노테이션을 지정. 해당 어노테이션에서는 @Autowired가 추가됨 
	private String name;
	private String age;
	private String addr;
	
}
