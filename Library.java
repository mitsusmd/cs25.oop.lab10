import java.util.*;

class Book {
    private String title;
    private int year;
    public Book(String title, int year) { this.title = title; this.year = year; }
    public int getYear() { return year; }
    @Override
    public String toString() { return title + ": " + year; }
}

public class Library {
    private List<Book> books = new ArrayList<>();
    public void addBook(Book b) { books.add(b); }

    public class BookShelf implements Iterable<Book> {
        private int minYear;
        public BookShelf(int minYear) { this.minYear = minYear; }

        @Override
        public Iterator<Book> iterator() {
            // minYear-с хойшхи номнуудыг шүүх[cite: 1]
            return books.stream().filter(b -> b.getYear() >= minYear).iterator();
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Suun zam", 2020));
        lib.addBook(new Book("Huuchnii tuuh", 1990));

        Library.BookShelf shelf = lib.new BookShelf(2000);
        for (Book b : shelf) {
            System.out.println(b); // Гаралт: Сүүн Зам: 2020[cite: 1]
        }
    }
}