## How Tomcat Works
### Build and Run SimpleServer
For Pure Java Project
```
>> javac -cp . org/syh/tomcat/SimpleServer/HttpServer.java -d out
>> java -cp out org.syh.tomcat.SimpleServer.HttpServer
```
For Maven Project
```
>> cd simple-server
>> mvn compile exec:java -Dexec.mainClass="org.syh.tomcat.SimpleServer.HttpServer"
```

### Notes
__1. Content-Type__  
For HTML, we should use `text/html`.  
For XML, we should use `application/xml`

__2. Content-Length__  
It's the number of bytes of data in the body of the request or response. The body is the part that comes after the blank line below the headers.

__3. Java Class `FileInputStream`__  
public int read(byte[] b, int off, int len) throws IOException  

Reads up to len bytes of data from this input stream into an array of bytes. If len is not zero, the method blocks until some input is available; otherwise, no bytes are read and 0 is returned.

_off_ - the start offset in the destination array b

__4. Java Class `PrintWriter`__  
public PrintWriter(OutputStream out, boolean autoFlush)  

Creates a new PrintWriter from an existing OutputStream. This convenience constructor creates the necessary intermediate OutputStreamWriter, which will convert characters into bytes using the default character encoding.

_autoFlush_ - A boolean; if true, the println, printf, or format methods will flush the output buffer. Not including `print`

__5. Java Interface `Servlet`__  
The Servlet interface has five methods whose signatures are as follows.  
- public void init(ServletConfig config) throws ServletException  
- public void service(ServletRequest request, ServletResponse response)  
throws ServletException, java.io.IOException  
- public void destroy()  
- public ServletConfig getServletConfig()  
- public java.lang.String getServletInfo()

Of the five methods in Servlet, the init, service, and destroy methods are the servlet's __life cycle__ methods. The init method is called by the servlet container after the servlet class has been instantiated. The servlet container calls this method exactly once to indicate to the servlet that the servlet is being placed into service. The init method must complete successfully before the servlet can receive any requests. A servlet programmer can override this method to write initialization code that needs to run only once, such as loading a database driver, initializing values, and so on. In other cases, this method is normally left blank.

The servlet container calls the service method of a servlet whenever there is a request for the servlet. The servlet container passes a `javax.servlet.ServletRequest` object and a `javax.servlet.ServletResponse` object. The ServletRequest object contains the client's HTTP request information and the ServletResponse object encapsulates the servlet's response. The service method is invoked many times during the life of the servlet.

__6. Java Class `URLClassLoader`__  
This class loader is used to load classes and resources from a search path of URLs referring to both JAR files and directories. Any URL that ends with a '/' is assumed to refer to a directory. Otherwise, the URL is assumed to refer to a JAR file which will be opened as needed.

__7. Java Class `URL`__  
- URL(URL context, String spec, URLStreamHandler handler)  
Creates a URL by parsing the given spec with the specified handler within a specified context.  

- URL(String protocol, String host, String file)  
Creates a URL from the specified protocol name, host name, and file name.  

```
URL url = new URL("file", null, "/Users/ben/projects/toy-tomcat/webroot/");

// url.toString()
// file:/Users/ben/projects/toy-tomcat/webroot/
```

__8. Java Command__  
-cp, -classpath  

For both __java__ and __javac__, it specifies where to find user class files, and (optionally) annotation processors and source files. This class path overrides the user class path in the CLASSPATH environment variable. If neither CLASSPATH, -cp nor -classpath is specified, the user class path consists of the current directory.

__9. Java Class `File`__  
getPath()  
getAbsolutePath()  
getCanonicalPath()   

- path: ./server.java  
- absolute path: /Users/tomcat/Documents/projects/HowTomcatWorks/../HowTomcatWorks/server.java
- canonical path: /Users/tomcat/Documents/projects/HowTomcatWorks/server.java