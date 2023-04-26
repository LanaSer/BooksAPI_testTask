import book.Book;
import client.BookGenerator;
import client.BookStep;
import client.Methods;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GetBookTest {
    private final BookStep bookStep = new BookStep();
    private final Methods methods = new Methods();
    private String id;

    private Book book = BookGenerator.random();

    @Test
    @DisplayName("Получение списка всех книг")
    public void getListBooks() {
        bookStep.getBooks();
    }

    @Test
    @DisplayName("Получение книги по верному id")
    public void getBookNo2() {
        bookStep.getBookTrue("2");
    }

    @Test
    @DisplayName("Получение книги по верному id два раза")
    public void getBookNo1ANDNo1() {
        bookStep.getBookTrue("1");
        bookStep.getBookTrue("1");
    }

    @Test
    @DisplayName("Получение книги без id")
    public void getBookNoId() {
        ValidatableResponse response = bookStep.getBook("");
        methods.statusCode404(response);
    }
    @Test
    @DisplayName("Получение книги по 0 id")
    public void getBook() {
        ValidatableResponse response = bookStep.getBook("0");
        methods.no0statusCode404(response);
    }
    @Test
    @DisplayName("Получение книги по id 4")
    public void getBookNo3() {
        ValidatableResponse response = bookStep.getBook("4");
        methods.no3statusCode404(response);
    }

    @Test
    @DisplayName("Получение книги по отрицательному значению id")
    public void getBookNoMinus1() {
        ValidatableResponse response = bookStep.getBook("-1");
        methods.statusCode404(response);
    }

    @Test
    @DisplayName("Получение книги по специальному знаку вместо  id")
    public void getBookNo() {
        ValidatableResponse response = bookStep.getBook("@");
        methods.statusCode404(response);
    }

    @Test
    @DisplayName("Получение созданной книги по id")
    public void getCreateBook() {
        ValidatableResponse response = bookStep.createBook("Полет");
        //id = response.extract().path("id").toString();
       // bookStep.getBook(id);
    }

}
