package com.obss.ramazansakin.beans;

import javax.ejb.Remote;

import com.obss.ramazansakin.model.Users;

@Remote
public interface ejbStatelessUserBeanRemote {
	
	public Users getUserByName(String username);

    public void updateUser(Users u);

}
