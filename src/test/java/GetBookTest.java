import client.BookStep;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class GetBookTest {
    private BookStep bookStep;
    private String id;

    @Test
    @DisplayName("Получение списка всех книг")
    public void getListBooks(){
        bookStep.getBooks();
    }
    @Test
    @DisplayName("Получение книги по id")
    public void getBook(){
        bookStep.getBook(id);
    }



}
