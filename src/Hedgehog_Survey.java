import java.util.Scanner;
import java.sql.*;

public class Hedgehog_Survey {

    public boolean selectFunction(Statement statement) {
        Scanner scanner = new Scanner(System.in);
        boolean result = true;

        try {

            // 이름과 생년월일 입력 받기
            System.out.println("1. 이름을 입력해주세요 : ");
            System.out.print("이름) ");
            String surveyor_Name = scanner.nextLine();
            System.out.println("2. 생년월일을 입력해주세요 : ");
            System.out.print("생년월일) ");
            String surveyor_Birth = scanner.nextLine();
            System.out.println("\n");

            String queryCheck = "SELECT * FROM surveyor";
            ResultSet resultSetCheck = statement.executeQuery(queryCheck);
            while (resultSetCheck.next()) {
                if ((surveyor_Name.equals(resultSetCheck.getString("NAME")))
                        && (surveyor_Birth.equals(resultSetCheck.getNString("BIRTH_DATE")))) {
                    System.out.println("[ 이미 설문 완료하였습니다! ]");
                    System.out.println("\n");
                    result = false;
                    break;
                }
            }

            if (result) {

                String query0 = "INSERT INTO surveyor(NAME, BIRTH_DATE)  VALUE ('" + surveyor_Name + "', '"
                        + surveyor_Birth
                        + "')";
                statement.execute(query0);
                // 여기까지 p를 선택하고 이름, 생일 입력받고 그 값을 테이블에 추가

                // 설문 입력 받기
                // 3번
                while (true) {

                    System.out.println("3. 반려동물에 관심이 있나요?");
                    System.out.println("(1) 매우 그렇다" + " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");

                    String number3 = scanner.nextLine();
                    if ("1,2,3,4".contains(number3 + "")) {
                        String UNIQUE_ID_question_answer = "C" + number3;

                        String query2 = "SELECT MAX(UNIQUE_ID) FROM surveyor"; // surveyor을 불러오고 UNIQUE_ID_SURVEYOR 
                                                                               // 설문자 대표값은
                                                                               // 항상 최대값이 최신 고객번호담기
                        ResultSet resultSet2 = statement.executeQuery(query2); // resultSet에 값을 담고
                        resultSet2.next(); // UNIQUE_ID_SURVEYOR 의 최대값이 그냥은 지정이 안되서 next를 사용해 지정.
                        String UNIQUE_ID_surveyor = resultSet2.getString("MAX(UNIQUE_ID)"); //

                        String query = "INSERT INTO result (UNIQUE_ID_SURVEYOR, UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE"
                                + "('" + UNIQUE_ID_surveyor + "', 'S1', '" + UNIQUE_ID_question_answer + "' )";

                                         // 고객번호 ( )  질문번호 S1( )  질문의답 ( )
                        statement.execute(query);

                        break;
                    } else {
                        System.out.println("다시 입력해주세요");
                        System.out.println("\n");
                        continue;
                    }
                }
                System.out.println("\n");

                // 4번
                while (true) {
                    System.out.println("4. 반려동물을 키울 생각이 있나요?");
                    System.out.println("(1) 매우 그렇다" + " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");

                    String number4 = scanner.nextLine();
                    if ("1,2,3,4".contains(number4 + "")) {

                        String UNIQUE_ID_question_answer = "C" + number4;

                        String query2 = "SELECT MAX(UNIQUE_ID) FROM surveyor"; // surveyor을 불러오고 UNIQUE_ID_SURVEYOR
                                                                               // 설문자 대표값은
                                                                               // 항상 최대값이 최신 고객번호담기
                        ResultSet resultSet2 = statement.executeQuery(query2); // resultSet에 값을 담고
                        resultSet2.next(); // UNIQUE_ID_SURVEYOR 의 최대값이 그냥은 지정이 안되서 next를 사용해 지정.
                        String UNIQUE_ID_surveyor = resultSet2.getString("MAX(UNIQUE_ID)"); //

                        String query = "INSERT INTO result (UNIQUE_ID_SURVEYOR, UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE"
                                + "('" + UNIQUE_ID_surveyor + "', 'S2', '" + UNIQUE_ID_question_answer + "' )";

                                            // 고객번호 ( )  질문번호 S2( )  질문의답 ( )
                        statement.execute(query);

                        break;
                    } else {
                        System.out.println("다시 입력해주세요");
                        System.out.println("\n");
                        continue;
                    }
                }
                System.out.println("\n");

                // 5번
                while (true) {
                    System.out.println("5. 유기동물을 입양할 생각이 있나요?");
                    System.out.println("(1) 매우 그렇다" + " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");

                    String number5 = scanner.nextLine();
                    if ("1,2,3,4".contains(number5 + "")) {

                        String UNIQUE_ID_question_answer = "C" + number5;

                        String query2 = "SELECT MAX(UNIQUE_ID) FROM surveyor"; // surveyor을 불러오고 UNIQUE_ID_SURVEYOR
                                                                               // 설문자 대표값은
                                                                               // 항상 최대값이 최신 고객번호담기
                        ResultSet resultSet2 = statement.executeQuery(query2); // resultSet에 값을 담고
                        resultSet2.next(); // UNIQUE_ID_SURVEYOR 의 최대값이 그냥은 지정이 안되서 next를 사용해 지정.
                        String UNIQUE_ID_surveyor = resultSet2.getString("MAX(UNIQUE_ID)"); //

                        String query = "INSERT INTO result (UNIQUE_ID_SURVEYOR, UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE"
                                + "('" + UNIQUE_ID_surveyor + "', 'S3', '" + UNIQUE_ID_question_answer + "' )";

                                            // 고객번호 ( )  질문번호 S3( )  질문의답 ( )
                        statement.execute(query);

                        break;
                    } else {
                        System.out.println("다시 입력해주세요");
                        System.out.println("\n");
                        continue;
                    }
                }
                System.out.println("\n");

                // 6번
                while (true) {
                    System.out.println("6. 반려동물을 키울 환경이 준비되어 있나요?");
                    System.out.println("(1) 매우 그렇다" + " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");

                    String number6 = scanner.nextLine();
                    if ("1,2,3,4".contains(number6 + "")) {

                        String UNIQUE_ID_question_answer = "C" + number6;

                        String query2 = "SELECT MAX(UNIQUE_ID) FROM surveyor"; // surveyor을 불러오고 UNIQUE_ID_SURVEYOR
                                                                               // 설문자 대표값은
                                                                               // 항상 최대값이 최신 고객번호담기
                        ResultSet resultSet2 = statement.executeQuery(query2); // resultSet에 값을 담고
                        resultSet2.next(); // UNIQUE_ID_SURVEYOR 의 최대값이 그냥은 지정이 안되서 next를 사용해 지정.
                        String UNIQUE_ID_surveyor = resultSet2.getString("MAX(UNIQUE_ID)"); //

                        String query = "INSERT INTO result (UNIQUE_ID_SURVEYOR, UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE"
                                + "('" + UNIQUE_ID_surveyor + "', 'S4', '" + UNIQUE_ID_question_answer + "' )"; 

                                         // 고객번호 ( )  질문번호 S4( )  질문의답 ( )
                        statement.execute(query);

                        break;
                    } else {
                        System.out.println("다시 입력해주세요");
                        System.out.println("\n");
                        continue;
                    }
                }
                System.out.println("\n");

                // 7번
                while (true) {
                    System.out.println("7. 반려동물이 삶의 만족도에 영향을 준다고 생각하시나요?");
                    System.out.println("(1) 매우 그렇다" + " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");

                    String number7 = scanner.nextLine();
                    if ("1,2,3,4".contains(number7 + "")) {

                        String UNIQUE_ID_question_answer = "C" + number7;

                        String query2 = "SELECT MAX(UNIQUE_ID) FROM surveyor"; // surveyor을 불러오고 UNIQUE_ID_SURVEYOR
                                                                               // 설문자 대표값은
                                                                               // 항상 최대값이 최신 고객번호담기
                        ResultSet resultSet2 = statement.executeQuery(query2); // resultSet에 값을 담고
                        resultSet2.next(); // UNIQUE_ID_SURVEYOR 의 최대값이 그냥은 지정이 안되서 next를 사용해 지정.
                        String UNIQUE_ID_surveyor = resultSet2.getString("MAX(UNIQUE_ID)"); //

                        String query = "INSERT INTO result (UNIQUE_ID_SURVEYOR, UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_QUESTION_ANSWER) VALUE"
                                + "('" + UNIQUE_ID_surveyor + "', 'S5', '" + UNIQUE_ID_question_answer + "' )"; 

                                         // 고객번호 ( )  질문번호 S5( )  질문의답 ( )
                        statement.execute(query);

                        break;
                    } else {
                        System.out.println("다시 입력해주세요");
                        System.out.println("\n");
                        continue;
                    }
                }
                System.out.println("\n");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

}
