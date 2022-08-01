package org.syh.tomcat.SimpleServletContainer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;

public class ServletProcessorAlpha {
    /*
     * /servlet/servletName
     */
    public void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        // servletName = "org.syh.tomcat.DemoServlet." + servletName;
        System.out.println(servletName);
        URLClassLoader loader = null;

        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classpath = new File(Constants.WEB_ROOT);
            String repository = (new URL("file", null, classpath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException exception) {
            System.out.println(exception.toString());
        }

        Class<?> servletClass = null;
        try {
            servletClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.toString());
        }

        Servlet servlet = null;
        
        try {
            servlet = (Servlet) servletClass.newInstance();
            servlet.service(request, response);
        } catch (Exception exception) {
            System.out.println(exception.toString());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }
}
