import client.BookStep;
import client.Methods;
import book.Books;
import book.Book;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateBookTest {
    private final BookStep bookStep = new BookStep();
    private final Methods methods = new Methods();
    private String id;
    private  Book book;
    private Books books;

    @Test
    @DisplayName("Создание книги со всеми полями")
    public void createBookAllFields(){
   //bookStep.createBooks("Год Единорога","Андрэ Нортон", 1965 ,false);

    }
    @Test
    @DisplayName("Создание книги только с необходимым полем name")
    public void createNameBook(){
        bookStep.createBook("Год дракона");

    }
    @Test
    @DisplayName("Создание книги с пустым полем name")
    public void createNoNameBook(){
        ValidatableResponse response = bookStep.createBook("");
        methods.createBookStatusCode400(response);
    }


}
