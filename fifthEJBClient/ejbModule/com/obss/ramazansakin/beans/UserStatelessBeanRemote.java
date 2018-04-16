package com.obss.ramazansakin.beans;

import javax.ejb.Remote;

@Remote
public interface UserStatelessBeanRemote {
	
	public Object getUserByName( String name );
	public void updateUser( String name );

}
