package org.syh.tomcat.SimpleServer;

import java.io.IOException;
import java.io.InputStream;

public class Request {
    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }
    
    public void parse() {
        StringBuffer sb = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];

        try {
            i = input.read(buffer);
        } catch (IOException exception) {
            exception.printStackTrace();
            i = -1;
        }

        for (int j = 0; j < i; j++) {
            sb.append((char) buffer[j]);
        }

        System.out.println(sb.toString());
        uri = parseUri(sb.toString());
    }

    /*
     * GET /index.html HTTP/1.1
     */
    private String parseUri(String requestString) {
        String[] data = requestString.split(" ");
        if (data.length >= 3) {
            return data[1];
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
