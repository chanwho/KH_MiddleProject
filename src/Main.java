import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/middle_project";
        String user = "root";
        String password = "khacademy!";


        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            
            // String query = "SELECT* FROM AUTHOR";
            // ResultSet resultSet;
            // resultSet = statement.executeQuery(query);
            // //AUTHOR (AUTHOR_UID, AUTHOR)
            // while(resultSet.next()){
            // String AUTHOR_UID = resultSet.getString("AUTHOR_UID");
            // System.out.println("AUTHOR_UID: "+AUTHOR_UID);
            // String AUTHOR = resultSet.getString("AUTHOR");
            // System.out.println("AUTHOR: "+AUTHOR);
            // }

            String query1 = "SELECT* FROM ANSWER";
            ResultSet resultSet1;
            resultSet1 = statement.executeQuery(query1);
            while(resultSet1.next()){
            String ANSWER_UID = resultSet1.getString("ANSWER_UID");
            System.out.println("ANSWER_UID: "+ANSWER_UID);
            String USER_UID = resultSet1.getString("USER_UID");
            System.out.println("USER_UID: "+USER_UID);
            String QUESTION_UID = resultSet1.getString("QUESTION_UID");
            System.out.println("QUESTION_UID: "+QUESTION_UID);
            }

            // query = "INSERT INTO USER (USER_UID, ID, PW, AUTHOR_UID)"+
            //             "VALUES ('MB06', 'jjjj11', 'j12345', 'AT02')";
            // statement.execute(query);


            // while(true){
                
                // 로그인화면
                
                // Start start = new Start();
                // start.startFunction();
                // Survey survey = new Survey();
                // survey.SurveyFunction(statement);
                // Statics statics = new Statics();
                // statics.StaticsFunction(statement);
    
                // 종료화면
    
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}