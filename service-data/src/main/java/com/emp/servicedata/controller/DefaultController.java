package com.emp.servicedata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DefaultController {
    @GetMapping("/")
    public String defaultRoute(){
        log.info("Default END POINT HIT!");
        return "Back-end Service";
    }

    @GetMapping("/log")
    public String defaultRoute(@RequestBody String test){
        log.info(test);
        return "Request contains : " + test ;
    }

    @GetMapping("/rexcept")
    public void testRuntimeException(){
        log.info("Throwing Runtime Exception");
        throw new RuntimeException("test Runtime Exception");
    }

    @GetMapping("/eexcept")
    public void testException() throws Exception {
        log.info("Throwing Checked exception");
        throw new Exception("test Checked exception");
    }
}

