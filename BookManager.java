import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements BookOperations {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index >= 0) {
            books.set(index, newBook);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Scanner scanner) {
        System.out.println("Podaj tytuł:");
        String title = scanner.nextLine();
        System.out.println("Podaj autora:");
        String author = scanner.nextLine();
        System.out.println("Podaj ISBN:");
        String isbn = scanner.nextLine();
        int year = 0;
        boolean validYear = false;
        while (!validYear) {
            try {
                System.out.println("Podaj rok wydania:");
                year = Integer.parseInt(scanner.nextLine());
                validYear = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj rok składający się tylko z cyfr.");
            }
        }

        Book book = new Book(title, author, isbn, year);
        addBook(book);
        System.out.println("Książka dodana.");
    }

    public void removeBook(Scanner scanner) {
        System.out.println("Podaj ISBN książki do usunięcia:");
        String isbn = scanner.nextLine();
        Book bookToRemove = findBookByIsbn(isbn);

        if (bookToRemove != null) {
            removeBook(bookToRemove);
            System.out.println("Książka usunięta.");
        } else {
            System.out.println("Nie znaleziono książki o podanym ISBN.");
        }
    }

    public void updateBook(Scanner scanner) {
        System.out.println("Podaj ISBN książki do zaktualizowania:");
        String isbn = scanner.nextLine();
        Book oldBook = findBookByIsbn(isbn);

        if (oldBook != null) {
            System.out.println("Podaj nowego autora:");
            String newAuthor = scanner.nextLine();
            System.out.println("Podaj nowy tytuł:");
            String newTitle = scanner.nextLine();
            System.out.println("Podaj nowy ISBN:");
            String newIsbn = scanner.nextLine();
            int newYear = 0;
            boolean validYear = false;
            while (!validYear) {
                try {
                    System.out.println("Podaj nowy rok wydania:");
                    newYear = Integer.parseInt(scanner.nextLine());
                    validYear = true;
                } catch (NumberFormatException e) {
                    System.out.println("Podaj rok składający się tylko z cyfr.");
                }
            }

            Book newBook = new Book(newTitle, newAuthor, newIsbn, newYear);
            updateBook(oldBook, newBook);
            System.out.println("Książka zaktualizowana.");
        } else {
            System.out.println("Nie znaleziono książki o podanym ISBN.");
        }
    }

    public void displayBooks() {
        for (Book book : getBooks()) {
            System.out.println(book);
        }
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
