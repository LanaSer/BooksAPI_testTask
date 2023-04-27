package client;

import com.github.javafaker.Faker;


public class BookGenerator {
    private static Faker faker = new Faker();

    String name = faker.options().option("Полет дракона", "Странствия дракона", "Белый дракон");

}
