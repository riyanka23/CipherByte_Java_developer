package Library_Catalog_System;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog 
{
	private ArrayList<Book> books;

	
	public LibraryCatalog() 
	{
		super();
		this.books=new ArrayList<Book>();
	}

	public LibraryCatalog(ArrayList<Book> books) {
		super();
		this.books = new ArrayList<>(books);
	}
	
	public void addBook(Book book) {  
	    if (books == null) {  
	        books = new ArrayList<>();  
	    }  
	    books.add(book);  
	    System.out.println("Book is Added: " + book);  
	}
	
	public List<Book> searchByTitle(String title)
	{
		ArrayList<Book> results= new ArrayList<Book>();
		for (Book book : books) 
		{
			if(book.getTitle().equalsIgnoreCase(title))
			{
				results.add(book);
			}
		}
		return results;
	}
	
	public List<Book> searchByAuthor(String author)
	{
		ArrayList<Book> results= new ArrayList<Book>();
		for (Book book : books) 
		{
			if(book.getAuthor().equalsIgnoreCase(author))
			{
				results.add(book);
			}
		}
		return results;
	}
	
	 public List<Book> listBooks() {  
	        if (books.isEmpty()) {  
	            System.out.println("No books available..");  
	            return new ArrayList<>(); // Return an empty list  
	        } else {  
	            System.out.println("Books in the catalog:");  
	            return new ArrayList<>(books); // Return a copy of the books list  
	        }  
	    }  
	 
	   
	
	
}
