package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileInputStream;

public class BoardInsertExample {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            
            //연결하기
            conn = DriverManager.getConnection(
            		"jdbc:oracle:thin:@localhost:1521/XE", 
                    "c##human", 
                    "human"
            );    
            
            //매개변수화된 SQL문 작성
            //bno : ?, ~~~
            //bdate : SYSDATE
            String sql = "" +
                "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
                "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";
            
            //PreparedStatement 얻기 및 값 지정
            //conn.prepareStatement(sql, new String[] {"bno"});
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});

            pstmt.setString(1, "크리스마스");
            pstmt.setString(2, "메리크리스마스");
            pstmt.setString(3, "winter");
            pstmt.setString(4, "chrismas.jpg");
            pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec06/chrismas.jpg"));
                   

            pstmt.setString(1, "눈오는 날");
            pstmt.setString(2, "함박눈이 내려요.");
            pstmt.setString(3, "winter");
            pstmt.setString(4, "snow.jpg");

            pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec06/snow.jpg"));
            
            pstmt.setString(1, "봄의 정원");
            pstmt.setString(2, "정원의 꽃");
            pstmt.setString(3, "winter");
            pstmt.setString(4, "spring.jpg");
            pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec06/spring.jpg"));
            

            //파일경로
            pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec06/snow.jpg"));
            
            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수: " + rows);
            
            //bno 값 얻기
            if(rows == 1) {
            	ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()) {
                	int bno = rs.getInt(1);          // 인덱스로 접근해야 함
                    System.out.println("저장된 bno: " + bno);
                }
                rs.close();
            }
            
            //PreparedStatement 닫기
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try { 
                    //연결 끊기
                    conn.close(); 
                } catch (SQLException e) {}
            }
        }
    }

}
