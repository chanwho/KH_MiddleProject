import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "*khacademy!";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            
            while(true){
                
                // 로그인화면
                
                // Start start = new Start();
                // start.startFunction();
                Survey survey = new Survey();
                survey.SurveyFunction(statement);
                // Statics statics = new Statics();
                // statics.StaticsFunction(statement);
    
                // 종료화면
    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}