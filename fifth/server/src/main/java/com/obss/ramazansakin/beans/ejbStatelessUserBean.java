package com.obss.ramazansakin.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.obss.ramazansakin.model.Users;

@Stateless
public class ejbStatelessUserBean implements ejbStatelessUserBeanRemote {

	@PersistenceContext(unitName = "JPADB")
    private EntityManager entityManager;

	public Users getUserByName(String username) {
		return entityManager.find(Users.class, username);
	}

	public void updateUser(Users u) {
		entityManager.merge(u);
	}
   

}
