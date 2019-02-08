// Omar Navarro
// CS 272
// 1/29/2019
// Lab 1

import java.util.Arrays;

public class Book 
{

	public static void main(String[] args) 
	{
		Book bookDefault = new Book();
		System.out.println(bookDefault.getAuthorNumber() + bookDefault.getISBN() + bookDefault.getTitle()); // test all accessors
		System.out.println(bookDefault.toString()); // test toString method
		bookDefault.setISBN("487934045"); // test setISBN mutator
		bookDefault.setTitle("Catch 22"); // test setTitle mutator
		bookDefault.addAuthor("Joseph Heller"); // author of catch 22 to check method
		bookDefault.addAuthor("Dr. Sues"); // random author to test method
		bookDefault.addAuthor("Omar Navarro"); // random author to test method
		bookDefault.addAuthor("Dr. Cao");  // checks if gives out of bounds error for 4 authors
		System.out.println(bookDefault.toString());
		
		Book bookTitleConstruct = new Book("The old man and the sea"); // call constructor with title parameter
		System.out.println(bookTitleConstruct.toString()); // test if title constructor worked
		System.out.println(bookTitleConstruct.equals(bookDefault)); // test equals method (should return false)
		bookTitleConstruct.setISBN("487934045"); // set ISBN to be equal to bookDefault object
		System.out.println(bookTitleConstruct.equals(bookDefault)); // test equals method (should return true)
		bookTitleConstruct.addAuthor("J.K. Rowling");
		bookTitleConstruct.addAuthor("Mark Twain");
		bookTitleConstruct.addAuthor("Omar Navarro");
		System.out.println(bookTitleConstruct.toString());
		System.out.println(Arrays.toString(Book.getAllAuthors(bookDefault, bookTitleConstruct))); // prints array returned by getAllAuthors method
		
		Book copyBook = new Book(bookDefault); // new book instance called copyBook
		System.out.println(copyBook.toString()); // tests copyBook using toString method
	}
	
	private String title;
	private int numAuthors;
	private String[] authors;
	private String isbn;
	
	public Book()
	{
		title = null;
		isbn = null;
		numAuthors = 0;
		authors = new String[3];
	}
	
	public Book(String _title)
	{
		title = _title;
		isbn = null;
		numAuthors = 0;
		authors = new String[3];
	}
	
	public Book(Object obj)
	{
		if (obj != null && obj instanceof Book)
		{
			title = ((Book) obj).getTitle();
			isbn = ((Book) obj).getISBN();
			numAuthors = ((Book) obj).getAuthorNumber();
			authors = ((Book) obj).getAuthors();
		}
	}
	
	public String[] getAuthors()
	{
		return authors;
	}
	public String getTitle()
	{
		return title;
	}
	
	public int getAuthorNumber()
	{
		return numAuthors; 
	}
	
	public String getISBN()
	{
		return isbn;
	}
	
	public void setTitle(String _title)
	{
		title = _title;
	}
	
	public void setISBN(String _isbn)
	{
		isbn = _isbn;
	}
	
	public boolean addAuthor(String _author)
	{
		if (numAuthors >= 3)
		{
			return false;
		}
		
		else
		{
			authors[numAuthors] = _author;
			numAuthors = numAuthors + 1;
			return true;		
		}
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Book && obj != null)
		{
			if (getISBN() == ((Book) obj).getISBN())
			{
				return true;
			}
			
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public static String[] getAllAuthors(Book b1, Book b2)
	{
		String[] distinctAuthors = new String[6];
		
		if (b1 != null && b2 != null)
		{
			for (int i = 0; i < 3; i = i + 1)
			{
				for (int j = 0; j < 3; j = j + 1)
				{
					if (b1.authors[i].equals(b2.authors[j]))
					{
						b2.authors[j] = null;
					}	
				}
			}
			
			for (int index = 0; index < 3; index = index + 1)
			{
				distinctAuthors[index] = b1.authors[index];
			}
			
			for (int index = 0; index < 3; index = index + 1)
			{
				distinctAuthors[index + 3] = b2.authors[index];
			}
			
			return distinctAuthors;
		}
		
		return distinctAuthors;
	}
	
	public String toString()
	{
		return String.format("%s, %s, %d %s, %s, %s", title, isbn, numAuthors, authors[0], authors[1], authors[2]);
	}
	
	

}
