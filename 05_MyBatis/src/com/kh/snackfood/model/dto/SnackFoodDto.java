package com.kh.snackfood.model.dto;

import java.util.ArrayList;
import java.util.List;

// 존재의의 = 데이터 전달, 타입 안정성 확보, 그리고 시스템의 확장성을 고려
public class SnackFoodDto {
	private Integer foodNo;
	private String foodName;
	private Integer price;
	private String category;
	private List<FoodReviewDto> reviews = new ArrayList<>();

	public List<FoodReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<FoodReviewDto> reviews) {
		this.reviews = reviews;
	}

	public SnackFoodDto() {
	}

	public SnackFoodDto(Integer foodNo, String foodName, Integer price, String category) {
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.price = price;
		this.category = category;
	}

	public Integer getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(Integer foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SnackFoodDto [foodNo=" + foodNo + ", foodName=" + foodName + ", price=" + price + ", category="
				+ category + "]";
	}

}
