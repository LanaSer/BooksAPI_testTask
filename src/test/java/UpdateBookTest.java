import book.Book;
import book.Books;
import client.BookStep;
import client.Methods;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdateBookTest {
    private final BookStep bookStep = new BookStep();
    private final Methods methods = new Methods();
    private String id;
    private Book book = new Book();
    private Books books = new Books();


    @Test
    @DisplayName("Обновление книги что уже была в библиотеке")
    public void updateBookTest(){
        bookStep.updateBook("1",books);

    }
    @Test
    @DisplayName("Обновление новой книги")
    public void updateNewBookTest(){
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.updateBook(id,books);
        bookStep.deleteBook(id);
    }
    @Test
    @DisplayName("Обновление книги пустыми полями")
    public void updateBookEmptyTest(){
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.updateEmptyBook(id);
        bookStep.deleteBook(id);

    }
    @Test
    @DisplayName("Изменение книги без поля name")
    public void updateBookNullNameTest(){
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.updateBookNoName(id,books);
        bookStep.deleteBook(id);
    }
    @Test
    @DisplayName("Изменение книги без поля author")
    public void updateBookNullAuthorTest(){
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.updateBookNoAuthor(id,books);
        bookStep.deleteBook(id);
    }
    @Test
    @DisplayName("Изменение книги без поля year")
    public void updateBookNullYearTest(){
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.updateBookNoYear(id,books);
        bookStep.deleteBook(id);
    }
    @Test
    @DisplayName("Изменение книги без поля IsElectronicBook")
    public void updateBookNullElectronicTest(){
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.updateBookNoElectronic(id,books);
        bookStep.deleteBook(id);
    }

    @Test
    @DisplayName("Обновление книги без id")
    public void updateBookNoIDTest() {
        ValidatableResponse response = bookStep.createBook(book);
        id = response.extract().path("book.id").toString();
        bookStep.updateEmptyId("");
        bookStep.deleteBook(id);
    }
    @Test
    @DisplayName("Обновление книги по  id 0")
    public void updateBookNullIDTest() {
        bookStep.updateEmptyId("0");
    }
    @Test
    @DisplayName("Обновление книги по  id 10")
    public void updateBookNoID10Test() {
        bookStep.updateEmptyId("10");
    }
    @Test
    @DisplayName("Обновление книги по  id -1")
    public void updateBookNoMinus1Test() {
        bookStep.updateEmptyId("-1");
    }
    @Test
    @DisplayName("Обновление книги по  специальному знаку вместо  id")
    public void updateBookNoTest() {
        bookStep.updateEmptyId("@");
    }



}
