package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class NaverConfig {
	
	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	@Value("kr-standard")
	private String regionName;
	
	
	@Value("wOzG9AkT47yjgFJXFPCu") 
	private String accessKey;
	  
	@Value("i1PzCX1xaICvoRTbRfwMbTUb9Jsp2oXtioFRz80w") 
	private String secretKey;
	
	
	/*
	 * @Value("8yt6c0uo9is9HLAN1BZH") private String accessKey;
	 * 
	 * @Value("tmFGzatUiqw0C91hSR9Cx9jwPX5DWSzwLFRn3XC0") private String secretKey;
	 */

}
