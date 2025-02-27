package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.config.SessionFactory;
import com.web.dto.GameInfoDTO;

public class GameInfoRepository {
	public List<GameInfoDTO> selectGameInfos(GameInfoDTO gameInfo) {
		try (SqlSession session = SessionFactory.getSSF().openSession()) {
			return session.selectList("mvc.GameInfoMapper.selectGameInfos", gameInfo);
		}
	}

	public GameInfoDTO selectGameInfo(int giNum) {
		try (SqlSession session = SessionFactory.getSSF().openSession()) {
			return session.selectOne("mvc.GameInfoMapper.selectGameInfo", giNum);
		}
	}

	public int insertGameInfo(GameInfoDTO gameInfo) {
		try (SqlSession session = SessionFactory.getSSF().openSession(true)) {
			return session.insert("mvc.GameInfoMapper.insertGameInfo", gameInfo);
		}
	}

	public int updateGameInfo(GameInfoDTO gameInfo) {
		try (SqlSession session = SessionFactory.getSSF().openSession(true)) {
			return session.update("mvc.GameInfoMapper.updateGameInfo", gameInfo);
		}
	}

	public int deleteGameInfo(int giNum) {
		try (SqlSession session = SessionFactory.getSSF().openSession(true)) {
			return session.delete("mvc.GameInfoMapper.deleteGameInfo", giNum);
		}
	}

	public static void main(String[] args) {
		GameInfoRepository giRepo = new GameInfoRepository();
		List<GameInfoDTO> gameInfos = giRepo.selectGameInfos(null);
		for (GameInfoDTO gameInfo : gameInfos) {
			System.out.println(gameInfo);
		}
		GameInfoDTO gameInfo = giRepo.selectGameInfo(14);
		System.out.println(gameInfo);

		GameInfoDTO gameInfo2 = new GameInfoDTO();
		gameInfo2.setGiName("배틀그라운드");
		gameInfo2.setGiPrice(0);
		gameInfo2.setGiGenre("슈팅");
		gameInfo2.setGiDesc("꿀잼");

		int result = giRepo.insertGameInfo(gameInfo2);
		System.out.println("입력 개수 : " + result);
		gameInfo2.setGiNum(3);

		result = giRepo.updateGameInfo(gameInfo2);
		System.out.println("수정 개수 : " + result);

		result = giRepo.deleteGameInfo(11);
		System.out.println("삭제 개수 : " + result);
	}
}