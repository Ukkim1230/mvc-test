package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.config.SessionFactory;
import com.web.dto.FoodInfoDTO;

public class FoodInfoRepository {
	public List<FoodInfoDTO> selectFoodInfos(FoodInfoDTO foodInfo) {
		try (SqlSession session = SessionFactory.getSSF().openSession()) {
			return session.selectList("mvc.FoodInfoMapper.selectFoodInfos",foodInfo);
		}
	}
	public FoodInfoDTO selectFoodInfo(int fiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectOne("mvc.FoodInfoMapper.selectFoodInfo",fiNum);
		}
	}
	public int insertFoodInfo(FoodInfoDTO foodInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.insert("mvc.FoodInfoMapper.insertFoodInfo",foodInfo);
		}
	}
	public int updateFoodInfo(FoodInfoDTO foodInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.delete("mvc.FoodInfoMapper.updateFoodInfo",foodInfo);
		}
	}
	public int deleteFoodInfo(int fiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.delete("mvc.FoodInfoMapper.deleteFoodInfo");
		}
	}
	public static void main(String[] args) {
		FoodInfoRepository fiRepo = new FoodInfoRepository();
		List<FoodInfoDTO> foodInfos = fiRepo.selectFoodInfos(null);
		for(FoodInfoDTO foodInfo : foodInfos) {
			System.out.println(foodInfo);
		}
		FoodInfoDTO foodInfo = fiRepo.selectFoodInfo(3);
		System.out.println(foodInfo);
		
		FoodInfoDTO foodInfo2 = new FoodInfoDTO();
		foodInfo2.setFiName("수제비");
		foodInfo2.setFiPrice(8000);
		
		int result = fiRepo.insertFoodInfo(foodInfo2);
		System.out.println("입력 개수 : " +result);
		foodInfo2.setFiNum(112);
		
		result = fiRepo.updateFoodInfo(foodInfo2);
		System.out.println("수정 개수 : " + result);
		
		result = fiRepo.deleteFoodInfo(113);
		System.out.println("삭제 개수 : " + result);
	}
}