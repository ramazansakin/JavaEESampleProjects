package com.obss.ramazansakin.statefulbeans;

import javax.ejb.Remote;

@Remote
public interface UserStatefulBeanRemote {
	
	public Object getUserByName( String name );
	public void updateUser( String name );
	
}
