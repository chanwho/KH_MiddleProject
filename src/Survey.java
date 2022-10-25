import java.sql.Statement;

public class Survey {
    public void SurveyFunction(Statement statement){
        try {
            String query = "select * from question_answer;";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
