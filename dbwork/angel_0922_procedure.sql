-- 2023-09-22 프로시져 Procedure
/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다

자바의 함수 유사
 
형식 
create : 새로 생성, 기존 프로시져가 있을 경우 오류 발생
create or replace : 새로 생성, 근데 기존 프로시져 있으면 덮어 쓴다


create [or replace] procedure 프로시져명
   [파라미터 모드 데이타타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명
            	exec 프로시져명(값..)

*/

------------------------------------------------------------------
-- 예제 1
-- 초간단 프로시져 생성 해보기
create or replace PROCEDURE mytest
is
begin
    DBMS_Output.put_line('첫 프로시져를 만들었어요!');
end;
/

-- 좌측에 프로시져 열어서 거기서 코드 쓰지 말아라

-- mytest 프로시져 호출
exec mytest;


-- 예제 2 : 숫자를 인자로 보내면 구구단 출력
create or replace PROCEDURE gugu (dan number)
is
begin
    if dan<2 or dan>9 then
        DBMS_Output.put_line('잘못된 숫자입니다. 2~9 사이값 요구!');
    else
        DBMS_Output.put_line('**'||dan||'단 **');
        for a in 1..9 loop
            DBMS_Output.put_line(dan||'x'||a||'='||dan*a);
            end loop;
    end if;
end;
/

-- 실핼
exec gugu(11);
exec gugu(5);


-- shop 에 데이터 추가
insert into shop values (seq_shop.nextval,'레이스블라우스',23000,'white');

-- shop 의 sang_color 의 타입 길이 변경
alter table shop modify sang_color varchar2(30);

insert into shop values (seq_shop.nextval,'레이스조끼',19000,'red');
insert into shop values (seq_shop.nextval,'체크조끼',39000,'rainbow');
insert into shop values (seq_shop.nextval,'칠부청바지',56000,'blue');
commit;


-- 예제 3 : 상품명을 인자로 보내면 그 단어가 포함된 보든 상품들 출력하기
create or replace PROCEDURE sangpum(sang varchar2)
is
    cursor s1
    is 
    select * from shop where sang_name like '%'||sang||'%';
    
    -- 검색된 상품 개수를 구할 변수
    v_cnt number(2);
    
begin
    
    select  count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
    if v_cnt=0 then 
        DBMS_Output.put_line(sang||'상품은 목록에 없습니다');
    else
        DBMS_Output.put_line(sang||'상품 조회 하기');
        DBMS_Output.put_line('  ');
        DBMS_Output.put_line('상품번호  상품명   가격   색상');
        DBMS_Output.put_line('--------------------------------');
        for s in s1 loop
            DBMS_Output.put_line(s.sang_no||'   '||s.sang_name||'   '||
                s.sang_price||'  '||s.sang_color);
            exit when s1%notfound;
        end loop;
    end if;
end;
/

-- 실행
exec sangpum('조끼');
exec sangpum('청바지');
exec sangpum('한복');



-- 예제 4
/*
    exec addupdate('레이스조끼',45000,'black'); : '레이스조끼' 상품이 없으면 추가
                                         : '레이스조끼' 상품이 있으면 가격과 색상 수정
*/

accept iname prompt '%sangpum';
accept iprice prompt '%price';
accept icolor prompt '%color';

create or replace PROCEDURE addupdate(sang varchar2, price number, color varchar2)
is
    -- 검색된 상품 개수를 구할 변수
    v_cnt number(2);
begin
    
    select  count(*) into v_cnt from shop where sang_name=sang;
    if v_cnt=0 then 
        insert into shop values (seq_shop.nextval,sang,price,color);
        DBMS_Output.put_line(sang||' 상품이 추가 되었습니다');
    else
        update shop set sang_price=price, sang_color=color where sang_name=sang;
        DBMS_Output.put_line(sang||' 상품을 수정했습니다');
    end if;
end;
/

exec addupdate('레이스조끼',45000,'black');
exec addupdate('조끼',34000,'purple');
exec addupdate('양복정장',150000,'blue');


