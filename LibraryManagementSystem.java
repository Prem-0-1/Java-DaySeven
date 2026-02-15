import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("----------------------");
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (Book book : books) {
                book.displayBook();
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book("Java Programming", "James Gosling", "101");
        Book b2 = new Book("Data Structures", "Mark Allen Weiss", "102");

        library.addBook(b1);
        library.addBook(b2);

        System.out.println("\nAll Books:");
        library.displayAllBooks();

        System.out.println("\nSearching for 'Java Programming':");
        Book found = library.searchByTitle("Java Programming");

        if (found != null) {
            found.displayBook();
        } else {
            System.out.println("Book not found.");
        }
    }
}
