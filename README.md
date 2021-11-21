# Java-Team-Project

업데이트 한 부분 적어놓기

com.ysu.dbconnection
  * DB 연결에 대해 존재 (ysu, 1234)로 현재 작성됨

Project01에  [1 단계] 학생 검색 프로그램 구현
  * DBCProgram.java 연결버튼 클릭 -> DBCProgramAction.java 객체 생성
  * DBCProgramAction.java DB연결 체크. SearchProgram.java 객체의 보임 여부 컨트롤(Visible(true or false))
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
                     
 Update 담당(나예선) : 변수명은 동일하게 함 Project02에서 UpdateActionListener() 클래스 형성함
                      문제 1 : 수정할 레코드 기준이 필요해서 name을 pk와 같이 삼아서 name은 변경불가함
                      문제 2 : 수정을 위해서는 모든 정보를 일일이 다 입력해야함
                      이를 해결하려면 레코드를 클릭하여 모든 정보가 자동으로 textfield에 출력되게끔 해야함
                      (새로운 창을 만드는 것도 방법)
