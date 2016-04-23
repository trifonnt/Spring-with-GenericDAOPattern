package com.aitrich.bankingwebapp.dao;

import org.springframework.stereotype.Repository;

import com.aitrich.bankingwebapp.model.UserAccount;

@Repository("userAccountDAO")
public class UserAccountDaoImpl
	extends GenericDAOImpl<UserAccount, Long>
	implements UserAcoountDao 
{

	private static final long serialVersionUID = 1L;

}