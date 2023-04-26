package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Client {
    private static final String BASE_URL = "http://localhost:5000";

    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .setBaseUri(BASE_URL)
                .build();

    }
}
