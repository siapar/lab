import java.util.Scanner;

public class Main {
    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {

        bookManager.addBook(new Book("Lalka", "Bolesław Prus", "1", 1890));
        bookManager.addBook(new Book("Potop", "Henryk Sienkiewicz", "2", 1886));
        bookManager.addBook(new Book("Przedwiośnie", "Stefan Żeromski", "3", 1924));
        bookManager.addBook(new Book("Tango", "Słamowir Mrożek", "4", 1964));
        bookManager.addBook(new Book("Makbet", "William Szekspir", "5", 1623));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj książkę");
            System.out.println("2. Usuń książkę");
            System.out.println("3. Zaktualizuj książkę");
            System.out.println("4. Wyświetl liste książek");
            System.out.println("5. Wyjdź");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookManager.addBook(scanner);
                    break;
                case 2:
                    bookManager.removeBook(scanner);
                    break;
                case 3:
                    bookManager.updateBook(scanner);
                    break;
                case 4:
                    bookManager.displayBooks();
                    break;
                case 5:
                    System.out.println("Program zakończony.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Niepoprawna opcja, wybierz spośród 1-5.");
            }
        }
    }
}