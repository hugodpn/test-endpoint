package io.slingr.endpoints.sampleComplex;

import io.slingr.endpoints.Endpoint;
import io.slingr.endpoints.exceptions.EndpointException;
import io.slingr.endpoints.exceptions.ErrorCode;
import io.slingr.endpoints.framework.annotations.ApplicationLogger;
import io.slingr.endpoints.framework.annotations.EndpointConfiguration;
import io.slingr.endpoints.framework.annotations.EndpointFunction;
import io.slingr.endpoints.framework.annotations.SlingrEndpoint;
import io.slingr.endpoints.services.AppLogs;
import io.slingr.endpoints.utils.Json;
import io.slingr.endpoints.ws.exchange.FunctionRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Sample complex endpoint
 *
 * <p>Created by egonzalez on 26/09/17.
 */
@SlingrEndpoint(name = "samplecomplexhp")
public class SampleComplexEndpoint extends Endpoint {
    private static final Logger logger = LoggerFactory.getLogger(SampleComplexEndpoint.class);

    @ApplicationLogger
    private AppLogs appLogger;

    @EndpointConfiguration
    private Json configuration;

    @EndpointFunction
    public Json ping(FunctionRequest request){
        final Json data = request.getJsonParams();
        appLogger.info("Request to PING received", data);

        final Json response = Json.map();
        response.set("configuration", configuration.toString());
        response.set("request", data.toString());
        response.set("ping", "pong");
        response.set("ping2", "pong2");
        response.set("ping3", "pong3");
        response.set("ping4", "pong4");

        logger.info(String.format("Function PING: [%s]", response.toString()));
        return response;
    }

    @EndpointFunction
    public Json ping2(FunctionRequest request){
        final Json data = request.getJsonParams();
        appLogger.info("Request to PING received", data);

        final Json response = Json.map();
        response.set("configuration", configuration.toString());
        response.set("request", data.toString());
        response.set("ping", "pongX");
        response.set("ping1", "pongY");

        logger.info(String.format("Function PING: [%s]", response.toString()));
        return response;
    }

    @EndpointFunction
    public Json executeScript(FunctionRequest request){
        Json data = request.getJsonParams();
        if(data == null){
            data = Json.map();
        }
        final String name = data.string("script");
        appLogger.info(String.format("Request to EXECUTE SCRIPT [%s] received", name));
        if(StringUtils.isBlank(name)){
            throw EndpointException.permanent(ErrorCode.ARGUMENT, "Empty script name");
        }

        final Object parameters = data.object("parameters");
        final Object response = scripts().execute(name, parameters);

        logger.info(String.format("Response to EXECUTE SCRIPT [%s]: %s", name, response!= null ? "["+response.toString()+"]" : "NULL"));
        return response instanceof Json ? (Json) response : Json.map().set("body", response);
    }
}
