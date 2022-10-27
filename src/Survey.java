import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Survey {
    public void SurveyFunction(Statement statement, String Main_user_number){
        String user_number = Main_user_number;
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
            System.out.print("답 : ");
            String answer1 = sc.next();
            System.out.println();
            String answerInsert1 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('"+ user_number +"','QS01','AS0"+ answer1 +"');";
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
            ArrayList<String> prob2 = new ArrayList<>();
            prob2.add("AS04");
            prob2.add("AS05");
            prob2.add("AS06");
            prob2.add("AS07");
            prob2.add("AS08");
            System.out.print("답 : ");
            String answer2 = sc.next();
            System.out.println();
            int Prob2_index = Integer.parseInt(answer2)-1;
            String answerInsert2 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('"+ user_number +"','QS02','"+ prob2.get(Prob2_index) +"');";
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
            System.out.print("답 : ");
            String answer3 = sc.next();
            System.out.println();
            ArrayList<String> prob3 = new ArrayList<>();
            prob3.add("AS09");
            prob3.add("AS10");
            prob3.add("AS11");
            prob3.add("AS12");
            prob3.add("AS13");
            int Prob3_index = Integer.parseInt(answer3)-1;
            String answerInsert3 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('"+ user_number +"','QS03','"+ prob3.get(Prob3_index) +"');";
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
            System.out.print("답 : ");
            String answer4 = sc.next();
            System.out.println();
            ArrayList<String> prob4 = new ArrayList<>();
            prob4.add("AS14");
            prob4.add("AS15");
            prob4.add("AS16");
            prob4.add("AS17");
            prob4.add("AS18");
            int Prob4_index = Integer.parseInt(answer4)-1;
            String answerInsert4 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('"+ user_number +"','QS04','"+ prob4.get(Prob4_index) +"');";
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
            System.out.print("답 : ");
            String answer5 = sc.next();
            System.out.println();
            ArrayList<String> prob5 = new ArrayList<>();
            prob5.add("AS19");
            prob5.add("AS20");
            prob5.add("AS21");
            prob5.add("AS22");
            prob5.add("AS23");
            int Prob5_index = Integer.parseInt(answer5)-1;
            String answerInsert5 = "insert into question_answer(user_uid, question_uid, answer_uid) value ('"+ user_number +"','QS05','"+ prob5.get(Prob5_index) +"');";
            statement.execute(answerInsert5);

            System.out.println("--------------설문 종료--------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
