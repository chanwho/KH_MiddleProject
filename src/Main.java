import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/kh_middle";
        String user = "root";
        String password = "*khacademy!";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            // while(true){
                
                // 로그인화면
                LogIn login = new LogIn();
                String Main_user_number = login.LoginFunction(statement);
                System.out.println(Main_user_number);
                // Start start = new Start();
                // start.startFunction();
                Survey survey = new Survey();
                survey.SurveyFunction(statement, Main_user_number);
                // break;
                // Statics statics = new Statics();
                // statics.StaticsFunction(statement);
    
                // 종료화면
            // }
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}