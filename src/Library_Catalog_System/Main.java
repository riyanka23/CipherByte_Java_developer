package Library_Catalog_System;  

import java.util.List;  
import java.util.Scanner;  

public class Main {  

    public static void main(String[] args) {  
        LibraryCatalog catalog = new LibraryCatalog();  
        Scanner sc = new Scanner(System.in); // Initialize once outside the loop  
        try {  
            while (true) {  
                System.out.println("\nLibrary Catalog System");  
                System.out.println("1. Add Book");  
                System.out.println("2. Search by Title");  
                System.out.println("3. Search by Author");  
                System.out.println("4. List All Books");  
                System.out.println("5. Exit");  
                System.out.print("Choose an option: ");  

                int choice;  
                try {  
                    choice = Integer.parseInt(sc.nextLine()); // Handle invalid input gracefully  
                } catch (NumberFormatException e) {  
                    System.out.println("Invalid input. Please enter a numeric value.");  
                    continue; // Go to the next iteration  
                }  

                switch (choice) {  
                    case 1:  
                        System.out.print("Enter book title: ");  
                        String title = sc.nextLine();  
                        System.out.print("Enter author name: ");  
                        String author = sc.nextLine();  
                        Book book = new Book(title, author);  
                        catalog.addBook(book);  
                        System.out.println("Book added successfully: " + book);  
                        break;  
                    case 2:  
                        System.out.print("Enter title to search: ");  
                        String searchTitle = sc.nextLine();  
                        List<Book> titleResults = catalog.searchByTitle(searchTitle);  
                        displaySearchResults(titleResults);  
                        break;  
                    case 3:  
                        System.out.print("Enter author to search: ");  
                        String searchAuthor = sc.nextLine();  
                        List<Book> authorResults = catalog.searchByAuthor(searchAuthor);  
                        displaySearchResults(authorResults);  
                        break;  
                    case 4:  
                        List<Book> allBooks = catalog.listBooks();  
                        if (allBooks.isEmpty()) {  
                            System.out.println("No books available.");  
                        } else {  
                            System.out.println("Books in the catalog:");  
                            for (Book b : allBooks) {  
                                System.out.println(b);  
   
                            }  
                        }  
                        break;  
                    case 5:  
                        System.out.println("Exiting the system.");  
                        return; // Exit the loop and end the program  
                    default:  
                        System.out.println("Invalid option. Please try again.");  
                }  
            }  
        } catch (Exception e) {  
            System.out.println("Error: " + e.getMessage());  
        } finally {  
            sc.close(); // Close the scanner here  
        }  
    }  

    private static void displaySearchResults(List<Book> results) {  
        if (results.isEmpty()) {  
            System.out.println("No books found.");  
        } else {  
            System.out.println("Search Results:");  
            for (Book book : results) {  
                System.out.println(book);  
            }  
        }  
    }  
}