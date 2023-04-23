package com.redhat.demo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String saySomething(String name) {
        if("John".equals(name)) return "Mr.";
        if("Jane".equals(name)) return "Should fail";
        return "";
    }
}
