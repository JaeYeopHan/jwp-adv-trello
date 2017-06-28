package jbee.web;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class HomeControllerTest {

    @Value("${local.server.port}")
    private int serverPort;

    @Before
    public void setUp() {
        System.out.println("port number: " + serverPort);
        RestAssured.port = serverPort;
    }


    @Test
    public void test() throws Exception {
        String body = given()
        .when()
            .get("/")
        .then()
            .statusCode(200)
            .extract()
            .asString();

        System.out.println("body: " + body);
    }
}
