import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Statics {
public void StaticsFunction(Statement statement, String user_number){
        Scanner input = new Scanner(System.in);
        // 로그인한 사람의 USER_UID로 AUTHOR_UID 확인
        String query = "SELECT USER.ID, AUTHOR.AUTHOR FROM AUTHOR INNER JOIN USER ON USER.AUTHOR_UID = AUTHOR.AUTHOR_UID AND USER.USER_UID = '"+user_number+"'";        
        String query1 = "SELECT ANSWER.ANSWER_UID, ANSWER.ANSWER FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE QUESTION_ANSWER.USER_UID = 'MB01'";
        String query2 = "SELECT ANSWER.ANSWER_UID, ANSWER.ANSWER FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE QUESTION_ANSWER.USER_UID = 'MB02'";
        String query3 = "SELECT ANSWER.ANSWER_UID, ANSWER.ANSWER FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE QUESTION_ANSWER.USER_UID = 'MB03'";
        String query4 = "SELECT ANSWER.ANSWER_UID, ANSWER.ANSWER FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE QUESTION_ANSWER.USER_UID = 'MB04'";
        String query5 = "SELECT ANSWER.ANSWER_UID, ANSWER.ANSWER FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE QUESTION_ANSWER.USER_UID = 'MB05'";
        String query6 = "SELECT QUESTION_ANSWER.QUESTION_UID, COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID between 'AS01' AND 'AS03' GROUP BY ANSWER_UID";
        String query7 = "SELECT QUESTION_ANSWER.QUESTION_UID, COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID between 'AS04' AND 'AS08' GROUP BY ANSWER_UID";
        String query8 = "SELECT QUESTION_ANSWER.QUESTION_UID, COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID between 'AS09' AND 'AS13' GROUP BY ANSWER_UID";
        String query9 = "SELECT QUESTION_ANSWER.QUESTION_UID, COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID between 'AS14' AND 'AS18' GROUP BY ANSWER_UID";
        String query10 = "SELECT QUESTION_ANSWER.QUESTION_UID, COUNT(QUESTION_ANSWER.ANSWER_UID), ANSWER.ANSWER_UID FROM QUESTION_ANSWER RIGHT JOIN ANSWER ON QUESTION_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE ANSWER.ANSWER_UID between 'AS19' AND 'AS23' GROUP BY ANSWER_UID";
        ResultSet resultSet;
        
        String userAuthor= "";
        String id= "";
        try {
        resultSet = statement.executeQuery(query);              
        while(resultSet.next()){
        String ID = resultSet.getString("ID");
        String AUTHOR = resultSet.getString("AUTHOR");
        if(AUTHOR.equals("GUEST")) userAuthor="GUEST";  // 전역변수(id, userAuthor)에 넣어준다
        else if(AUTHOR.equals("ADMIN")) userAuthor= "ADMIN";
        id = ID;
        }
        // GUSET일 경우
        if(userAuthor.equals("GUEST")){
                System.out.println(id+"회원님 통계조회 화면입니다.");
                System.out.println("회원님이 참여하신 설문을 조회합니다.\n"+
                "    질문(1) 질문(2) 질문(3) 질문(4) 질문(5)");
                // user_number에 따라 해당 query 선택
                switch(user_number){
                        case "MB02" : resultSet = statement.executeQuery(query2);
                        break;
                        case "MB03" : resultSet = statement.executeQuery(query3);
                        break;
                        case "MB04" : resultSet = statement.executeQuery(query4);
                        break;
                        case "MB05" : resultSet = statement.executeQuery(query5);
                        break;
                }
                while(resultSet.next()){
                        String C2 = resultSet.getString("ANSWER.ANSWER");
                        System.out.print("       "+C2.substring(1, 2));
                }
                System.out.println();               
        }       
        //     ADMIN일 경우
        else if(userAuthor.equals("ADMIN")){
                System.out.println(id+"회원님 \n 1. 설문자별 답변결과, 2.질문별 총답변수");
                int a = Integer.parseInt(input.nextLine());
                if(a == 1){
                        System.out.println("             질문(1) 질문(2) 질문(3) 질문(4) 질문(5)");
                        System.out.print("설문자(1)");
                        resultSet = statement.executeQuery(query1);
                        while(resultSet.next()){
                                String C1 = resultSet.getString("ANSWER.ANSWER");
                                System.out.print("       "+C1.substring(1, 2));
                        }
                        System.out.print("\n설문자(2)");
                        resultSet = statement.executeQuery(query2);
                        while(resultSet.next()){
                                String C2 = resultSet.getString("ANSWER.ANSWER");
                                System.out.print("       "+C2.substring(1, 2));
                        }
                        System.out.print("\n설문자(3)");
                        resultSet = statement.executeQuery(query3);
                        while(resultSet.next()){
                                String C3 = resultSet.getString("ANSWER.ANSWER");
                                System.out.print("       "+C3.substring(1, 2));
                        }
                        System.out.print("\n설문자(4)");
                        resultSet = statement.executeQuery(query4);
                        while(resultSet.next()){
                                String C4 = resultSet.getString("ANSWER.ANSWER");
                                System.out.print("       "+C4.substring(1, 2));
                        }
                        System.out.print("\n설문자(5)");
                        resultSet = statement.executeQuery(query5);
                        while(resultSet.next()){
                                String C5 = resultSet.getString("ANSWER.ANSWER");
                                System.out.print("       "+C5.substring(1, 2));
                        }
                        System.out.println("");

                } else if(a == 2){
                System.out.println("       답(1) 답(2) 답(3) 답(4) 답(5)");
                System.out.print("질문(1)");
                resultSet = statement.executeQuery(query6);
                while(resultSet.next()){
                        String C6 = resultSet.getString("COUNT(QUESTION_ANSWER.ANSWER_UID)");
                        System.out.print("    "+C6);
                }
                System.out.print("\n질문(2)");
                resultSet = statement.executeQuery(query7);
                while(resultSet.next()){
                        String C7 = resultSet.getString("COUNT(QUESTION_ANSWER.ANSWER_UID)");
                        System.out.print("    "+C7);
                }
                System.out.print("\n질문(3)");
                resultSet = statement.executeQuery(query8);
                while(resultSet.next()){
                        String C8 = resultSet.getString("COUNT(QUESTION_ANSWER.ANSWER_UID)");
                        System.out.print("    "+C8);
                }
                System.out.print("\n질문(4)");
                resultSet = statement.executeQuery(query9);
                while(resultSet.next()){
                        String C9 = resultSet.getString("COUNT(QUESTION_ANSWER.ANSWER_UID)");
                        System.out.print("    "+C9);
                }
                System.out.print("\n질문(5)");
                resultSet = statement.executeQuery(query10);
                while(resultSet.next()){
                        String C10 = resultSet.getString("COUNT(QUESTION_ANSWER.ANSWER_UID)");
                        System.out.print("    "+C10);
                }
                System.out.println();
        }
        }       
        } catch (SQLException e) {
                e.printStackTrace();
        }
        }
}
