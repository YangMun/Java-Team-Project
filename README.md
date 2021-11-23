# Java-Team-Project

업데이트 한 부분 적어놓기

com.ysu.dbconnection
  * DB 연결에 대해 존재 (ysu, 1234)로 현재 작성됨

Project01에  [1 단계] 학생 검색 프로그램 구현
  * Main은 SearchProgram.java에 존재
  * findButton 클릭시 SearchBtnAction.java 객체 생성
  * SearchBtnAction.java sql문을 처리함.

Project02에  [2 단계] DB 연결 후 데이터 추가, 수정, 삭제, 검색 기능 구현
  기본적인 프레임 담당 : (김정현)
  * DBCProgram.java 연결버튼 클릭 -> DBCProgramAction.java 객체 생성
  * DBCProgramAction.java DB연결 체크. Manager.java 객체의 보임 여부 컨트롤(Visible(true or false))
  
  ModelPritn.java를 이용하여 select, insert, update, delete 작업이 일어나면 해당 객체를 생성하여
  model에 데이터 입력 및 출력
  
  Manager 프레임에서 table 클릭시 해당 열의 정보를 각 JTextField 넣어줌.
  (MouseAdapter 객체의 mouseClick을 사용하여 구현)

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
                      
 delete 담당(오민정) : 변수명 동일하게 deleteActionListener() 작성
                      manager 부분 delete 추가하여 수정완료
                     
                     
                     
추가 사항
 * 전화번호 정규식 적용 ( InsertActionListener, UpdateActionListener 에 존재함)
 * model을 클릭하면 각 값이 TextField에 입력됨, jumin TextField는 PK이기에 변경 불가능해야하기에 -> juminText.setEditable(false)로 함
   변경 또는 삭제 버튼을 누르면  juminText.setEditable(true); 으로 다시 편집 가능함
                     
