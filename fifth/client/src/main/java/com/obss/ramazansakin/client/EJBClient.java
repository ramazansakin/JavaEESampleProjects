package com.obss.ramazansakin.client;

import javax.naming.Context;
import javax.naming.NamingException;
import com.obss.ramazansakin.beans.*;

public class EJBClient {

	public static void main(String[] args) {

		ejbStatelessUserBeanRemote bean = doLookup();

		// System.out.println(bean.getUserByName("Ramazan"));

	}

	// Stateless Bean JNDI adaptation
	private static ejbStatelessUserBeanRemote doLookup() {
		Context context = null;
		ejbStatelessUserBeanRemote bean = null;
		try {
			context = JNDILookupClass.getInitialContext();
			String lookupName = getLookupName();
			bean = (ejbStatelessUserBeanRemote) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}

		return bean;
	}

	private static String getLookupName() {

		String appName = "";
		String moduleName = "server";

		String distinctName = "";

		String beanName = ejbStatelessUserBean.class.getSimpleName();
		final String interfaceName = ejbStatelessUserBeanRemote.class.getName();
		return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
	}

	// -----------------------------------------------
	// Stateful Bean JNDI adaptation
	private static statefulUserEJBBeanRemote doLookup2() {
		Context context = null;
		statefulUserEJBBeanRemote bean = null;
		try {
			context = JNDILookupClass.getInitialContext();
			String lookupName = getLookupName();
			bean = (statefulUserEJBBeanRemote) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}

		return bean;
	}

	private static String getLookupName2() {

		String appName = "";
		String moduleName = "server";

		String distinctName = "";

		String beanName = statefulUserEJBBean.class.getSimpleName();

		final String interfaceName = statefulUserEJBBeanRemote.class.getName();

		return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
	}

}
