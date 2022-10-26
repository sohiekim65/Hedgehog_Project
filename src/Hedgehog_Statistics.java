import java.sql.*;
import java.util.Scanner;

public class Hedgehog_Statistics {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Statement statement;
    
    public void StatisticsFunction(Connection connection, Statement statement, PreparedStatement preparedStatement){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. 설문자별 답변 결과 | 2. 질문별 총 답변 수");
            // 1, 2 입력 받기
            System.out.print("선택)");
            String choice = scanner.nextLine();
            // 1번 출력
            if(choice.equals("1")){
                AnswerResult(connection, statement, preparedStatement);
                break;
            // 2번 출력
            } else if(choice.equals("2")){
                AnswerCount(statement);
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                continue;
            }
        }
        scanner.close();
    }

    // 설문자별 답변 결과
    public void AnswerResult(Connection connection, Statement statement, PreparedStatement preparedStatement){
        // 접근할 쿼리 - 이름 출력
        String query = "SELECT * FROM SURVEYOR";
        // 접근할 쿼리 - 답변 출력
        String answerQuery = "SELECT UNIQUE_ID_QUESTION_ANSWER FROM RESULT WHERE UNIQUE_ID_SURVEYOR=?;";
            try {
                // 이름 쿼리 전송(statement 사용 무관)
                preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                // ResultSet resultSet = statement.executeQuery(query);
                // ?가 있는 SQL문 전송
                preparedStatement = connection.prepareStatement(answerQuery);

                System.out.println("         질문(3)     질문(4)     질문(5)     질문(6)     질문(7)");
                System.out.println("이름)");
                while(resultSet.next()){
                    String name = resultSet.getString("NAME");
                    System.out.print(name + "     ");

                    // 이름에 맞는 답변 출력하기 위해 설문자UID를 가져와 세팅 
                    // SQL문을 받고 ?에 설문자UID 삽입
                    preparedStatement.setString(1, resultSet.getString("UNIQUE_ID"));
                    // 답변 쿼리 전송
                    ResultSet resultSetAnswer = preparedStatement.executeQuery();

                    while(resultSetAnswer.next()){
                        System.out.print(resultSetAnswer.getString("UNIQUE_ID_QUESTION_ANSWER"));
                        System.out.print("          ");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void AnswerCount(Statement statement){
        String query = "SELECT UNIQUE_ID_SURVEY_LIST, count(case when UNIQUE_ID_QUESTION_ANSWER = 'C1' THEN 1 END) AS 'C1'"
                        +", count(case when UNIQUE_ID_QUESTION_ANSWER = 'C2' THEN 1 END) AS 'C2'"
                        +", count(case when UNIQUE_ID_QUESTION_ANSWER = 'C3' THEN 1 END) AS 'C3'"
                        +", count(case when UNIQUE_ID_QUESTION_ANSWER = 'C4' THEN 1 END) AS 'C4'"
                        +", count('C1') FROM RESULT GROUP BY UNIQUE_ID_SURVEY_LIST;";
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
            int question = 3;
            
            System.out.println("             답(1)     답(2)     답(3)     답(4)");
            while(resultSet.next()){
                // String surveyList = resultSet.getString("UNIQUE_ID_SURVEY_LIST");
                String C1 = resultSet.getString("C1");
                String C2 = resultSet.getString("C2");
                String C3 = resultSet.getString("C3");
                String C4 = resultSet.getString("C4");
                System.out.println("질문" + "(" + question + ")" + "        " + C1 + "         " + C2 + "         " + C3 + "         " + C4);
                question++;
                }
                System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
