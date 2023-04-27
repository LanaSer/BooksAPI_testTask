import book.Book;
import book.Books;
import client.BookStep;
import client.Methods;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteBook {
    private final BookStep bookStep = new BookStep();
    private final Methods methods = new Methods();
    private String id;
    private Book book = new Book();


    @Test
    @DisplayName("Удаление книги по верному id")
    public void deleteBookTest() {
        bookStep.deleteBook("2");
    }

    @Test
    @DisplayName("Удаление созданой книги по id")
    public void deleteCreateBookTest() {
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.deleteBook(id);
    }

    @Test
    @DisplayName("Удаление книги по верному id два раза")
    public void deleteDoubleBookTest() {
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.deleteBook(id);
        bookStep.deleteBook404(id);

    }

    @Test
    @DisplayName("Удаление книги без Id")
    public void deleteBookNoIdTest() {
        bookStep.deleteBook404("");
    }

    @Test
    @DisplayName("Удаление книги по 0 id")
    public void deleteBookNullTest() {
        ValidatableResponse response = bookStep.deleteBook("0");
        methods.no0statusCode404(response);
    }

    @Test
    @DisplayName("Удаление книги по id 10")
    public void deleteBook4Test() {
        ValidatableResponse response = bookStep.deleteBook404("10");
        methods.no10statusCode404(response);
    }

    @Test
    @DisplayName("Удаление книги по отрицательному значению id")
    public void deleteBookNoMinus1Test() {
        ValidatableResponse response = bookStep.deleteBook("-1");
        methods.statusCode404(response);
    }

    @Test
    @DisplayName("Удаление книги по специальному знаку вместо id")
    public void deleteBookNoTest() {
        ValidatableResponse response = bookStep.getBook("@");
        methods.statusCode404(response);
    }

}
