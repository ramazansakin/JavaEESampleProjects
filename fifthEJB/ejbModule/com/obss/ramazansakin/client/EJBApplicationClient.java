package com.obss.ramazansakin.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.obss.ramazansakin.beans.UserStatelessBean;
import com.obss.ramazansakin.beans.UserStatelessBeanRemote;
import com.obss.ramazansakin.entity.User;
import com.obss.ramazansakin.statefulbeans.UserStatefulBean;
import com.obss.ramazansakin.statefulbeans.UserStatefulBeanRemote;
import com.obss.ramazansakin.test.JNDILookupClass;
import java.util.Scanner;
 
public class EJBApplicationClient {
     
    public static void main(String[] args) {
        UserStatelessBeanRemote beanStateless = doStatelessLookup();
        UserStatefulBeanRemote beanStateful = doStatefulLookup();
        Scanner Consolein = new Scanner(System.in);
        
        // TEST Beans
        // Call stateless bean and statefull bean with a console based user interface
        System.out.println("##### Testing Bean Application [ Fifth ]");
        System.out.println("Select a bean to test :");
        System.out.println("1 - Stateless Bean");
        System.out.println("2 - Stateful Bean");
        
        int choice = Consolein.nextInt();
        
        if( choice == 1 ){
        	while ( choice != 3 ) {
        		System.out.println("Select a bean functions to test :");
                System.out.println("1 - getUserByName");
                System.out.println("2 - updateUser");
                System.out.println("3 - Exit");
                
                int selection = Consolein.nextInt();
                
                if( selection == 1 ) {
                	System.out.println("Write a user name to find:");
                	String name = Consolein.nextLine();
                	// invoke the stateless bean function ...
                	User u = (User)beanStateless.getUserByName(name);
                	System.out.println(u);
                } else if ( selection == 2 ){
                	System.out.println("Write a user name to find:");
                	String name = Consolein.nextLine();
                	// invoke the stateless bean function ...
                	System.out.println("Write a new name for the user");
                	String newname = Consolein.nextLine();
                	System.out.println("Write a new e-mail for the user");
                	String newemail = Consolein.nextLine();
                	
                	// TODO : update user must be changed!
                	beanStateless.updateUser(name);
                	
                } else {
                	System.out.println("Program was closed!");
                	return;
                }   
        	}
        } else {
        	
        	while ( choice != 3 ) {
        		System.out.println("Select a bean functions to test :");
                System.out.println("1 - getUserByName");
                System.out.println("2 - updateUser");
                System.out.println("3 - Exit");
                
                int selection = Consolein.nextInt();
                
                if( selection == 1 ) {
                	System.out.println("Write a user name to find:");
                	String name = Consolein.nextLine();
                	// invoke the stateful bean function ...
                	User u = (User)beanStateful.getUserByName(name);
                	System.out.println(u);
                } else if ( selection == 2 ){
                	System.out.println("Write a user name to find:");
                	String name = Consolein.nextLine();
                	// invoke the stateful bean function ...
                	System.out.println("Write a new name for the user");
                	String newname = Consolein.nextLine();
                	System.out.println("Write a new e-mail for the user");
                	String newemail = Consolein.nextLine();
                	
                	// TODO : update user must be changed!
                	beanStateful.updateUser(name);
                	
                } else {
                	System.out.println("Program was closed!");
                	return;
                }
                
        	}
        }
         
    }
 
    private static UserStatelessBeanRemote doStatelessLookup() {
        Context context = null;
        UserStatelessBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = JNDILookupClass.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getStatelessLookupName();
            // 3. Lookup and cast
            bean = (UserStatelessBeanRemote) context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    private static String getStatelessLookupName() {

    	String appName = "fifth";
        String moduleName = "fifthEJB";
 
        String distinctName = "";
 
        String beanName = UserStatelessBean.class.getSimpleName();
 
        final String interfaceName = UserStatelessBeanRemote.class.getName();
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" + 
                distinctName    + "/" + beanName + "!" + interfaceName;
        return name;
    }
    
    private static UserStatefulBeanRemote doStatefulLookup() {
        Context context = null;
        UserStatefulBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = JNDILookupClass.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getStatefulLookupName();
            // 3. Lookup and cast
            bean = (UserStatefulBeanRemote) context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        
        return bean;
    }
 
    private static String getStatefulLookupName() {

    	String appName = "fifth";
 
        String moduleName = "fifthEJB";
 
        String distinctName = "";
 
        String beanName = UserStatefulBean.class.getSimpleName();

        final String interfaceName = UserStatefulBeanRemote.class.getName();
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" + 
                distinctName    + "/" + beanName + "!" + interfaceName;
        
        return name;
    }
    
}