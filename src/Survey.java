import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Survey {
    public void SurveyFunction(Statement statement){
        String query = "select * from question_answer;";
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String 
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
