import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statics {
public void StaticsFunction(Statement statement){
        // 로그인한 사람의 USER_UID로 AUTHOR_UID 확인
        String query = "SELECT USER.ID, AUTHOR.AUTHOR FROM AUTHOR INNER JOIN USER ON USER.AUTHOR_UID = AUTHOR.AUTHOR_UID AND USER.USER_UID = 'MB01'";
        String query1 = "SELECT QUESTION_UID, COUNT(ANSWER_UID), ANSWER_UID FROM QUESTION_ANSWER GROUP BY ANSWER_UID, QUESTION_UID";
        String query2 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS02' group by ANSWER_UID";
        String query3 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS03' group by ANSWER_UID";
        String query4 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS04' group by ANSWER_UID";
        String query5 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS05' group by ANSWER_UID";
        String query6 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS06' group by ANSWER_UID";
        String query7 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS07' group by ANSWER_UID";
        String query8 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS08' group by ANSWER_UID";
        String query9 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS09' group by ANSWER_UID";
        String query10 = "SELECT COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID='AS10' group by ANSWER_UID";
        
        ResultSet resultSet;
        try {
        String userAuthor= "";
        String id= "";
        resultSet = statement.executeQuery(query);
        
        

        while(resultSet.next()){
        String ID = resultSet.getString("ID");
        String AUTHOR = resultSet.getString("AUTHOR");
        if(AUTHOR.equals("GUEST")) userAuthor="GUEST";  // 전역변수에 넣어준다
        else if(AUTHOR.equals("ADMIN")) userAuthor= "ADMIN";
        id = ID;
        }
        // GUSET일 경우
        if(userAuthor.equals("GUEST")){
                System.out.println(id+"회원님 통계조회 화면입니다.");
                System.out.println("회원님이 참여하신 설문을 조회합니다.\n"+
                "질문(1)  질문(2)  질문(3)  질문(4)  질문(5)");


                // QUESTION_ANSWER에서 JOIN을 하고
                        // query = "QUESTION_ANSWER INNER JOIN users(UNIQUE_ID, NAME, EMAIL, JOB)"+
                        // "VALUE ('U8','eun','wefwwwe@wef','IT')";
                    // USER_UID가 일치하는 raw에 COUNT로 갯수를 출력
        }       
        //     ADMIN일 경우
        else if(userAuthor.equals("ADMIN")){
                System.out.println(id+"회원님 \n 1. 설문자별 답변결과, 2.질문별 총답변수");
                resultSet = statement.executeQuery(query1);
                while(resultSet.next()){
                String C1 = resultSet.getString("COUNT(QUESTION_ANSWER.ANSWER_UID)");
                System.out.println("       답(1)  답(2)  답(3)  답(4)  답(5)");
                System.out.println("질문(1)"+C1);
                break;
                // System.out.println("질문(2)"+qs02);
                // System.out.println("질문(3)"+qs03);
                // System.out.println("질문(4)"+qs04);
                // System.out.println("질문(5)");
                // if(ANSWER_QUESTION_UID.equals("QS01")){qs01 =Integer.parseInt(COUNT_ANSWER_UID);}
                // if(ANSWER_QUESTION_UID.equals("QS02")){qs02 =Integer.parseInt(COUNT_ANSWER_UID);}
                // if(ANSWER_QUESTION_UID.equals("QS03")){qs03 =Integer.parseInt(COUNT_ANSWER_UID);}
                // if(ANSWER_QUESTION_UID.equals("QS04")){qs04 =Integer.parseInt(COUNT_ANSWER_UID);}
                // if(ANSWER_QUESTION_UID.equals("QS05")){qs05 =Integer.parseInt(COUNT_ANSWER_UID);}
                }



        //             // 1을 입력받을시에 설문자별로 질문에 무슨 답을 했는지 화면에 출력
        //             // 2를 입력받을시에는 질문별로 답이 몇개인지 COUNT로 갯수 출력
        //             // 다 출력한다음 설문화면으로 넘어감
        //                 //4,9,14,19
        //                 //5,10,15,20
        //                 //6,11,16,21
        //                 //7,12,17,22
        //                 //8,13,18,23
         }
        
        } catch (SQLException e) {
                e.printStackTrace();
        }

        }
}
