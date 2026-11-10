package com.kh.controller;

import java.util.List;

import com.kh.PlantService.PlantService;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantController {
	private PlantService ps = new PlantService();

	public int save(String plantType, String plantName) {
		HousePlantDto hpd = new HousePlantDto(plantType, plantName);
		return ps.save(hpd);
	}

}
