package test;

import java.sql.*; // 자바로 SQL을 다루는 클래스들이 들어있는 부분


public class Sample {
	public static void main(String[] args) {
		Connection conn = null;	// java - mysql 통신할 회선 문제가 생길 수 있으므로 try catch
		Statement stmt = null;		// java 측에서 mysql로 보낼 데이터
		ResultSet rs = null;		// mysql 측에서 java로 보낼 데이터
		
		String url = "jdbc:mysql://localhost:3306/sample"; // 통신경로
			
		String id = "root";
		String pw = "iotiot";
		String sql = "select*from student;";
		
		try {
			conn = DriverManager.getConnection(url, id, pw); //회선    java -jdbc -mysql
			
			stmt = conn.createStatement(); //쿼리문을 전달하고 mysql의 방식으로 실행시켜주는 객체
			rs = stmt.executeQuery(sql);	//쿼리문의 실행 결과를 resultset에 저장
			System.out.println("회선연결 확인!");
			//ResultSet.next();
			rs.next();
			String num = rs.getString(1);
			String name =rs.getString(2);
			String kor =rs.getString(3);
			String math =rs.getString(4);
			String eng =rs.getString(5);
			String sum =rs.getString(6);
			System.out.println(num +"\t"+ name+"\t"+kor+"\t"+ math +"\t"+ eng +"\t"+ sum);
			
			rs.next();
			num = rs.getString(1);
			name =rs.getString(2);
			kor =rs.getString(3);
			math =rs.getString(4);
			eng =rs.getString(5);
			sum =rs.getString(6);
			System.out.println(num +"\t"+ name+"\t"+kor+"\t"+ math +"\t"+ eng +"\t"+ sum);
		}catch(Exception e) {
			System.out.println("오류발생 : " + e);
		}
		
		
	}
}
