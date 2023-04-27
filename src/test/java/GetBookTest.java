import book.Book;
import client.BookStep;
import client.Methods;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetBookTest {
    private final BookStep bookStep = new BookStep();
    private final Methods methods = new Methods();
    private String id;
    private Book book = new Book();


    @Test
    @DisplayName("Получение списка всех книг")
    public void getListBooksTest() {
        bookStep.getBooks();
    }

    @Test
    @DisplayName("Получение книги по верному id")
    public void getBookNo2Test() {
        bookStep.getBookTrue("1");
    }

    @Test
    @DisplayName("Получение книги по верному id два раза")
    public void getBookNo1ANDNo1Test() {
        bookStep.getBookTrue("1");
        bookStep.getBookTrue("1");
    }

    @Test
    @DisplayName("Получение созданной книги по id")
    public void getCreateBookTest() {
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.getBook(id);
        bookStep.deleteBook(id);
    }

    @Test
    @DisplayName("Получение книги без id")
    public void getBookNoIdTest() {
        ValidatableResponse response = bookStep.getBook("");
        methods.statusCode404(response);
    }

    @Test
    @DisplayName("Получение книги по 0 id")
    public void getBookNullTest() {
        ValidatableResponse response = bookStep.getBook("0");
        methods.no0statusCode404(response);
    }

    @Test
    @DisplayName("Получение книги по id 10")
    public void getBookNo5Test() {
        ValidatableResponse response = bookStep.getBook("10");
        methods.no10statusCode404(response);
    }

    @Test
    @DisplayName("Получение книги по отрицательному значению id")
    public void getBookNoMinus1Test() {
        ValidatableResponse response = bookStep.getBook("-1");
        methods.statusCode404(response);
    }

    @Test
    @DisplayName("Получение книги по специальному знаку вместо id")
    public void getBookNoTest() {
        ValidatableResponse response = bookStep.getBook("@");
        methods.statusCode404(response);
    }


}
