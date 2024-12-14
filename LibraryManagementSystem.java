
import java.util.*;

public class LibraryManagementSystem {
  
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("Cody's Programming Journey", "Cody Anderson", 2023, 5));
        library.addBook(new Book("Slice of Life", "John Doe", 2020, 3));

        library.copyBook("Cody's Programming Journey");
        library.displayBooks();
    }
}

interface CopyInterface {
    void copyFrom(Object other);
}

class Book implements CopyInterface {
    String title;
    String author;
    int year;
    int availableCopies;

    Book(String title, String author, int year, int availableCopies) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.availableCopies = availableCopies;
    }

    @Override
    public void copyFrom(Object other) {
        if (other instanceof Book) {
            Book otherBook = (Book) other;
            this.title = otherBook.title;
            this.author = otherBook.author;
            this.year = otherBook.year;
            this.availableCopies = otherBook.availableCopies;
        }
    }

    void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Available copies: " + availableCopies);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void copyBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                Book newBook = new Book(null, null, 0, 0);
                newBook.copyFrom(book);
                books.add(newBook);
                System.out.println("Book copied successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void displayBooks() {
        for (Book book : books) {
            book.displayBookDetails();
            System.out.println();
        }
    }
}
