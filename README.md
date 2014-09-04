Spring-with-GenericPattern
==========================

A sample spring mvc-Hibernate with GenericDao implementaion.
It is best practice to use generic pattern in dao pattern.So using this pattern we don't want to write same functions like save(),update()
etc on our project.
Simply reuse the code.


For example specify gerericDao interface and implementation with session factory.
After that extend the gerericDao with dao interface.

public interface UserAcoountDao  extends GenericDAO<UserAccount, Long>{}

Next implement the  GenericDAOImpl with dao implementation.

@Repository("userAccountDAO")
public class UserAccountDaoImpl extends GenericDAOImpl<UserAccount, Long> implements UserAcoountDao {}
	

	


