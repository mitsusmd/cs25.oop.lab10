import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Library {
    public class BookShelf implements Iterable<Book> {
        private List<Book> books;
        private int minYear;

        // Iterable<Book>-ыг хэрэгжүүлж iterator() метод бичих [cite: 14]
        @Override
        public Iterator<Book> iterator() {
            List<Book> filtered = new ArrayList<>();
            for (Book b : books) {
                if (b.getYear() >= minYear) { // minYear-с хойшхи номнууд [cite: 15]
                    filtered.add(b);
                }
            }
            return filtered.iterator();
        }
    }
}