import java.sql.*;
// import java.util.Scanner;

public class Hedgehog_ResultCheck {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSetCheck;
    Statement statement;

    public void ResultFunction2(Connection connection, Statement statement, PreparedStatement preparedStatement){ 

        String query = "SELECT * FROM SURVEYOR WHERE UNIQUE_ID = (SELECT MAX(UNIQUE_ID) FROM SURVEYOR);";
        String answerQuery = "SELECT *, MAX(UNIQUE_ID_SURVEYOR) FROM RESULT WHERE UNIQUE_ID_SURVEYOR = ?"
                            + "GROUP BY UNIQUE_ID_SURVEY_LIST";
                            
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSetCheck = preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement(answerQuery);

            System.out.println("         질문(3)     질문(4)     질문(5)     질문(6)     질문(7)");
            System.out.println("이름)");
            while(resultSetCheck.next()){
                String name = resultSetCheck.getString("NAME");
                System.out.print(name + "     ");

                preparedStatement.setString(1, resultSetCheck.getString("UNIQUE_ID"));
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
