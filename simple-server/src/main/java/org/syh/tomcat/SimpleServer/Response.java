package org.syh.tomcat.SimpleServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    private String getOKHeader() {
        return 
            "HTTP/1.1 200 OK\n" + 
            "Content-Type: text/html\n" +
            "\n";
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                String header = getOKHeader();
                output.write(header.getBytes());
                fis = new FileInputStream(file);
                int chs = fis.read(bytes, 0, BUFFER_SIZE);
                while (chs != -1) {
                    output.write(bytes, 0, chs);
                    chs = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                String errorMessage = 
                    "HTTP/1.1 404 File Not Found\n" +
                    "Content-Type: text/html\n" + 
                    "\n" + 
                    "<h1>File Not Found</h1>";
                
                output.write(errorMessage.getBytes());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
    
}
