import java.util.Scanner;
import java.sql.*;

public class LogIn {
    // 로그인화면구성
    public String LoginFunction(Statement statement) {
        Scanner sc = new Scanner(System.in);
        String ID = "";
        String PW = "";
        String query = "";
        ResultSet resultSet;
        String user_uid = "";
        String user_id = "";
        String user_author = "";

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");
        System.out.println("로그인 화면입니다.\n아이디와 비밀번호를 입력해주세요.");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");

                try {
                    do {
                // 아이디와 비밀번호 받기
                System.out.print("ID) ");
                ID = sc.nextLine();
                System.out.print("PW) ");
                PW = sc.nextLine();
                System.out.println();

                // 아이디 비교
                query = "SELECT * FROM user WHERE ID = '" + ID + "';";
                resultSet = statement.executeQuery(query);

                if (!resultSet.isBeforeFirst()) {
                    System.out.println("일치하는 아이디가 없습니다. \n아이디와 비밀번호를 입력해주세요.\n");
                } else {
                    // 아이디가 있는 경우, 아이디와 비밀번호가 일치하는지 확인
                    query = "SELECT * FROM user WHERE ID = '" + ID + "' AND PW = '" + PW + "'";
                    resultSet = statement.executeQuery(query);
                    if (!resultSet.isBeforeFirst()) {
                        System.out.println("잘못된 비밀번호입니다. \n아이디와 비밀번호를 입력해주세요.\n");
                    } 
                }
            } while (!resultSet.isBeforeFirst());

            // 아이디, 비밀번호 모두 일치하는 경우 아이디, 권한 출력하며 로그인

            while (resultSet.next()) {
                user_uid = resultSet.getString("USER_UID");
                user_id = resultSet.getString("ID");
            }
            query = "SELECT author.AUTHOR FROM user INNER JOIN author ON user.AUTHOR_UID = author.AUTHOR_UID AND USER_UID = '" + user_uid + "';";
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                user_author = resultSet.getString("AUTHOR");
            }
            
            System.out.println(user_id + "님 [" + user_author + "] 권한으로 로그인합니다.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user_uid;
    }

}
