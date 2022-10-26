import java.sql.*;
// import java.util.Scanner;

public class Hedgehog_ResultCheck {
    // 나의 설문 결과 조회1
    public void ResultFunction(Statement statement){
        // String query = "SELECT NAME, group_concat(UNIQUE_ID_QUESTION_ANSWER separator '          ')"
        //             + "FROM (SURVEYOR INNER JOIN RESULT ON SURVEYOR.UNIQUE_ID = RESULT.UNIQUE_ID_SURVEYOR)"
        //             + "WHERE SURVEYOR.UNIQUE_ID = (SELECT MAX(SURVEYOR.UNIQUE_ID) FROM SURVEYOR) ORDER BY UNIQUE_ID_SURVEY_LIST";
        // ResultSet resultSet;
        // try {
        //     resultSet = statement.executeQuery(query);
        //     System.out.println("           질문(3)      질문(4)      질문(5)      질문(6)      질문(7)");
        //     while(resultSet.next()){
        //         String name = resultSet.getString("NAME");
        //         String question_answer = resultSet.getString("group_concat(UNIQUE_ID_QUESTION_ANSWER separator '          ')");
        //         System.out.print(name + "       ");
        //         System.out.print(question_answer);
        //     }
        //     System.out.println();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }


    // 나의 설문 결과 조회2
    public void ResultFunction2(Connection connection, Statement statement, PreparedStatement preparedStatement){ 

        String query = "SELECT * FROM SURVEYOR WHERE UNIQUE_ID = (SELECT MAX(UNIQUE_ID) FROM SURVEYOR);";
        String answerQuery = "SELECT *, MAX(UNIQUE_ID_SURVEYOR) FROM RESULT WHERE UNIQUE_ID_SURVEYOR = ?"
                            + "GROUP BY UNIQUE_ID_SURVEY_LIST";
        ResultSet resultSet2;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet2 = preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement(answerQuery);

            System.out.println("         질문(3)     질문(4)     질문(5)     질문(6)     질문(7)");
            System.out.println("이름)");
            while(resultSet2.next()){
                String name = resultSet2.getString("NAME");
                System.out.print(name + "     ");

                preparedStatement.setString(1, resultSet2.getString("UNIQUE_ID"));
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
}
