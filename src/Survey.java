import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Survey {
    public void SurveyFunction(Statement statement){
        String query_question1 = "select question.QUESTION from question where question.QUESTION_UID = 'QS01';";
        String query_answer1 = "select * from answer inner join question ON question.QUESTION_UID = ANSWER.question_uid where question.QUESTION_UID = 'QS01';";
        String query_question2 = "select question.QUESTION from question where question.QUESTION_UID = 'QS02';";
        String query_answer2 = "select * from answer inner join question ON question.QUESTION_UID = ANSWER.question_uid where question.QUESTION_UID = 'QS02';";
        String query_question3 = "select question.QUESTION from question where question.QUESTION_UID = 'QS03';";
        String query_answer3 = "select * from answer inner join question ON question.QUESTION_UID = ANSWER.question_uid where question.QUESTION_UID = 'QS03';";
        String query_question4 = "select question.QUESTION from question where question.QUESTION_UID = 'QS04';";
        String query_answer4 = "select * from answer inner join question ON question.QUESTION_UID = ANSWER.question_uid where question.QUESTION_UID = 'QS04';";
        String query_question5 = "select question.QUESTION from question where question.QUESTION_UID = 'QS05';";
        String query_answer5 = "select * from answer inner join question ON question.QUESTION_UID = ANSWER.question_uid where question.QUESTION_UID = 'QS05';";

        Scanner sc = new Scanner(System.in);
        ResultSet resultSet;
        try {
            // 1번
            resultSet = statement.executeQuery(query_question1);
            while(resultSet.next()){
                String QUESTION = resultSet.getString("QUESTION");
                System.out.println(QUESTION);

            }
            resultSet = statement.executeQuery(query_answer1);
            while(resultSet.next()){
                String answer = resultSet.getString("answer");
                System.out.println(answer);
            }
            String answer1 = sc.next();
            String answerInsert1 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('MB01','QS01','AS0"+ answer1 +"');";
            statement.execute(answerInsert1);

            // 2번
            resultSet = statement.executeQuery(query_question2);
            while(resultSet.next()){
                String QUESTION = resultSet.getString("QUESTION");
                System.out.println(QUESTION);

            }
            resultSet = statement.executeQuery(query_answer2);
            while(resultSet.next()){
                String answer = resultSet.getString("answer");
                System.out.println(answer);
            }
            String answer2 = sc.next();
            String answerInsert2 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('MB01','QS02','AS0"+ answer2 +"');";
            statement.execute(answerInsert2);

            // 3번
            resultSet = statement.executeQuery(query_question3);
            while(resultSet.next()){
                String QUESTION = resultSet.getString("QUESTION");
                System.out.println(QUESTION);

            }
            resultSet = statement.executeQuery(query_answer3);
            while(resultSet.next()){
                String answer = resultSet.getString("answer");
                System.out.println(answer);
            }
            String answer3 = sc.next();
            String answerInsert3 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('MB01','QS03','AS0"+ answer3 +"');";
            statement.execute(answerInsert3);
            // 4번
            resultSet = statement.executeQuery(query_question4);
            while(resultSet.next()){
                String QUESTION = resultSet.getString("QUESTION");
                System.out.println(QUESTION);

            }
            resultSet = statement.executeQuery(query_answer4);
            while(resultSet.next()){
                String answer = resultSet.getString("answer");
                System.out.println(answer);
            }
            String answer4 = sc.next();
            String answerInsert4 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('MB01','QS04','AS0"+ answer4 +"');";
            statement.execute(answerInsert4);
            // 5번
            resultSet = statement.executeQuery(query_question5);
            while(resultSet.next()){
                String QUESTION = resultSet.getString("QUESTION");
                System.out.println(QUESTION);

            }
            resultSet = statement.executeQuery(query_answer5);
            while(resultSet.next()){
                String answer = resultSet.getString("answer");
                System.out.println(answer);
            }
            String answer5 = sc.next();
            String answerInsert5 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('MB01','QS05','AS0"+ answer5 +"');";
            statement.execute(answerInsert5);

            System.out.println("설문 종료");
            sc.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
