import java.sql.*;


public class Hedgehog_Insert {

    public void InsertFunction(Statement statement) {

        try{

    // 설문목록 데이터 채우기       // 이미 채워져있는데 또채우면 에러 발생
    String survey_query1 = "INSERT INTO survey_list (UNIQUE_ID, QUESTION_LIST) VALUE ('S1', '3. 반려동물에 관심이 있나요?')";
    statement.execute(survey_query1);
    String survey_query2 = "INSERT INTO survey_list (UNIQUE_ID, QUESTION_LIST) VALUE ('S2', '4. 반려동물을 키울 생각이 있나요?')";
    statement.execute(survey_query2);
    String survey_query3 = "INSERT INTO survey_list (UNIQUE_ID, QUESTION_LIST) VALUE ('S3', '5. 유기동물을 입양할 생각이 있나요?')";
    statement.execute(survey_query3);
    String survey_query4 = "INSERT INTO survey_list (UNIQUE_ID, QUESTION_LIST) VALUE ('S4', '6. 반려동물을 키울 환경이 준비되어 있나요?')";
    statement.execute(survey_query4);
    String survey_query5 = "INSERT INTO survey_list (UNIQUE_ID, QUESTION_LIST) VALUE ('S5', '7. 반려동물이 삶의 만족도에 영향을 준다고 생각하시나요?')";
    statement.execute(survey_query5);
     
     // 문항답변 데이터 채우기
     String question_answer1 = "INSERT INTO question_answer(UNIQUE_ID, QUESTION_ANSWER) VALUE ('C1', '(1) 매우 그렇다')";
     statement.execute(question_answer1);
     String question_answer2 = "INSERT INTO question_answer(UNIQUE_ID, QUESTION_ANSWER) VALUE ('C2', '(2) 그렇다')";
     statement.execute(question_answer2);
     String question_answer3 = "INSERT INTO question_answer(UNIQUE_ID, QUESTION_ANSWER) VALUE ('C3', '(3) 보통')";
     statement.execute(question_answer3);
     String question_answer4 = "INSERT INTO question_answer(UNIQUE_ID, QUESTION_ANSWER) VALUE ('C4', '(4) 조금 아니다')";
     statement.execute(question_answer4);
 
     // 질문/ 답변 대표값 데이터 채우기
     String q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S1', 'C1')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S1', 'C2')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S1', 'C3')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S1', 'C4')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S2', 'C1')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S2', 'C2')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S2', 'C3')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S2', 'C4')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S3', 'C1')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S3', 'C2')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S3', 'C3')";
     statement.execute(q_a_ID);  
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S3', 'C4')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S4', 'C1')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S4', 'C2')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S4', 'C3')";
     statement.execute(q_a_ID);
     q_a_ID = "INSERT INTO survey(UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE ('S4', 'C4')";
     statement.execute(q_a_ID);
        } catch(SQLException exception){
            exception.printStackTrace();
        }
}
}