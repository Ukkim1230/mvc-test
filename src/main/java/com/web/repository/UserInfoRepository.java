package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.config.SessionFactory;
import com.web.dto.UserInfoDTO;

public class UserInfoRepository {
	
	public List<UserInfoDTO> selectUserInfos(UserInfoDTO userInfo){
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectList("mvc.UserInfoMapper.selectUserInfos", userInfo);
		}
	}
	
	public UserInfoDTO selectUserInfo(int uiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectOne("mvc.UserInfoMapper.selectUserInfo",uiNum);
		}
	}
	public static void main(String[] args) {
		UserInfoRepository uiRepo = new UserInfoRepository();
		List<UserInfoDTO> userInfos = uiRepo.selectUserInfos(null);
		System.out.println(userInfos);
	}

}
