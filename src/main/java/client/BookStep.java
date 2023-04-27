package client;

import book.Book;
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

    @Step("Получить список книг")
    public ValidatableResponse getBooks() {
        return given().spec(getSpec()).when().get(GET_BOOKS_ENDPOINT).then().log().all().assertThat().statusCode(200);
    }

    @Step("Получить книгу по верному id")
    public ValidatableResponse getBookTrue(String id) {
        return given().log().all().spec(getSpec()).when().get(GET_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(200);
    }

    @Step("Получить книгу по id")
    public ValidatableResponse getBook(String id) {
        return given().spec(getSpec()).when().get(GET_BOOK_ENDPOINT + id).then().log().all();
    }

    @Step("Создание книги со всеми полями")
    public ValidatableResponse createBooks(Books books) {
        BooksGenerator booksGenerator = new BooksGenerator();
        books.setName(booksGenerator.name);
        books.setAuthor(booksGenerator.author);
        books.setYear(booksGenerator.year);
        books.isElectronicBook(booksGenerator.electronic);

        return given().log().all().spec(getSpec()).body(books).when().post(CREATE_BOOK_ENDPOINT).then().log().all().assertThat().statusCode(201);
    }

    @Step("Создание книги только с полем name")
    public ValidatableResponse createBook(Book book) {
        BookGenerator bookGenerator = new BookGenerator();
        book.setName(bookGenerator.name);
        return given().log().all().spec(getSpec()).body(book).when().post(CREATE_BOOK_ENDPOINT).then().log().all();
    }

    @Step("Создание пустой книги")
    public ValidatableResponse createEmptyBook(Book book) {
        return given().log().all().spec(getSpec()).body(book).when().post(CREATE_BOOK_ENDPOINT).then().log().all();
    }

    @Step("Удаление книги")
    public ValidatableResponse deleteBook(String id) {
        return given().log().all().spec(getSpec()).when().delete(DELETE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(200);
    }

    @Step("Удаление книги")
    public ValidatableResponse deleteBook404(String id) {
        return given().spec(getSpec()).when().delete(DELETE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(404);
    }


    @Step("Изменить книгу по id")
    public ValidatableResponse updateBook(String id, Books books) {
        BooksGenerator booksGenerator = new BooksGenerator();
        books.setName(booksGenerator.name);
        books.setAuthor(booksGenerator.author);
        books.setYear(booksGenerator.year);
        books.isElectronicBook(booksGenerator.electronic);
        return given().spec(getSpec()).body(books).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(200);
    }

    @Step("Изменения книги пустым body")
    public ValidatableResponse updateEmptyBook(String id) {
        return given().spec(getSpec()).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(400);
    }

    @Step("Изменить книгу по id без name")
    public ValidatableResponse updateBookNoName(String id, Books books) {
        BooksGenerator booksGenerator = new BooksGenerator();
        books.setAuthor(booksGenerator.author);
        books.setYear(booksGenerator.year);
        books.isElectronicBook(booksGenerator.electronic);
        return given().spec(getSpec()).body(books).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(400).and().assertThat().body("error", equalTo("Name is required"));
    }

    @Step("Изменить книгу по id без author")
    public ValidatableResponse updateBookNoAuthor(String id, Books books) {
        BooksGenerator booksGenerator = new BooksGenerator();
        books.setName(booksGenerator.name);
        books.setYear(booksGenerator.year);
        books.isElectronicBook(booksGenerator.electronic);
        return given().spec(getSpec()).body(books).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(400).and().assertThat().body("error", equalTo("Author is required"));
    }

    @Step("Изменить книгу по id без year")
    public ValidatableResponse updateBookNoYear(String id, Books books) {
        BooksGenerator booksGenerator = new BooksGenerator();
        books.setName(booksGenerator.name);
        books.setAuthor(booksGenerator.author);
        books.isElectronicBook(booksGenerator.electronic);
        return given().spec(getSpec()).body(books).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(400).and().assertThat().body("error", equalTo("Year is required"));
    }
    @Step("Изменить книгу по id без isElectronicBook")
    public ValidatableResponse updateBookNoElectronic(String id,Books books) {
        BooksGenerator booksGenerator = new BooksGenerator();
        books.setName(booksGenerator.name);
        books.setAuthor(booksGenerator.author);
        books.setYear(booksGenerator.year);
        return given().log().all().spec(getSpec()).body(books).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(400).and().assertThat().body("error", equalTo("IsElectronicBook is required"));
    }
    @Step("Изменения книги пустым id")
    public ValidatableResponse updateEmptyId(String id) {
        return given().spec(getSpec()).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(404);
    }
    @Step("Изменения книги пустым неверный id")
    public ValidatableResponse updateNoId(String id) {
        return given().spec(getSpec()).when().put(UPDATE_BOOK_ENDPOINT + id).then().log().all().assertThat().statusCode(400);
    }

}
