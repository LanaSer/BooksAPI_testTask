package client;

import book.Book;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class BookGenerator {
    private static Faker faker = new Faker();

    public static Book generic() {
        String gender = faker.options().option("Полет дракона", "Странствия дракона", "Белый дракон");
        return null;
    }
    public static Book random(){
        return new Book(RandomStringUtils.randomAlphabetic(10) +"Полет дракона");
    }


}
