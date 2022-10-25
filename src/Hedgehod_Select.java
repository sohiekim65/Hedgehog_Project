
import java.sql.*;



public class Hedgehod_Select {
    public void SelectFunction(Statement statement) {
         // SELECT * FROM SUERVEYOR ; and excute
         String query = "SELECT * FROM SURVEYOR";
         ResultSet resultSet;
         try{
             resultSet = statement.executeQuery(query);
             // 결과 출력
             while(resultSet.next()){
                 String UNIQUE_ID = resultSet.getString("UNIQUE_ID");
                 System.out.println("UNIQUE_ID : " + UNIQUE_ID);
                 System.out.println(", NAME : " + resultSet.getString("NAME"));
                 System.out.println(", BIRTH_DATE : " + resultSet.getString("BIRTH_DATE"));

                 System.out.println("");

               } 
         } catch(SQLException exception){
            exception.printStackTrace();
         }

        query = "SELECT * FROM SURVEY_LIST";
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String UNIQUE_ID = resultSet.getString("UNIQUE_ID");
                System.out.println("UNIQUE_ID : " + UNIQUE_ID);
                System.out.println(", QUESTION_LIST : " + resultSet.getString("QUESTION_LIST"));

                System.out.println("");
            }
        } catch(SQLException exception){
            exception.printStackTrace();
        }

        query = "SELECT * FROM QUESTION_ANSWER";
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String UNIQUE_ID = resultSet.getString("UNIQUE_ID");
                System.out.println("UNIQUE_ID : " + UNIQUE_ID);
                System.out.println(", QUESTION_ANSWER : " + resultSet.getString("QUESTION_ANSWER"));

                System.out.println("");
                
            }
        } catch(SQLException exception){
            exception.printStackTrace();
        }

        query = "SELECT * FROM RESULT";
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String UNIQUE_ID_SURVEYOR = resultSet.getString("UNIQUE_ID_SURVEYOR");
                System.out.println("UNIQUE_ID_SURVEYOR : " + UNIQUE_ID_SURVEYOR);
                System.out.println(", UNIQUE_ID_SURVEY_LIST: " + resultSet.getString("UNIQUE_ID_SURVEY_LIST"));
                System.out.println(", UNIQUE_ID_QUESTION_ANSWER : " + resultSet.getString("UNIQUE_ID_QUESTION_ANSWER"));
            
                System.out.println("");
            }
        } catch(SQLException exception){
            exception.printStackTrace();
        }
          
        query = "SELCET * FROM SURVEY";
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String UNIQUE_ID_SURVEY_LIST = resultSet.getString("UNIQUE_ID_SURVEY_LIST");
                System.out.println("UNIQUE_ID_SURVEY_LIST : " + resultSet.getString("UNIQUE_ID_SURVEY_LIST"));
                System.out.println(", UNIQUE_ID_QUESTION_ANSWER : " + resultSet.getString("UNIQUE_ID_QUESTION_ANSWER"));
                
                System.out.println("");
            }
         } catch(SQLException exception){
            exception.printStackTrace();
         }
    

    }
    
}

