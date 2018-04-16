package com.obss.ramazansakin.statefulbeans;

import javax.ejb.Stateful;

import com.obss.ramazansakin.entity.User;

/**
 * Session Bean implementation class UserStatefulBean
 */
@Stateful
public class UserStatefulBean implements UserStatefulBeanRemote {

	/**
     * Default constructor. 
     */
    public UserStatefulBean() {
    }

	@Override
	public Object getUserByName(String name) {
		
		System.out.println("STATEFULL ## getUserByName was called!");
		User u = new User();
		u.setName("Ramazan");
		return (User)u;
	}

	@Override
	public void updateUser(String name) {
		System.out.println("STATEFULL## getUserByName was called!");
		
	}

}
