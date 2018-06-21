package io.iljapavlovs;

import io.iljapavlovs.routes.SimpleRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class MainApp {

    public static void main(String[] args) {
        SimpleRouteBuilder simpleRouteBuilder = new SimpleRouteBuilder();
        CamelContext context = new DefaultCamelContext();
        try {
            //Route - instruction to Camel on how to move messages from one point to another
            context.addRoutes(simpleRouteBuilder);

            context.start();

            Thread.sleep(5 * 1000);

            String contents = FileUtils.readFileToString(new File("/outputFolder/test.txt"), "UTF-8");
            System.out.println("Processed contents: " + contents);

            context.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
