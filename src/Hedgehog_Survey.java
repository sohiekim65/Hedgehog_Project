import java.util.Scanner;

public class Hedgehog_Survey {

    public static void Survey(){
        Scanner scanner = new Scanner(System.in);

        // 설문 입력 받기
        // 3번
        while(true){
            System.out.println("3. 반려동물에 관심이 있나요?");
            System.out.println("(1) 매우 그렇다"+ " (2) 그렇다" + " (3) 그렇지 않다" + " (4) 전혀 그렇지 않다");
            
            Integer number3 = scanner.nextInt();
            
            if(number3 == 1){               
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
        
        
        scanner.close();

       

        

    }
}

        
    

            
        

        
    



    

