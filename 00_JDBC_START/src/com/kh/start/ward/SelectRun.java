package com.kh.start.ward;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // 조회되는 행들의 집합이 <ResultSet>

		// 내가 조회하려고 하는 행이 2행 이상이다? 무조건 ORDER BY 들어가야됨.
		String sql = """
				SELECT
					   COFFEE_NO
					 , COFFEE_NAME
					 , COFFEE_DATE
				  FROM
				  	   COFFEE
				 ORDER
				    BY
				       COFFEE_DATE DESC
				""";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");

			// connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1",
												"HOSPITAL",
												"oracle");
			System.out.println("DB 연결 성공!");

			stmt = conn.createStatement();
			System.out.println("Statement객체 생성!");

			rset = stmt.executeQuery(sql);
			// rset.next(): 커서를 조작
			while (rset.next()) {
				// 커서를 조작했을때 행이 있으면 true 없으면 false
				int coffeeNo = rset.getInt("COFFEE_NO");
				String coffeeName = rset.getString("COFFEE_NAME");
				Date createDate = rset.getDate("COFFEE_DATE");

				System.out.println("커피 번호 : " + coffeeNo + "커피 이름 : " + coffeeName + "커피 만든날: " + createDate);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
