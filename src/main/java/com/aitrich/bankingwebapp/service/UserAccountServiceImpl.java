package com.aitrich.bankingwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitrich.bankingwebapp.dao.UserAcoountDao;
import com.aitrich.bankingwebapp.model.UserAccount;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {
	@Autowired
	private UserAcoountDao userAccountDao;

	@Transactional
	public void saveUserAcoount(UserAccount userAccount) {
		userAccountDao.save(userAccount);
	}

	@Transactional
	public UserAccount findUserAcoountById(long id) {

		return userAccountDao.findByPrimaryKey(id);
	}

	@Transactional
	public void updateUserAcoount(UserAccount userAccount) {
		userAccountDao.update(userAccount);
	}

	@Transactional
	public void deleteUserAcoount(UserAccount userAccount) {
		userAccountDao.delete(userAccount);
	}

	public List<UserAccount> findAllUserAccount() {
		
		return userAccountDao.findAll();
	}
	

}
