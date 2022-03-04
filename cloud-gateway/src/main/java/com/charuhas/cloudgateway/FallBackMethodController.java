//package com.charuhas.cloudgateway;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//public class FallBackMethodController {
//    @GetMapping("/customerServiceFallBack")
//    public String customerServiceFallBackMethod() {
//        return "Customer Service is taking longer than Expected." +
//                " Please try again later";
//    }
//
//    @GetMapping("/addressServiceFallBack")
//    public String addressServiceFallBackMethod() {
//        return "address Service is taking longer than Expected." +
//                " Please try again later";
//    }
//}
