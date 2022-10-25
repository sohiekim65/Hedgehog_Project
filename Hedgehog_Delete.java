import java.sql.*;

public class Hedgehog_Delete {
         // Y와 N 둘다 처음으로 가지만 N을 입력하면 방금 작성한 내용 초기화
   
            // y/n아니라면 다시 YN질문하기 .
        
    public void DeleteFunction(Statement statement){    //statement 값을 받아와서 쓰겠다.

        // Hedgehog_test ht = new Hedgehog_test();
      
    try {            
        String query = "SELECT * FROM surveyor";    // 질문목록 불러와서 switch문 쓸때 사용함
        statement.execute(query);    // 값을 resultSet에 담아서
                                              
        query = "DELETE FROM result WHERE UNIQUE_ID_SURVEYOR = (SELECT MAX(UNIQUE_ID) FROM surveyor)";    // result 테이블의 UNIQUE_ID_SURVEYOR 최대값 삭제 = 가장 마지막 사람 삭제
        statement.execute(query);
                                                    //main의 인스턴스변수는 main의 증감식을 통해 증가해도 여기선 초기값으로 넘어온다.
        // num++;   // 그냥 여기서 부터 시작하는 p값을 넣어서 증가시켜줌으로 main과 수치를 맞춰줬다...  // 오류  그냥 제출하고 N으로 넘어오지 않는경우 문제.
            // 대표값 입력을 auto increase로 바꿔 unique_Id가 자동으로 증가해 문자+숫자의 변수를 사용하지 않게 되었다.
            //최고 값은 서브쿼리에 max집계함수를 써서 최고값을 찾아냈다.( id가 오름차순으로 오르기 때문)  

        query = "DELETE FROM surveyor WHERE UNIQUE_ID = (SELECT MAX(UNIQUE_ID) FROM(SELECT UNIQUE_ID FROM surveyor AS AA) AS A)";  
            // surveyor unique_id 폴더의 최대값삭제 ,  본인은 본인참조가 안되서 한번 더 감싸고//  모든 테이블은 고유의 alias(별칭)를 가져야 함
        statement.execute(query);

        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }
}