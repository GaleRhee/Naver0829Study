# Naver0829Study
Naver DevOps course class 3 study


git-bash

1. git init - git과 연동할 폴더 초기화
2. git remote add origin https://github.com/GaleRhee/Naver0829Study.git
 - git 원격 저장소에 새로 연결
   오류가 나서 새로운 깃 저장소로 연결이 안될 경우
   git remote set-url origin https://github.com/GaleRhee/Naver0829Study.git
5. git branch - branch 조회
6. git add. 또는 git add 파일명 : 해당 파일들을 로컬 저장소에 추가
7. git commit -m 메시지 - 해당 메시지와 함께 위의 파일들을 로컬저장소에 커밋
8. git push origin 브랜치명 - 원격저장소의 브랜치에 소스 보내기
   - 반대로 원격저장소의 수정된 내용을 가져올 경우
   - git pull origin 브랜치명

처음에 한번만 이메일과유저명 확인
git config --global user.name "사용자명" 
git config --global user.email "사용자이메일"
