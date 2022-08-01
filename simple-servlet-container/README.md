### Start the Program

```
>> mvn clean compile exec:java -Dexec.mainClass="org.syh.tomcat.SimpleServletContainer.HttpServerAlpha"
```

If you defined plugin.configuration.mainClass in the pom.xml, then you can just run the command:
```
>> mvn clean compile exec:java
```

Run it using pure Java commands
```
>> javac -cp webroot/javax.servlet-api-4.0.1.jar webroot/PrimitiveServlet.java
>> mvn clean install
>> java -cp target/simple-servlet-container-1.0-SNAPSHOT.jar:webroot/javax.servlet-api-4.0.1.jar org.syh.tomcat.SimpleServletContainer.HttpServerAlpha
```