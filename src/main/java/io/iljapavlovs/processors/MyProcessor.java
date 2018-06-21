package io.iljapavlovs.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class MyProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
                                                           // exchange.getIn().getBody get incoming message
        System.out.println("Now processing the string: " + exchange.getIn().getBody(String.class));
    }

}