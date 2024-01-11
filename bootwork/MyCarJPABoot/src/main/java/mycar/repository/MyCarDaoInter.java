package mycar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.transaction.Transactional;
import mycar.data.MyCarDto;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long>{
	
	//직접 쿼리문을 이용해서 수정하는 메서드를 추가해보자
	//자동차명, 가격, 색상만 수정하는 메서드를 만들어보자
	
	//@Query : repository 에 원하는 쿼리를 작성하게 해주는 어노테이션
	//value 속성 : 쿼리 작성부
	//nativeQuery : JPA 에서 지정한 규칙을 모두 무시할 수 있는 속성
	@Query(value="""
			update mycar set carname=:carname,carprice=:carprice,carcolor=:carcolor
			where num=:num
			""",nativeQuery=true)
	@Modifying
	@Transactional //@Transactional 은 update, delete 를 할 때 표기를 해줘야 정상 실행이 됩니다.
	public void updateMycarNoPhoto(@Param("num") Long num,@Param("carname") String carname,
			@Param("carprice") int carprice,@Param("carcolor") String carcolor);
	
	
	//기존 count() 로 해도 되지만 테스트를 위해 만들어 봅시다
	@Query(value="select count(*) from mycar", nativeQuery=true)
	public Long getTotalMyCount();
	
	@Query(value="""
			update mycar set carname=:#{#dto.carname},carprice=:#{#dto.carprice},
			carcolor=:#{#dto.carcolor},carguip=:#{#dto.carguip}
			where num=:#{#dto.num}
			""",nativeQuery=true)
	@Modifying //@Modifying 은 insert, update, delete 뿐만 아니라 DDL 구문을 사용할 때도 표기를 해줘야 됩니다
	@Transactional //@Transactional 은 update, delete 를 할 때 표기를 해줘야 정상 실행이 됩니다.
	public void updateMycarDTONoPhoto(@Param("dto") MyCarDto dto);
}
