# Java-Team-Project

업데이트 한 부분 적어놓기

com.ysu.dbconnection
  * DB 연결에 대해 존재 (ysu, 1234)로 현재 작성됨

Project01에  [1 단계] 학생 검색 프로그램 구현
  * DBCProgram.java 연결버튼 클릭 -> DB 연결이 성공하면 SearchProgram.java 객체 생성
  * Main은 SearchProgram.java에 존재
  * findButton으로 넘겨줘 그에 대한 코드 -> SearchBtnAction.java에 존재
  * SearchBtnAction.java 에서 model의 데이터 초기화 및 입력

-- 현재 구현중
 * DB 연결 조건 검사
 * DB 연결 조건에 따른 버튼의 텍스트 변경
 * 총 2개의 프레임만 존재하게함.

Project02에  [2 단계] DB 연결 후 데이터 추가, 수정, 삭제, 검색 기능 구현

CRUD
 Select 담당(양문경) : Project01에서 한 내용과 동일
                    후에 Select된 상태에서 Update, Delete 진행 가능하도록 수정해야함(Insert는 상관 없다고 생각)
                    변수명 phonenoTextText -> phonenoText으로 수정 확인 부탁
 
 Insert 담당(김민) : 변수명은 양문경님과 동일하게함 Manager안에 insert.addActionLitener(new InsertActionListener(,,)); 
