import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/kh_middle";
        String user = "root";
        String password = "*khacademy!";
        Scanner sc = new Scanner(System.in);    
        String StartCommend;
        Boolean quit = false;
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // 로그인화면
            LogIn login = new LogIn();
            String Main_user_number = login.LoginFunction(statement);
            // System.out.println(Main_user_number);

            do {
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.println("P.설문시작 | S.통계 | Q.종료");
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.print("선택 : ");
                StartCommend = sc.nextLine();
    
                switch(StartCommend) {
                    case "P" :
                    case "p" :
                    // 설문 호출
                        Survey survey = new Survey();
                        survey.SurveyFunction(statement, Main_user_number);
                        break;

                    case "S" :
                    case "s" :
                    // 통계 호출
                        Statics statics = new Statics();
                        statics.StaticsFunction(statement, Main_user_number);
                        break;

                    case "Q" :
                    case "q" :
                    // 종료
                        quit = true;
                        System.out.println("종료합니다.");
                        break;
                        
                    default :
                    System.out.println("P/S/Q 중에 입력해주세요.");
                }
            } while (!quit == true);        

            } catch (SQLException e) {
            e.printStackTrace();
        }
    sc.close();
    }
}