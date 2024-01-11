package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 은행 서비스에서 사용자 (TABLE_USER) 가 1개 이상인 계좌 (TABLE_ACCOUNT) 를
 * 가질 수 있다고 가정할 경우 TABLE_USER 입장에서 보면 OneToMany 이고,
 * TABLE_ACCOUNT 입장에서 보면 ManyToOne 이다.
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="mycar_comment")
public class MyCarCommentDto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idx;
	
	@ManyToOne //서브 테이블에는 ManyToOne : 하나의 등록글에 여러 개의 댓글을 달 수 있다
	@JoinColumn(name="num")
	private MyCarDto mycar; //MyCarDto 를 직접 선언을 해둬야 한다, join table 선언
	
	//@Column(length=30) 기본 컬럼명은 comment, length 는 255 가 된다 (생략 시)
	private String comment;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="Asia/Seoul") //댓글은 출력을 ajax 로 처리할 것임
	@Column(updatable=false) //수정 시 수정 컬럼에서 제외
	@CreationTimestamp //엔터티가 생성되는 시점의 시간이 자동 등록
	private Timestamp writeday;
}
