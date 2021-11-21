# Java-Team-Project

업데이트 한 부분 적어놓기

com.ysu.dbconnection
  * DB 연결에 대해 존재 (ysu, 1234)로 현재 작성됨

Project01에  [1 단계] 학생 검색 프로그램 구현
  * DBCProgram.java 연결버튼 클릭 -> DBCProgramAction.java 객체 생성
  * DBCProgramAction.java DB연결 체크. 연결 성공시 SearchProgram.java의 객체를 Visible(true)로 설정(창을 보이게함). 해제시 Visible(false)로 설정.
  * Main은 SearchProgram.java에 존재
  * findButton 클릭시 SearchBtnAction.java 객체 생성
  * SearchBtnAction.java sql문을 처리함.

Project02에  [2 단계] DB 연결 후 데이터 추가, 수정, 삭제, 검색 기능 구현

CRUD
 Select 담당(양문경) : Project01에서 한 내용과 동일
                    후에 Select된 상태에서 Update, Delete 진행 가능하도록 수정해야함(Insert는 상관 없다고 생각)
                    변수명 phonenoTextText -> phonenoText으로 수정 확인 부탁
 
 Insert 담당(김  민) : 변수명은 양문경님과 동일하게함 Manager안에 insert.addActionLitener(new InsertActionListener(,,)); 
                     추가완료
