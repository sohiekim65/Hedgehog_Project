import java.sql.*;
import java.util.Scanner;
public class Hedgehog_Main { 
    
    public static void main(String[] args) { 

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ResultSet resultSetAnswer = null;
    Statement statement = null;
        
    Scanner scanner = new Scanner(System.in);
  
             //연결
    String url = "jdbc:mysql://localhost:3306/hedgehog_sqls";
    String user = "root";
    String password = "*khacademy!";

    try{ 
     connection = DriverManager.getConnection(url, user, password);
     statement = connection.createStatement();

     while(true){        
         // P. 설문시작  S.통계  Q.종료  R. 설문결과
         System.out.println("-----------------------------------------------------------------");
         System.out.println("        P. 설문시작  |  S. 통계  |  Q. 종료  |  R. 설문결과        ");
         System.out.println("-----------------------------------------------------------------");
         // P, S, Q, R 입력 받기
         String choice = scanner.nextLine();

         //@ P 를 선택했을 때
         if(choice.equals("P")) {
        
             
             // SELECT 구현하기



                
           System.out.println();        
           System.out.println("--------------------설문 종료--------------------");
 
           // 설문을 제출할지 다시할지 선택
           System.out.println("--------------------------------------------------");
           System.out.println("            Y. 설문 제출  |  N. 재시작             ");
           System.out.println("--------------------------------------------------");

      // Y | N 선택 의 반복문.
           while(true) {
              String choice2 = scanner.nextLine(); 
              if(choice2.equals("Y")) break;  
              else if(choice2.equals("N")) {      
        
        // DELETE 구현하기
    
              Hedgehog_Delete hd = new Hedgehog_Delete();
              hd.DeleteFunction(statement);


              break;
              }else {
              System.out.println("다시 입력해 주세요"); 
              }
           }

         }
         // S를 선택했을 때
         else if(choice.equals("S")) {
            Hedgehog_Statistics hs = new Hedgehog_Statistics();
            hs.StatisticsFunction(connection, statement, null);
            continue;
         }
 

          //  @ Q를 선택했을 때
         else if(choice.equals("Q")) {
         System.out.println("이용해주셔서 감사합니다!");
         return;  // 이건 void타입일때만      122222222222222222222222
         
         // @ R을 선택했을 때
        } else if(choice.equals("R")) {
            Hedgehog_ResultCheck hr = new Hedgehog_ResultCheck();
            hr.ResultFunction2(connection, statement, null);
            continue;
            
         } else System.out.println("다시 입력해 주세요");
         }   

         
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try {
            scanner.close();
                if(statement!=null)statement.close();
                if(resultSetAnswer!=null)resultSetAnswer.close();
                if(resultSet!=null)resultSet.close();
                if(preparedStatement!=null)preparedStatement.close();
                if(connection!=null)connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
        }
        }
}



} 

