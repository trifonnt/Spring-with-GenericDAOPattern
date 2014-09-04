package com.aitrich.bankingwebapp.service;

import java.util.List;

import com.aitrich.bankingwebapp.model.UserAccount;

public interface UserAccountService {
	void saveUserAcoount(UserAccount userAccount);

	UserAccount findUserAcoountById(long id);

	void updateUserAcoount(UserAccount userAccount);

	void deleteUserAcoount(UserAccount userAccount);
	
	List<UserAccount>findAllUserAccount();

}
