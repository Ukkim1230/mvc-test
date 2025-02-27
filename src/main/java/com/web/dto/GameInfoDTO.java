package com.web.dto;

public class GameInfoDTO {
	private int giNum;
	private String giName;
	private	int giPrice;
	private String giGenre;
	private String giDesc;
	public int getGiNum() {
		return giNum;
	}
	public void setGiNum(int giNum) {
		this.giNum = giNum;
	}
	public String getGiName() {
		return giName;
	}
	@Override
	public String toString() {
		return "GameInfoDTO [giNum=" + giNum + ", giName=" + giName + ", giPrice=" + giPrice + ", giGenre=" + giGenre
				+ ", giDesc=" + giDesc + "]";
	}
	public void setGiName(String giName) {
		this.giName = giName;
	}
	public int getGiPrice() {
		return giPrice;
	}
	public void setGiPrice(int giPrice) {
		this.giPrice = giPrice;
	}
	public String getGiGenre() {
		return giGenre;
	}
	public void setGiGenre(String giGenre) {
		this.giGenre = giGenre;
	}
	public String getGiDesc() {
		return giDesc;
	}
	public void setGiDesc(String giDesc) {
		this.giDesc = giDesc;
	}
}
