package org.syh.tomcat.SimpleServletContainer;

import java.io.IOException;

public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
