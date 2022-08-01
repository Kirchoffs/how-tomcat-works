import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    private String getOKHeader() {
        return 
            "HTTP/1.1 200 OK\r\n" + 
            "Content-Type: text/html\r\n" +
            "\r\n";
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("From service");
        PrintWriter out = response.getWriter();
        out.print(getOKHeader());
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");
    }

    public void destroy() {
        System.out.println("destroy");
    }

    public String getServletInfo() { 
        return null;
    }
    
    public ServletConfig getServletConfig() {
        return null; 
    }

    public void say() {
        System.out.println("Hi Servlet");
    }

    public static void main(String[] args) {
        System.out.println("Hi Serlvet from main");
    }
}
