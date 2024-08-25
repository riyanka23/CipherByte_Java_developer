package Library_Catalog_System;

public class Book 
{
	private String title;
	private String author;
	
	
	public Book() {
		super();
	}


	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
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


	@Override  
    public String toString() {  
        return "Title: " + title + ", Author: " + author;  
    }
	
	
}