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
            // Start start = new Start();
            Survey survey = new Survey();
            // Statics statics = new Statics();
            End end = new End();


            while(true){
                String user_number = "";
                // 로그인화면
                
                // start.startFunction();
                survey.SurveyFunction(statement, user_number);          // 설문화면
                // statics.StaticsFunction(statement);
                end.EndFunction();                                      // 종료화면
                break;
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}