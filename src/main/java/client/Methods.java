package client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class Methods {
    @Step("Проверка кода ответа запросе книг")
    public void statusCode(ValidatableResponse response) {
        response.assertThat().statusCode(200);
    }

    @Step("Проверка кода ответа запросе книги по 0 id")
    public void no0statusCode404(ValidatableResponse response) {
        response.assertThat().statusCode(404).and().assertThat().body("error", equalTo("Book with id 0 not found"));
    }

    @Step("Проверка кода ответа запросе книги по 10 id")
    public void no10statusCode404(ValidatableResponse response) {
        response.assertThat().statusCode(404).and().assertThat().body("error", equalTo("Book with id 10 not found"));
    }

    @Step("Проверка кода ответа не верном запросе книги по id")
    public void statusCode404(ValidatableResponse response) {
        response.assertThat().statusCode(404);
    }

    @Step("Проверка кода ответа при неверном создании книги")
    public void createBookStatusCode400(ValidatableResponse response) {
        response.assertThat().statusCode(400);
    }

}
