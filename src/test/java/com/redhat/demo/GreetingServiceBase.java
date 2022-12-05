package com.redhat.demo;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The tests from this class will be verified by
 * the Executable Specificiation, e.g. GreetingServiceSpec class,
 * mean that all the tests from GreetingServiceSpec MUST pass.
 * Then, these tests will be used by the Test class, e.g. GreetingServiceTest
 * to test aginst the actual implementation of the service. 
 */
public abstract class GreetingServiceBase {

    @Inject
    GreetingService svc;

    @ParameterizedTest
    @ValueSource(strings = { "John", "Jane" })
    public void should_reply_politely(String name) {
        String greeting = svc.saySomething(name);
        Assertions.assertTrue("John".equals(name) ? greeting.startsWith("Mr.") : true);
        Assertions.assertTrue("Jane".equals(name) ? greeting.startsWith("Miss") : true);
    }

}
