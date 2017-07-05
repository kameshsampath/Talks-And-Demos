package org.workspace7.istio.tracing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kameshs
 */
@Component
@Slf4j
public class ResponseUtils {

    @Autowired
    IstioProperties istioProperties;

    public HttpHeaders addTraceHeaders(HttpServletRequest request) {

        log.info("Adding Trace Headers ");

        HttpHeaders httpHeaders = new HttpHeaders();

        for (String headerName : istioProperties.getTracingHeaders()) {
            log.info("Retrieving value for  Header:{}", headerName);
            String headerValue = request.getHeader(headerName);
            if (headerValue != null) {
                httpHeaders.add(headerName, headerValue);
            }
        }

        log.info("Trace Headers {}", httpHeaders);

        return httpHeaders;
    }


    public String buildResponse(String... responses) {

        HelloResponse helloResponse = new HelloResponse();

        for (String resp : responses) {
            helloResponse.getResponses().add(resp);
        }

        String response = "";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            response = objectMapper.writeValueAsString(helloResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
    }
}
