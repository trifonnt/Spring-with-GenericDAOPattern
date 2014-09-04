package com.aitrich.bankingwebapp.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aitrich.bankingwebapp.model.UserAccount;

@Repository("userAccountDAO")
public class UserAccountDaoImpl extends GenericDAOImpl<UserAccount, Long> implements UserAcoountDao {
	@Autowired
	private SessionFactory sessionFactory;

	


}
