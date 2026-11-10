package com.kh.PlantService;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JdbcTemplate;
import com.kh.plant.model.dao.Plantdao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	
	public int save(HousePlantDto hpd) {
		Connection conn = JdbcTemplate.getConnection();
		int result = new Plantdao().save(conn, hpd);
		JdbcTemplate.close(conn);
		return result;
	}
	public List<HousePlantDto> view() {
		// 1. 커넥션 객체 받아오기 커넥션은 필요할 때 쓰고 다 끝나면 바로바로 반납해줘야됨. 
		Connection conn = JdbcTemplate.getConnection();
		// 2. 컨트롤러로부터 전달받은 인자값과 커넥션 타입의 객체를 DAO로 전달
		List<HousePlantDto> plants = new Plantdao().view(conn);
		// 3. connection 자원 반납
		JdbcTemplate.close(conn);
		// 4. 결과값 반환
		return plants;
	}
	public int delete(int plantNo) {
		if(plantNo < 1) {
			throw new RuntimeException("식물 번호는 1보다 작을 수 없습니다.");
		}
		Connection conn = JdbcTemplate.getConnection();
		int result = new Plantdao().delete(conn, plantNo);
		JdbcTemplate.close(conn);
		return result;
		
	}
	

}
