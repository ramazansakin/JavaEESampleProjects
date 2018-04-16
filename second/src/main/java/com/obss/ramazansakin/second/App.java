package com.obss.ramazansakin.second;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class App 
{

    public static void main( String[] args )
    {
    	List classList = new ArrayList<Class>();    
        List<MenuItemBean> result = new ArrayList<MenuItemBean>();
        try {
        	ClassDetector cd = new ClassDetector("com.obss.ramazansakin.second");
        
			for( Class c : cd.getClasses() ){
				MenuItemBean bean =  detectAnotationsofClass(c);
				if( bean != null )
					result.add(bean);
			}
			
			showBeansInfo((ArrayList<MenuItemBean>) result);
			
		} catch (ClassNotFoundException e1) {
			System.out.println("Class not found!");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("IO Exception!");
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			System.out.println("URISyntaxException!");
			e1.printStackTrace();
		}

    }
    
    public static void showBeansInfo( ArrayList<MenuItemBean> res ){
    	
    	if( res != null && !res.isEmpty() ){
    		for( MenuItemBean b : res ) {
    			System.out.println("Bean Item Infos: ");
    			System.out.println(b);
    		}
    	}
    	
    }
    
    public static MenuItemBean detectAnotationsofClass(Class<?> c){
   		
        //get all annotations of class c
        Annotation[] ann =  c.getAnnotations();
        
        if( ann.length != 0  && !c.isInterface()) {
        	int totalTime = 0;    
	        MenuItemBean bean = new MenuItemBean();
	        bean.setName(c.getName());
	        
	        for( Annotation a : ann ) {
	            if( a.annotationType() == Food.class ){
	            	Food info = (Food) c.getAnnotation(Food.class);
	            	bean.setPrices(info.prices());
	            } else if ( a.annotationType() == Time.class ) {
	            	
	            }
	        }
	        
	        for (Method method : c.getDeclaredMethods()) {
			  if (method.getAnnotation(Time.class) != null) {
				  Time time = (Time)method.getAnnotation(Time.class);
	              totalTime += time.takes();
			  }
			}
	        
	        bean.setTime(totalTime);
	        return bean;
        }
		return null;
   	}
    
}
