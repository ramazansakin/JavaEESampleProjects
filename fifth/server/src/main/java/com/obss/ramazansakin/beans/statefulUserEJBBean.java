package com.obss.ramazansakin.beans;

import javax.ejb.Stateful;
import com.obss.ramazansakin.model.Users;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class statefulUserEJBBean implements statefulUserEJBBeanRemote {

	@PersistenceContext(unitName = "JPADB")
    private EntityManager entityManager;

    public statefulUserEJBBean() {
    }

	public Users getUserByName(String username) {
		return entityManager.find(Users.class, username);
	}

	public void updateUser(Users u) {
		entityManager.merge(u);
		
	}
    

}
