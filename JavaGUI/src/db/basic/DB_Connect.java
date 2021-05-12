package db.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connect {

	public static void main(String[] args) {
		//try catch 문으로 클래스 파일이 없을경우를 대비함
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OK");
			
			//java.sql 인터페이스 사용
			//접속이 안됐을 경우를 대비하여 이것도 catch문으로 에러 제어
			// mysql을 사용할 때
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/temp?",
//					"test", "12345678");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"test", "1111");
			
			Statement stmt = conn.createStatement();
			
			
			String aa = "A003";
			String bb = "33";
			String cc = "우다다다다";
			int dd = 30;
			String sql = "INSERT INTO MEMBER VALUES('" + aa + "', '" + bb + "', '" + cc +"', '" + dd + "')";
			stmt.executeUpdate(sql);
			
//			String sql = "INSERT INTO MEMBER VALUES('" + aa + "', '" + bb + "', '" + cc +"', '" + dd + "')";
			sql = "Update member set name = '" + cc + "' where ID='" + aa + "'";
			
			stmt.executeUpdate(sql);
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER");  // SQL문을 실행할 때 사용
			
			// rs는 한줄을 불러오는 것 (한 행)			
			while(rs.next()) {
				String id = rs.getString("ID");
				String pw = rs.getString(2);  //데이터베이스는 1번부터 인덱싱을 한다. 고정관념 타파.
				String name = rs.getString("name");  //대소문자 구별하지 않는다.
				String age = rs.getString("age");
				
//				System.out.println(id);
//				System.out.println(pw);
//				System.out.println(name);
				
				System.out.println(id + "\t" + pw + "\t" + name + "\t" + age);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 오류/SQL 오류");
			e.printStackTrace();
		}
	}

}
