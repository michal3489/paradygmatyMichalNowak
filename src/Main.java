import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Book("123-456-789", "Władca Pierścieni", "J.R.R. Tolkien"));
        library.addBook(new Book("987-654-321", "Hobbit", "J.R.R. Tolkien"));
        library.addMember(new Member(1, "Jan Kowalski"));
        library.addMember(new Member(2, "Anna Nowak"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu Biblioteki:");
            System.out.println("1. Dodaj książkę");
            System.out.println("2. Dodaj czytelnika");
            System.out.println("3. Wypożycz książkę");
            System.out.println("4. Zwróć książkę");
            System.out.println("5. Wyświetl dostępne książki");
            System.out.println("6. Wyświetl wypożyczenia");
            System.out.println("7. Wyjście");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumuj znak nowej linii

            switch (choice) {
                case 1:
                    System.out.print("Podaj ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Podaj tytuł: ");
                    String title = scanner.nextLine();
                    System.out.print("Podaj autora: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(isbn, title, author));
                    break;
                case 2:
                    System.out.print("Podaj ID czytelnika: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Podaj imię i nazwisko: ");
                    String name = scanner.nextLine();
                    library.addMember(new Member(memberId, name));
                    break;
                case 3:
                    System.out.print("Podaj ISBN książki do wypożyczenia: ");
                    String isbnToLend = scanner.nextLine();
                    System.out.print("Podaj ID czytelnika: ");
                    int memberIdToLend = scanner.nextInt();
                    scanner.nextLine();
                    library.lendBook(isbnToLend, memberIdToLend);
                    break;
                case 4:
                    System.out.print("Podaj ID wypożyczenia do zwrotu: ");
                    int loanIdToReturn = scanner.nextInt();
                    scanner.nextLine();
                    library.returnBook(loanIdToReturn);
                    break;
                case 5:
                    library.displayAvailableBooks();
                    break;
                case 6:
                    library.displayLoans();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }

        scanner.close();
    }
}