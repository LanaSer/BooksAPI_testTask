package client;

import book.Books;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookStep extends Client {
    private static final String CREATE_BOOK_ENDPOINT = "/api/books";
    private static final String GET_BOOKS_ENDPOINT = "/api/books";
    private static final String GET_BOOK_ENDPOINT = "/api/books/";
    private static final String UPDATE_BOOK_ENDPOINT = "/api/books/";
    private static final String DELETE_BOOK_ENDPOINT = "/api/books/";

    @Step("Создание книги со всеми полями")
    public ValidatableResponse createBooks(Books books) {
        return given().log().all().spec(getSpec()).body(books).when().post(CREATE_BOOK_ENDPOINT).then().log().all();
    }
    @Step("Создание книги только с полем name")
    public ValidatableResponse createBook(String name) {
        return given().spec(getSpec()).body(name).when().post(CREATE_BOOK_ENDPOINT).then().log().all();
    }

    @Step("Получить список книг")
    public ValidatableResponse getBooks() {
        return given().spec(getSpec()).when().get(GET_BOOKS_ENDPOINT).then().log().all().assertThat().statusCode(200);
    }

    @Step("Удаление книги")
    public ValidatableResponse deleteBook(String id) {
        return given().spec(getSpec()).when().delete(DELETE_BOOK_ENDPOINT + id).then().log().all();
    }

    @Step("Получить книгу по верному id")
    public ValidatableResponse getBookTrue(String id) {
        return given().spec(getSpec()).when().get(GET_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(200).and().assertThat().body("result", equalTo(true));
    }
    @Step("Получить книгу по id")
    public ValidatableResponse getBook(String id) {
        return given().spec(getSpec()).when().get(GET_BOOK_ENDPOINT + id).then().log().all();
    }

    @Step("Изменить книгу по id")
    public ValidatableResponse updateBook(String id) {
        return given().spec(getSpec()).when().delete(UPDATE_BOOK_ENDPOINT + id).then().log().all();
    }
}
