package at.htl.karate.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AddressTest {

    @Karate.Test
    Karate testAddressEndpoint() {
        return Karate.run("address").relativeTo(getClass());
    }
}
