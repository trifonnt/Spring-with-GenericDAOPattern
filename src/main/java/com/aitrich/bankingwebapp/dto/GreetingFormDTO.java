package com.aitrich.bankingwebapp.dto;

import java.util.ArrayList;
import java.util.List;

public class GreetingFormDTO {

	private String greetingText;

	private String selectedColorCode;

	private List<ColorDTO> colorList;


	public GreetingFormDTO() {
		colorList = new ArrayList<ColorDTO>();
	}

	public String getGreetingText() {
		return greetingText;
	}
	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}

	public GreetingFormDTO addColor(ColorDTO color) {
		colorList.add( color );
		return this;
	}
	public List<ColorDTO> getColorList() {
		return colorList;
	}
	public void setColorList(List<ColorDTO> colorList) {
		this.colorList = colorList;
	}

	public String getSelectedColorCode() {
		return selectedColorCode;
	}
	public void setSelectedColorCode(String colorCode) {
		this.selectedColorCode = colorCode;
	}
}