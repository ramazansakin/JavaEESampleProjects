package com.obss.ramazansakin.second;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassDetector {
	
	private String packageName;
	public ClassDetector( String packageName ) {
		this.packageName = packageName;
	}
	
	public Iterable<Class> getClasses() throws ClassNotFoundException, IOException, URISyntaxException{
	    
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    String path = packageName.replace('.', '/');
	    Enumeration<URL> resources = classLoader.getResources(path);
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements())
	    {
	        URL resource = resources.nextElement();
	        URI uri = new URI(resource.toString());
	        dirs.add(new File(uri.getPath()));
	    }
	    List<Class> classes = new ArrayList<Class>();
	    for (File directory : dirs)
	    {
	        classes.addAll(findClasses(directory, packageName));
	    }
	
	    return classes;
	}


	public List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException
	{
	    List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists())
	    {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files)
	    {
	        if (file.isDirectory())
	        {
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        }
	        else if (file.getName().endsWith(".class"))
	        {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}
	
}
