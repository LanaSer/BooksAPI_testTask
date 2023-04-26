import book.Book;
import book.Books;
import client.BookStep;
import client.Methods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteBook {
    private final BookStep bookStep = new BookStep();
    private final Methods methods = new Methods();
    private String id;
    private Book book;
    private Books books;

    @Test
    @DisplayName("Удаление книги")
    public void deleteBook(){
        bookStep.deleteBook("2");
    }
    @Test
    @DisplayName("Удаление созданой книги")
    public void deleteCreateBook(){
        bookStep.createBook("");
        bookStep.deleteBook("3");
    }
    @Test
    @DisplayName("Удаление одной книги 2 раза")
    public void deleteDoubleBook(){
        bookStep.deleteBook("1");
        bookStep.deleteBook("1");
    }
    @Test
    @DisplayName("Удаление книги без Id")
    public void deleteBookNoId(){
        bookStep.deleteBook("");
    }
   // @Test



}
