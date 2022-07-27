## How Tomcat Works
### Build and Run SimpleServer
• For Pure Java Project
```
>> javac -classpath . org/syh/tomcat/SimpleServer/HttpServer.java -d out
>> java -cp out org.syh.tomcat.SimpleServer.HttpServer
```
• For Maven Project
```
>> mvn compile exec:java -Dexec.mainClass="org.syh.tomcat.SimpleServer.HttpServer"
```

### Notes
• Content-Type  
For HTML, we should use `text/html`.  
For XML, we should use `application/xml`