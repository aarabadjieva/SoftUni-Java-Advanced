import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book> {
    public final Comparator<Book> DEFAULT_COMPARATOR = new BookComparator();

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>();
        if (authors.length != 0) {
            this.authors.addAll(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book book) {
        int titleCompare = this.getTitle().compareTo(book.getTitle());
        return titleCompare != 0 ? titleCompare : book.getYear() - this.getYear();
    }
}
