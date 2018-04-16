package com.obss.ramazansakin.beans;

import javax.ejb.Stateless;
import com.obss.ramazansakin.entity.User;

/**
 * Session Bean implementation class UserStatelessBean
 */
@Stateless
public class UserStatelessBean implements UserStatelessBeanRemote {

    /**
     * Default constructor. 
     */
    public UserStatelessBean() {
    }

	@Override
	public Object getUserByName(String name) {
		
		System.out.println("## getUserByName was called!");
		User u = new User();
		u.setName("Ramazan");
		return (User)u;
	}

	@Override
	public void updateUser(String name) {
		System.out.println("## getUserByName was called!");
		
	}

}
