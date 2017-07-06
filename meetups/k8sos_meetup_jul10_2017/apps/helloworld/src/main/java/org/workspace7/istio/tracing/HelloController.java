package org.workspace7.istio.tracing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kameshs
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private ResponseUtils responseUtils;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/helloworld")
    public String hello(HttpServletRequest request) {

        final HttpHeaders headers = responseUtils.addTraceHeaders(request);

        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

        ResponseEntity<String> namaste = restTemplate.exchange("http://namaste:8080/namaste",
                HttpMethod.GET, httpEntity, String.class);

        ResponseEntity<String> hola = restTemplate.exchange("http://hola:8080/hola",
                HttpMethod.GET, httpEntity, String.class);

        ResponseEntity<String> aloha = restTemplate.exchange("http://aloha:8080/aloha",
                HttpMethod.GET, httpEntity, String.class);


        //This will circuit break
        String aloha2;
        try {
            ResponseEntity<String> aloha2Resp = restTemplate.exchange("http://aloha:8080/aloha2",
                    HttpMethod.GET, httpEntity, String.class);

            if (aloha2Resp.getStatusCode().is2xxSuccessful()) {
                aloha2 = aloha2Resp.getBody();
            } else {
                aloha2 = "Status Code :" + aloha2Resp.getStatusCode();
            }
        } catch (RestClientException e) {
            log.error(e.getMessage());
            aloha2 = e.getMessage();
        }

        return responseUtils.buildResponse(namaste.getBody(), hola.getBody(), aloha.getBody(), aloha2);
    }

}
