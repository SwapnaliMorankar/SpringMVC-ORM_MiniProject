package spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.Model.User;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	@Transactional
	public int saveUser(User user) {
		int result = (Integer) this.hibernatetemplate.save(user);
		return result;
	}
	

}
