package com.aitrich.bankingwebapp.dto;

public class ColorDTO {

	private String colorCode;

	private String colorName;


	public ColorDTO() {
	}

	public ColorDTO(String code, String name) {
		this.colorCode = code;
		this.colorName = name;
	}

	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
}