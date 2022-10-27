import java.sql.*;

public class Hedgehog_Delete {
         // Y와 N 둘다 처음으로 가지만 N을 입력하면 방금 작성한 내용 초기화
   
            // y/n아니라면 다시 YN질문하기 .
        
    public void DeleteFunction(Statement statement){    //statement 값을 받아와서 쓰겠다.

    try {            
        String query = "SELECT * FROM surveyor";    // 질문목록 불러와서 switch문 쓸때 사용함
        statement.execute(query);    
                                              
        query = "DELETE FROM result WHERE UNIQUE_ID_SURVEYOR = (SELECT MAX(UNIQUE_ID) FROM surveyor)";    // result 테이블의 UNIQUE_ID_SURVEYOR 최대값 삭제 = 가장 마지막 사람 삭제
        statement.execute(query);
       

        query = "DELETE FROM surveyor WHERE UNIQUE_ID = (SELECT MAX(UNIQUE_ID) FROM(SELECT UNIQUE_ID FROM surveyor AS AA) AS A)";  
 
        statement.execute(query);

        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }
}