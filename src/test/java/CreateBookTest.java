import client.BookStep;
import client.Methods;
import book.Books;
import book.Book;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateBookTest {
    private final BookStep bookStep = new BookStep();
    private final Methods methods = new Methods();
    private String id;
    private Book book = new Book();
    private Books books = new Books();


    @AfterEach
    public void cleanUp() {
        if (id != null) {
            bookStep.deleteBook(id);
        }
    }

    @Test
    @DisplayName("Создание книги со всеми полями")
    public void createBookAllFieldsTest() {
        ValidatableResponse response = bookStep.createBooks(books);
        id = response.extract().path("book.id").toString();

    }

    @Test
    @DisplayName("Создание книги только с необходимым полем name")
    public void createNameBookTest() {
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();

    }

    @Test
    @DisplayName("Создание книги с пустым полем name")
    public void createNoNameBookTest() {
        ValidatableResponse response = bookStep.createEmptyBook(new Book(""));
        methods.createBookStatusCode400(response);
        id = response.extract().path("book.id").toString();
    }

    @Test
    @DisplayName("Создание книг с одинаковым названием")
    public void createDoubleNameBookTest() {
        ValidatableResponse response = bookStep.createEmptyBook(new Book("Год единорога"));
        bookStep.createEmptyBook(new Book("Год единорога"));
        id = response.extract().path("book.id").toString();
    }


}
