import java.util.Scanner;
import java.sql.*;

public class SURVEY_PRAC {

    public static void Survey(Statement statement){
        Scanner scanner = new Scanner(System.in);

        try {

          // 이름과 생년월일 입력 받기
             System.out.println("1. 이름을 입력해주세요 : ");    
             System.out.print("이름) ");
             String surveyor_Name = scanner.nextLine();
             System.out.println("2. 생년월일을 입력해주세요 : ");
             System.out.print("생년월일) ");
             String surveyor_Birth = scanner.nextLine();
   
             String query0 = "INSERT INTO surveyor(NAME, BIRTH_DATE)  VALUE ('"+surveyor_Name+"', '"+surveyor_Birth+"')";  
             statement.execute(query0);
              // 여기까지 p를 선택하고 이름, 생일 입력받고 그 값을 테이블에 추가

              

        // 설문 입력 받기
        // 3번
        while(true){
            System.out.println("3. 반려동물에 관심이 있나요?");
         System.out.println("(1) 매우 그렇다"+ " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");
            
            Integer number3 = scanner.nextInt();
            
            if(number3 == 1){   
                String query = "SELECT MAX(UNIQUE_ID) FROM surveyor";    // surveyor을 불러오고
                ResultSet resultSet = statement.executeQuery(query);    //resultSet에 값을 담고         
            
                resultSet.next();
                       
                String UNIQUE_ID_result = resultSet.getString("MAX(UNIQUE_ID)");   // UNUQIE_ID_result에 getString로 UNIQUE_ID값을 담는다   
   
               //  강사님 코드와 다른점 WHILE(RESULTSET.NEXT()) 가 없음.   --> 몇번째 값인지 특정하지 못하는듯하다.  --->  37열  while문의 RESULT.LAST를 사용해 끝까지 넘긴 후  // 
                // MAX(UNIQUE_ID) 를 사용해 값을하나만 남긴 후 출력해보기 // 안되면 resultSet.next() 사용해서 어차피 하나밖에 없으니 출력해보기
                query = "INSERT INTO result (UNIQUE_ID_SURVEY_LIST, UNIQUE_ID_SURVEYOR, UNIQUE_ID_QUESTION_ANSWER) VALUE ('"+UNIQUE_ID_result+"','"+surveyor_Name+"', '"+surveyor_Birth+"' )";  //여기에 UNIQUE_ID를 넣으려면 SURVEYOR에서 UNIQUE_ID값을 받아 넣기
                statement.execute(query);

                // ------------------------
                // ID는 나중에 넣고 입력받은 NAME과 BIRTH를 먼저 넣은 후 나중에 UPDATE로 추가해보자

                // String query = "SELECT * FROM surveyor";    // 
                // ResultSet resultSet = statement.executeQuery(query);    
                // query = "INSERT INTO result (UNIQUE_ID_SURVEYOR, UNIQUE_ID_QUESTION_ANSWER) VALUE ('"+surveyor_Name+"', '"+surveyor_Birth+"' )";  //여기에 UNIQUE_ID를 넣으려면 SURVEYOR에서 UNIQUE_ID값을 받아 넣기
                // statement.execute(query);


                // resultSet.last(); 
                // String UNIQUE_ID_result = resultSet.getString("UNIQUE_ID");

                break;
            }
            if(number3 == 2){                
                break;
            }
            if(number3 == 3){                
                break;
            }
            if(number3 == 4){               
                break;
            } else {
                System.out.println("다시 입력해주세요");
                System.out.println("\n");
                continue;
            }
        }   
        System.out.println("\n");
        
        // 4번                
        while(true){
            System.out.println("4. 반려동물을 키울 생각이 있나요?");
            System.out.println("(1) 매우 그렇다"+ " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");
            
            Integer number4 = scanner.nextInt();
            
                if(number4 == 1){
                    break;
                }
                if(number4 == 2){
                    break;
                }
                if(number4 == 3){
                    break;
                }
                if(number4 == 4){
                    break;
                } else {
                    System.out.println("다시 입력해주세요");
                    System.out.println("\n");
                    continue;
                }
        }   
            System.out.println("\n");
         
        // 5번
        while(true){
            System.out.println("5. 유기동물을 입양할 생각이 있나요?");
            System.out.println("(1) 매우 그렇다"+ " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");
            
            Integer number5 = scanner.nextInt();
            
                if(number5 == 1){
                    break;
                }
                if(number5 == 2){
                    break;
                }
                if(number5 == 3){
                    break;
                }
                if(number5 == 4){
                    break;
                } else {
                    System.out.println("다시 입력해주세요");
                    System.out.println("\n");
                    continue;
                }
        }
            System.out.println("\n");

            
         // 6번
         while(true){
            System.out.println("4. 반려동물을 키울 생각이 있나요?");
            System.out.println("(1) 매우 그렇다"+ " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");
            
            Integer number6 = scanner.nextInt();
            
                if(number6 == 1){
                    break;
                }
                if(number6 == 2){
                    break;
                }
                if(number6 == 3){
                    break;
                }
                if(number6 == 4){
                    break;
                } else {
                    System.out.println("다시 입력해주세요");
                    System.out.println("\n");
                    continue;
                }
        }
        System.out.println("\n");    
         
        // 7번
        while(true){
            System.out.println("7. 반려동물이 삶의 만족도에 영향을 준다고 생각하시나요?");
            System.out.println("(1) 매우 그렇다"+ " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");
            
            Integer number7 = scanner.nextInt();
            
                if(number7 == 1){
                    break;
                }
                if(number7 == 2){
                    break;
                }
                if(number7 == 3){
                    break;
                }
                if(number7 == 4){
                    break;
                } else {
                    System.out.println("다시 입력해주세요");
                    System.out.println("\n");
                    continue;
                }
        }
            System.out.println("\n");  
        
        
        // scanner.close();

    } catch (SQLException exception) {
        exception.printStackTrace();

    }

        

    }
}

        
    

            
        

        
    



    

