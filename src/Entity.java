import java.util.Date;

class Book {
    String isbn;
    String title;
    String author;
    boolean available;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Gettery i settery (dla uproszczenia pominięte, ale zalecane)
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Tytuł: " + title + ", Autor: " + author + ", Dostępna: " + available;
    }
}

class Member {
    int memberId;
    String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Gettery i settery
    public int getMemberId() { return memberId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "ID: " + memberId + ", Imię: " + name;
    }
}

class Loan {
    int loanId;
    Book book;
    Member member;
    Date loanDate;
    Date returnDate;

    public Loan(int loanId, Book book, Member member) {
        this.loanId = loanId;
        this.book = book;
        this.member = member;
        this.loanDate = new Date(); // Aktualna data
    }

    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return "ID wypożyczenia: " + loanId + ", Książka: " + book.getTitle() + ", Czytelnik: " + member.getName() + ", Data wypożyczenia: " + loanDate + ", Data zwrotu: " + returnDate;
    }
}