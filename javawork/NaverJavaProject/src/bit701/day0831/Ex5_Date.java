package bit701.day0831;

import java.util.Calendar;
import java.util.Date;

public class Ex5_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자바에서 시간이나 날짜 출력하는 방법
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDate();
		
		System.out.printf("현재 년도: %d-%2d-%2d\n",year,month,day);
		//월, 일 최대 두 자리인데 한 자리일 때 공백 있는 상태로 출력하고 싶으면
		System.out.printf("현재 년도: %d-%02d-%02d\n",year,month,day);
		//월, 일 두 자리 형식 채우기 위해 앞에 0을 붙인다
		
		int hh=date.getHours();
		int mm=date.getMinutes();
		int ss=date.getSeconds();
		
		System.out.printf("현재 시간: %02d:%02d:%02d\n",hh,mm,ss);
		
		System.out.println("Calendar 클래스를 이용해서 시간, 날짜 구하기");
		//Calendar cal=new Calendar();//오류, 생성자가public이 아니라 생성이 안됨
		Calendar cal=Calendar.getInstance();
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH)+1;//0~11의 값을 반환
		day=cal.get(Calendar.DATE);
		
		System.out.printf("현재 년도: %d-%02d-%02d\n",year,month,day);
		
		//요일 구하기
		int weekint=date.getDay();//0: 일, 1: 월, 2: 화,...6: 토
		System.out.println("요일 숫자:"+weekint);
		
		String week=weekint==0?"일":weekint==1?"월":weekint==2?"화":
					weekint==3?"수":weekint==4?"목":weekint==5?"금":"토";
		System.out.println("오늘은 "+week+"요일입니다");
		
		

	}

}
