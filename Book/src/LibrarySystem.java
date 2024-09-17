import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {
    private Map<String, Book> library; // private map

    public LibrarySystem() {
        library = new HashMap<>();
    }

    // For add books to the library
    public void addBook(String title, String author, int quantity) {
        if (library.containsKey(title)) {
            Book existingBook = library.get(title);
            existingBook.setQuantity(existingBook.getQuantity() + quantity);
        } else {
            Book newBook = new Book(title, author, quantity);
            library.put(title, newBook);
        }
    }

    // For borrow books from the library
    public void borrowBook(String title, int quantity) {
        if (library.containsKey(title)) {
            Book book = library.get(title);
            if (book.getQuantity() >= quantity) {
                book.setQuantity(book.getQuantity() - quantity);
                System.out.println("Successfully borrowed " + quantity + " copies of " + title);
            } else {
                System.out.println("Error: Insufficient copies of " + title + " available");
            }
        } else {
            System.out.println("Error: " + title + " not found in the library");
        }
    }

    // For return books to the library
    public void returnBook(String title, int quantity) {
        if (library.containsKey(title)) {
            Book book = library.get(title);
            book.setQuantity(book.getQuantity() + quantity);
            System.out.println("Successfully returned " + quantity + " copies of " + title);
        } else {
            System.out.println("Error: " + title + " not found in the library");
        }
    }

    /* 
    Display message when user enter to the program 
    where he can decide what he want to do the library
    */ 
    public void showMenu() {
        System.out.println("Welcome to Library System. What you want to do? Please enter a number from following.");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        // display menu for each function

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume a next line

        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                addBook(title, author, quantity);
                showMenu();
                break;
            case 2:
                System.out.print("Enter book title to borrow: ");
                String borrowTitle = scanner.nextLine();
                System.out.print("Enter quantity to borrow: ");
                int borrowQuantity = scanner.nextInt();
                borrowBook(borrowTitle, borrowQuantity);
                showMenu();
                break;
            case 3:
                System.out.print("Enter book title to return: ");
                String returnTitle = scanner.nextLine();
                System.out.print("Enter quantity to return: ");
                int returnQuantity = scanner.nextInt();
                returnBook(returnTitle, returnQuantity);
                showMenu();
                break;
            case 4:
                System.out.println("Thank you for you visit!");
                break;
            default:
                System.out.println("Invalid menu number! Enter valid number.");
                showMenu();
                break;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.showMenu();
    }
}

// - - - - - - - - - - - - - - - - 

// Book class to represent individual books in the library
class Book {
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
