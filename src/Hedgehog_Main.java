import java.sql.*;
import java.util.Scanner;
public class Hedgehog_Main { 
    public static void main(String[] args) {
        
    Statement statement;
    Scanner scanner = new Scanner(System.in);
  
             //연결
    String url = "jdbc:mysql://localhost:3306/hedgehog_sqls";
    String user = "root";
    String password = "*khacademy!";

    try{ 
     Connection connection = DriverManager.getConnection(url, user, password);
     statement = connection.createStatement();

     // 설문 전 데이터 INSERT 구현
     Hedgehog_Insert hi = new Hedgehog_Insert();
     hi.InsertFunction(statement);

     while(true){        
         // P. 설문시작  S.통계  Q.종료  R. 설문결과
         System.out.println("-----------------------------------------------------------------");
         System.out.println("        P. 설문시작  |  S. 통계  |  Q. 종료  |  R. 설문결과        ");
         System.out.println("-----------------------------------------------------------------");
         // P, S, Q, R 입력 받기
         String choice = scanner.nextLine();

         //@ P 를 선택했을 때
         if(choice.equals("P")) {
        
            //  // 이름과 생년월일 입력 받기
            //  System.out.println("1. 이름을 입력해주세요 : ");    
            //  System.out.print("이름) ");
            //  String surveyor_Name = scanner.nextLine();
            //  System.out.println("2. 생년월일을 입력해주세요 : ");
            //  System.out.print("생년월일) ");
            //  String surveyor_Birth = scanner.nextLine();
   
            //  String query = "INSERT INTO surveyor(NAME, BIRTH_DATE)  VALUE ('"+surveyor_Name+"', '"+surveyor_Birth+"')";  
            //  statement.execute(query);
            //   // 여기까지 p를 선택하고 이름, 생일 입력받고 그 값을 테이블에 추가

              
            //  // SELECT 문 구현해서 질문목록 불러오고 답변을 테이블에 저장
            // Hedgehog_Survey hs = new Hedgehog_Survey();         /// 소희님 메소드받아옴.  @@@@@@@@@ SELECT실험 위해 임시 주석처리
            // hs.Survey();
            SURVEY_PRAC aaa = new SURVEY_PRAC();
            aaa.Survey(statement);

             // SELECT 문 구현해서 질문목록 불러오고 답변을 테이블에 저장


                
     System.out.println();        
     System.out.print("--------------------설문 종료--------------------");
 
     // 설문을 제출할지 다시할지 선택
     System.out.println("--------------------------------------------------");
     System.out.println("            Y. 설문 제출  |  N. 재시작             ");
     System.out.println("--------------------------------------------------");

     // Y | N 선택 의 반복문.
     while(true) { // 잘못된 입력시 다시 해달라는 while
     String choice2 = scanner.nextLine(); 
     if(choice2.equals("Y")) break;   // Y를 선택하면 반복문을 나가 다시 처음으로 감.
     else if(choice2.equals("N")) {  // N을 선택하면 정보 지우고 다시 처음으로 감
         // DELETE 구현하기
         // surveyor_ID = "P"+ surveyor_num;  P1, 2 잘 증가하지만 여기서 다시 선언해도 의미없네  넘어가서는 P0  지워도 되는 라인XXXXXXXXXXXXXXXXXXXXXXXXXX  
                                     // 여기까지 P1인상태
         Hedgehog_Delete hd = new Hedgehog_Delete();
         hd.DeleteFunction(statement);


         break;
      }else {
      System.out.println("다시 입력해 주세요");
      // Y / N 이 아니라면 다시 위로 올라가서 WHILE문 안에서 못나감.
     }
     }




         }
         // S를 선택했을 때
         else if(choice.equals("S")) {
             System.out.println("통계구현중");
             // 통계 구현
         }
 


          //  @ Q를 선택했을 때
         else if(choice.equals("Q")) {
         System.out.println("이용해주셔서 감사합니다!");
         return;  // 이건 void타입일때만      122222222222222222222222
         // @ R을 선택했을 때

         } else if(choice.equals("R")) {
             // 설문결과 구현

         } else System.out.println("다시 입력해 주세요");
         }   // 전체 WHILE 닫힘


     } catch (SQLException exception) {
      exception.printStackTrace();
     }
  
     scanner.close();
}


}
