import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private int nextLoanId = 1; // Do generowania unikalnych ID wypożyczeń

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void lendBook(String isbn, int memberId) {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);

        if (book != null && member != null && book.isAvailable()) {
            Loan loan = new Loan(nextLoanId++, book, member);
            loans.add(loan);
            book.setAvailable(false);
            System.out.println("Książka wypożyczona: " + loan);
        } else {
            System.out.println("Nie można wypożyczyć książki.");
        }
    }

    public void returnBook(int loanId) {
        for (Loan loan : loans) {
            if (loan.loanId == loanId && loan.returnDate == null) {
                loan.setReturnDate(new Date());
                loan.book.setAvailable(true);
                System.out.println("Książka zwrócona: " + loan);
                return;
            }
        }
        System.out.println("Nie znaleziono wypożyczenia o podanym ID lub książka została już zwrócona.");
    }


    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.memberId == memberId) {
                return member;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        System.out.println("Dostępne książki:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void displayLoans() {
        System.out.println("Wypożyczenia:");
        for(Loan loan: loans) {
            System.out.println(loan);
        }
    }
}
