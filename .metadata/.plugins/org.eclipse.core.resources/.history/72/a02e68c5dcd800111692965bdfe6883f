package com.kh.plant.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JdbcTemplate;
import com.kh.plant.model.dto.HousePlantDto;

public class Plantdao {
	private Properties prop	 = new Properties();
	
	public Plantdao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/houseplant-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int save(Connection conn, HousePlantDto hpd) {
		
		int result = 0;
		
		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("resources/houseplant-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("save"));
		
		String sql = prop.getProperty("save");
				
		try (PreparedStatement ptsmt = conn.prepareStatement(sql)) {
			ptsmt.setString(1, hpd.getPlantType());
			ptsmt.setString(2, hpd.getPlantName());
			result = ptsmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<HousePlantDto> view(Connection conn) {
		List<HousePlantDto> plants = new ArrayList();
		//Properties prop = new Properties();
		//prop.loadFromXML();
		
		String sql = prop.getProperty("view");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
			// ResultSet이 오긴 왔는데 조회결과가 있을수도~ 없을수도 있다.
			while(rset.next()){
				plants.add(new HousePlantDto(
											   rset.getInt("PLANT_NO")
											 , rset.getString("PLANT_TYPE")
											 , rset.getString("PLANT_NAME")));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return plants;
	}
	
	public int edit(Connection conn, HousePlantDto hpd){
		int result = 0;
		String sql = prop.getProperty("edit");// 인자로 스트링타입의 메서드명을 작성
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, hpd.getPlantName());
			pstmt.setString(2, hpd.getPlantType());
			pstmt.setInt(3, hpd.getPlantNo());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(Connection conn, int plantNo) {
		int result = 0;
		String sql = prop.getProperty("delete");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, plantNo);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*
	 * PreparedStatement = sql문을 미리 전달하는 개념
	 * 					   미완성된 SQL문을 미리 전달한 뒤 실행가지너 
	 * 					   실제 값을 바인딩해서 실행(묶어서)
	 * 						전달 시 SQL문에 사용자가 입력한 값이 들어갈 수 있도록 공간 확보 (?) 사용
	 * 
	 * - 차이점
	 * Statement - SQL문이 완성형으로 전달되야함.
	 * PreparedStatement -  미완성 SQL문으로 전달	
	 * 
	 * conn.createStatement() / conn.preparedStatement(인자로 SQL문을 미리 전달
	 *  
	 * setString(홀더순번, 실제 바인딩된 값) 홑따옴표('') 처리를 알아서 해준다.
	 * setInt(홀더순번, 바인딩 된 값)
	 * 
	 * PreparedStatement 가 좋은점
	 * 
	 * 1. 구문분석 및 컴파일 최적화
	 * Statement는 매번 SQL문을 파싱하고 실행하는데 Prepared는 SQL쿼리를 최초 1회만 파싱하고 실행
	 * 재사용적인 측면에서 효율적.
	 * 
	 * 2. DB서버에 대한 트래픽 감소
	 * 
	 * 쿼리 자체는 한 번만 전송하고 이후에는 바인딩할 값만 보내기 때문에
	 * 동일 쿼리를 반복 실행할 때, 인기많은 애플리케이션일때 더욱더 효율적임.
	 * 
	 *DB의 작업 -> 실행 계획 세울 때 리소스를 많이 잡아먹음.
	 * 
	 * 
	 */
	
	
	
	

}
