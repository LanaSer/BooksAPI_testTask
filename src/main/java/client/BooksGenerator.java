package client;

import com.github.javafaker.Faker;

public class BooksGenerator {
    private static Faker faker = new Faker();
    String name = faker.options().option("Философский камень", "Тайная комната", "Узник Азкабана");
    String author = faker.options().option("Роулинг Джоан");
    int year = faker.options().option(1997, 1998, 1999);
    Boolean electronic = faker.options().option(true, false);

}



