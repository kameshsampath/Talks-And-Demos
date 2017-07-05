package org.workspace7.istio.tracing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kameshs
 */
@RestController
@Slf4j
public class HelloWorldTracerController {

    @Autowired
    private ResponseUtils responseUtils;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/hellotracer")
    public String hello(HttpServletRequest request) {

        final HttpHeaders headers = responseUtils.addTraceHeaders(request);

        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

        ResponseEntity<String> helloworld = restTemplate.exchange("http://helloworld:8080/helloworld",
                HttpMethod.GET, httpEntity, String.class);

        return responseUtils.buildResponse(helloworld.getBody());
    }
}
