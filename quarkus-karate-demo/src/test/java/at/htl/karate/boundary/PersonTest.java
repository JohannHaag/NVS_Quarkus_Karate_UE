package at.htl.karate.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonTest {

    @Karate.Test
    Karate testPersonEndpoint() {
        return Karate.run("person").relativeTo(getClass());
    }
}

