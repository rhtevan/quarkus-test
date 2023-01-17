package com.redhat.demo;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;

/**
 * === Executable Specification ===
 * 
 * One way of defining and implementing an executable specification is
 * to leverage mocks, e.g. Mockito.mock. 
 * Alternatively, to adopt BDD style tests and Cucumber framework by defining
 * the Specification with gherkin .feature file and implement it with Steps
 * definition class.   
 * A typical workflow is as follows:
 *  1. Create an abstract base class with injected Service instance as a validator
 *  2. Develop the Executable Specification by implementing a QuarkusTest class 
 *     which extends the Base class, and install a mock instance with configurations
 *     representing the desired behavior according to the specification
 *  3. Add test methods to Base class, and run Spec; all tests MUST pass
 *  4. Create a QuarkusTest class for testing the actual implementation of the Service by
 *     extends the Base, and optionally adding some auxiliary test methods which are NOT
 *     intended to be validated by the Spec, rather than facilitating implementation tests
 */
@QuarkusTest
public class GreetingServiceSpec extends GreetingServiceValidator {

    @BeforeEach
    public void design() {
        GreetingService mockSvc = Mockito.mock(GreetingService.class);
        
        // Scenarios
        Mockito.when(mockSvc.saySomething("John")).thenReturn("Mr.");
        Mockito.when(mockSvc.saySomething("Jane")).thenReturn("Miss");

        QuarkusMock.installMockForInstance(mockSvc, svc);
    }
}
