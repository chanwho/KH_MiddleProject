import java.sql.Statement;

public class Statics {
    public void StaticsFunction(Statement statement){
// 로그인한 사람의 USER_UID로 AUTHOR_UID 확인
        String m1 = "GUEST";
        String m2 = "ADMIN";
        String a_USER_UID = m1;
        String b_USER_UID = m2;
// GUSET일 경우 통계조회 화면입니다 출력
        System.out.println("a유저님 통계조회 화면입니다.");
// QUESTION_ANSWER에서 JOIN을 하고
        String query = "QUESTION_ANSWER INNER JOIN users(UNIQUE_ID, NAME, EMAIL, JOB)"+
        "VALUE ('U8','eun','wefwwwe@wef','IT')";
// USER_UID가 일치하는 raw에 COUNT로 갯수를 출력
// ADMIN일 경우 1. 설문자별 답변결과, 2.질문별 총답변수 출력
        System.out.println("b유저님 \n 1. 설문자별 답변결과, 2.질문별 총답변수");
// 1을 입력받을시에 설문자별로 질문에 무슨 답을 했는지 화면에 출력
// 2를 입력받을시에는 질문별로 답이 몇개인지 COUNT로 갯수 출력
// 다 출력한다음 설문화면으로 넘어감


    }
}
