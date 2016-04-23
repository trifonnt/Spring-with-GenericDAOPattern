package com.aitrich.bankingwebapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aitrich.bankingwebapp.model.UserAccount;
import com.aitrich.bankingwebapp.service.UserAccountService;

@Controller
public class PersonController {

	protected static Logger logger = Logger.getLogger("PersonController");

	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String getPage() {
		logger.info("entering showAddGreetingPage()");

	

		return "person";

	}

	@RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
	public String addGreetingAndShowAll() {
		UserAccount account = new UserAccount();
		account.setUsername("fdsf");
		account.setPassword("fd");
		userAccountService.saveUserAcoount(account);
		logger.info("entering addGreetingAndShowAll()");

	
	
		return "greetings";
	}

	@ModelAttribute("users")
	public List<UserAccount> findAllUserAccount() {
		return userAccountService.findAllUserAccount();
	}

}
