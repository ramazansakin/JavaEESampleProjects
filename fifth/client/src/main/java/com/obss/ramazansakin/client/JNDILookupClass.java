package com.obss.ramazansakin.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 
public class JNDILookupClass {
 
    private static Context initialContext;
 
    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
            properties.put("jboss.naming.client.ejb.context", true);
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            properties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false"); // needed for a login module that requires the password in plaintext
            properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
            properties.put(Context.SECURITY_PRINCIPAL, "jboss");
            properties.put(Context.SECURITY_CREDENTIALS, "123456");
            //properties.put("remote.connection.default.port", "8080");
 
            initialContext = new InitialContext(properties);
        }
        
        return initialContext;
    }
}
