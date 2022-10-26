import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Survey {
    public void SurveyFunction(Statement statement){
        String query = "select * from question_answer;";
        String QuesitionQuery = "select * from question inner join question_answer;";
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(QuesitionQuery);
            
            while(resultSet.next()){
                String QUESTION = resultSet.getString("QUESTION");
                System.out.println(QUESTION);
                
                // String ANSWER_UID = resultSet.getString("ANSWER_UID");
                // System.out.println(ANSWER_UID);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
