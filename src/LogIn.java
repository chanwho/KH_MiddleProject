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
        String user_number = "";

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");
        System.out.println("로그인 화면입니다.\n아이디와 비밀번호를 입력해주세요.");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");

        // 아이디와 비밀번호 받기
        try {
            do {
                ID = sc.nextLine();
                PW = sc.nextLine();

                // 아이디와 비밀번호 비교
                query = "SELECT * FROM user WHERE ID = '" + ID + "';";
                resultSet = statement.executeQuery(query);

                if (!resultSet.isBeforeFirst()) {
                    System.out.println("일치하는 아이디가 없습니다. \n아이디와 비밀번호를 입력해주세요.");
                } else {
                    query = "SELECT * FROM user WHERE ID = '" + ID + "' AND PW = '" + PW + "'";
                    resultSet = statement.executeQuery(query);
                    if (!resultSet.isBeforeFirst()) {
                        System.out.println("잘못된 비밀번호입니다. \n아이디와 비밀번호를 입력해주세요.");
                    } 
                }
            } while (!resultSet.isBeforeFirst());
            
            while (resultSet.next()) {
                String user_uid = resultSet.getString("USER_UID");
                String user_id = resultSet.getString("ID");
                String user_author = resultSet.getString("AUTHOR_UID");
                System.out.println(user_id + "님 " + user_author + " 권한으로 로그인합니다.");
                user_number = user_uid;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user_number;
    }

    // 일치하면 유저 이름 및 권한 출력
    // 불일치시 재 로그인 요청(반복)

}
