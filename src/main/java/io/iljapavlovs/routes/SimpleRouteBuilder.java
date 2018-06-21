package io.iljapavlovs.routes;


import io.iljapavlovs.processors.MyProcessor;
import io.iljapavlovs.transfomers.MyTransformer;
import org.apache.camel.builder.RouteBuilder;


//Route - instruction to Camel on how to move messages from one point to another
public class SimpleRouteBuilder extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        //copying contents of folder from one folder to another
// noop=tru - ONLY copy file, do not dleete it from original folder
            from("file:inputFolder?noop=true")
                    .process(new MyProcessor())
                    .bean(new MyTransformer(), "TransformerContent")
                    .to("file:outputFolder");
    }
}
