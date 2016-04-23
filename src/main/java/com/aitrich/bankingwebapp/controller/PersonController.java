package com.aitrich.bankingwebapp.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aitrich.bankingwebapp.dto.ColorDTO;
import com.aitrich.bankingwebapp.dto.GreetingFormDTO;
import com.aitrich.bankingwebapp.model.UserAccount;
import com.aitrich.bankingwebapp.service.UserAccountService;

@Controller
public class PersonController {

	protected static Logger logger = Logger.getLogger(PersonController.class);

	@Autowired
	private UserAccountService userAccountService;


	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String getPage(Model model) {
		logger.info("entering showAddGreetingPage()");

		GreetingFormDTO greeting = new GreetingFormDTO();
		greeting.setGreetingText("HELOO TRIFON");
		ColorDTO red = new ColorDTO("#FF0000", "RED");
		ColorDTO green = new ColorDTO("#00FF00", "GREEN");
		ColorDTO blue = new ColorDTO("#0000FF", "BLUE");
		greeting.addColor(red)
			.addColor(green)
			.addColor(blue);
		
		model.addAttribute("greetingform", greeting);

		return "person";
	}

	@RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
	public String addGreetingAndShowAll(Model model, @ModelAttribute GreetingFormDTO greeting) {
		logger.info("entering addGreetingAndShowAll()");

		UserAccount account = new UserAccount();
		account.setUsername( greeting.getGreetingText() );
		account.setPassword( "1234" );
		account.setCreateddate( new Date() );
		userAccountService.saveUserAcoount( account );

		model.addAttribute("greeting", greeting);

		return "greetings";
	}

	@ModelAttribute("users")
	public List<UserAccount> findAllUserAccount() {
		return userAccountService.findAllUserAccount();
	}
}