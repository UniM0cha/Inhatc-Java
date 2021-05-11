package db.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {

	public static void main(String[] args) {
		//try catch 문으로 클래스 파일이 없을경우를 대비함
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//java.sql 인터페이스 사용
			//접속이 안됐을 경우를 대비하여 이것도 catch문으로 에러 제어
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/temp?",
					"test", "12345678");
			
			
			
			
			
			
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 오류/SQL 오류");
			e.printStackTrace();
		}
	}

}
