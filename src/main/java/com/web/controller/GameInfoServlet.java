package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dto.GameInfoDTO;
import com.web.service.GameInfoService;


public class GameInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameInfoService giService = new GameInfoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<GameInfoDTO> gameInfos = giService.getGameInfos(null);
		out.print("<table border = '1'>");
		out.print("<tr>");
		out.print("<th>번호</th>");
		out.print("<th>게임이름</th>");
		out.print("<th>게임가격</th>");
		out.print("<th>장르</th>");
		out.print("<th>평가</th>");
		out.print("</tr>");
		for(int i=0;i<gameInfos.size();i++) {
			GameInfoDTO gameInfo = gameInfos.get(i);
		out.print("<tr>");
		out.print("<th>" + gameInfo.getGiNum()+ "</th>");
		out.print("<th>" + gameInfo.getGiName()+ "</th>");
		out.print("<th>" + gameInfo.getGiPrice()+ "</th>");
		out.print("<th>" + gameInfo.getGiGenre()+ "</th>");
		out.print("<th>" + gameInfo.getGiDesc()+ "</th>");
		out.print("</tr>");
		}
		out.print("</table>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
