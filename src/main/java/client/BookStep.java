package client;

import book.Book;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class BookStep extends Client {
        private static final String CREATE_BOOK_ENDPOINT = "/api/books";
        private static final String GET_BOOKS_ENDPOINT = "/api/books";
        private static final String GET_BOOK_ENDPOINT = "/api/books/";
        private static final String UPDATE_BOOK_ENDPOINT = "/api/books/";
        private static final String DELETE_BOOK_ENDPOINT = "/api/books/";

    @Step("Создание книги")
    public ValidatableResponse createBook(Book book) {
        return given().log().all().spec(getSpec()).body(book).when().post(CREATE_BOOK_ENDPOINT).then().log().all();
    }
    @Step("Получить список книг")
    public ValidatableResponse getBooks() {
        return given().spec(getSpec()).when().get(GET_BOOKS_ENDPOINT).then().log().all();
    }
    @Step("Удаление книги")
    public ValidatableResponse deleteBook(String id) {
        return given().spec(getSpec()).when().delete(DELETE_BOOK_ENDPOINT + id).then().log().all();
    }
    @Step("Получить книгу по id")
    public ValidatableResponse getBook(String id) {
        return given().spec(getSpec()).when().delete(GET_BOOK_ENDPOINT + id).then().log().all();
    }
    @Step("Изменить книгу по id")
    public ValidatableResponse updateBook(String id) {
        return given().spec(getSpec()).when().delete(UPDATE_BOOK_ENDPOINT + id).then().log().all();
    }

    }
