package org.example;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class TvSpotParserHandler implements RequestHandler<RequestDto, String> {

    @Override
    public String handleRequest(RequestDto s, Context context) {
        context.getLogger().log("Input: " + s.getStuff());
        return "Hello " + s;
    }
}
