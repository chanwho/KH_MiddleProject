import java.util.Scanner;

public class Start {
    public void startFunction(){     //LCW.22'10'25 리턴값으로 사용자가 입력한 String 념겨줌
        Scanner sc = new Scanner(System.in);    
        
            System.out.println("---------------------------------------------------------");
            System.out.println("P.설문시작 | S.통계 | Q.종료");
            System.out.println("---------------------------------------------------------");
            System.out.println("선택 : ");
            String StartCommend = sc.next();
            if (StartCommend == "P" || StartCommend == "p"){
                // 설문조사로 넘어감
            }
            if (StartCommend == "S" || StartCommend == "s"){
                // 통계로 넘어감
            }
            if (StartCommend == "Q" || StartCommend == "q"){
                // 종료화면으로 넘어감
                System.out.println("종료합니다");
            }
        
    }

    
        




}
