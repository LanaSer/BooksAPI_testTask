package book;

public class Books {

    private String name;
    private String author;
    private int year;
    private boolean isElectronicBook;

    public Books(String name, String author, int year, boolean isElectronicBook) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.isElectronicBook = isElectronicBook;
    }

    public Books() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isElectronicBook(Boolean electronic) {
        return isElectronicBook;
    }

    public void setElectronicBook(boolean electronicBook) {
        isElectronicBook = electronicBook;
    }
}
