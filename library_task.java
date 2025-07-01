package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Book{
	
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private int bookQuantity;
	private double bookPrice;

	public Book(int bookId, String bookName, String bookAuthor, String bookPublisher, int bookQuantity,
			double bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
	}
	
	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!(obj instanceof Book))
			return false;
		
		Book other = (Book) obj;
		return  this.bookId == other.bookId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPublisher="
				+ bookPublisher + ", bookQuantity=" + bookQuantity + ", bookPrice=" + bookPrice + "]";
	}

}

public class CollectionOfBook {
	
	private final List<Book> books=new LinkedList<>();
	
	private final Scanner scan=new Scanner(System.in);
	
	public void promptForAddBooks() {
		System.out.print("Enter an id: ");
		int bookId=scan.nextInt();
		scan.nextLine();
		
		System.out.print("Enter the book name: ");
		String bookName=scan.nextLine();
		
		System.out.print("Enter the author: ");
		String bookAuthor=scan.nextLine();
		
		System.out.print("Enter the publisher: ");
		String bookPublisher=scan.nextLine();
		
		System.out.print("Enter the quantity: ");
		int bookQuantity=scan.nextInt();
		
		System.out.print("Enter the price of the book: ");
		double bookPrice=scan.nextDouble();
		
		System.out.println("Book added successfully.");
		
		addBooks(new Book(bookId,bookName,bookAuthor,bookPublisher,bookQuantity,bookPrice));
	}
	
	public void addBooks(Book book) {
		for(Book b:books) {
			if (b.getBookId() == book.getBookId()) {
                System.out.println("Book with ID " + book.getBookId() + " already exists.\n");
                return;
            }
        }
        books.add(book);
	}

	 public List<Book> getBooksByAuthor(String author) {
         List<Book> result = new LinkedList<>();
         for (Book b : books) {
             if (b.getBookAuthor().equalsIgnoreCase(author)) {
                 result.add(b);
             }
         }
         return result;
     }
	
	 public Book findBookById(int id) {
         for (Book b : books) {
             if (b.getBookId() == id) {
                 return b;
             }
         }
         return null;
     }
	
	 public boolean removeBook(int id) {
         for (int i = 0; i < books.size(); i++) {
             if (books.get(i).getBookId() == id) {
                 books.remove(i);
                 return true;
             }
         }
         return false;
     }
	 public boolean updateBookQuantity(int id, int newQty) {
         for (Book b : books) {
             if (b.getBookId() == id) {
                 b.setBookQuantity(newQty);
                 return true;
             }
         }
         return false;
     }
	 
	public List<Book> getBooksSortedByName() {
		
		for(int i=0;i<books.size();i++) {
			for(int j=i+1;j<books.size();j++) {
				if(books.get(i).getBookName().compareTo(books.get(j).getBookName()) > 0) {
					Book temp=books.get(j);
					books.set(j,books.get(i));
					books.set(i, temp);
				}
			}
		}
		return books;
		
	}
	
	public int countBooksByPublisher(String publisher) {
        int count = 0;
        for (Book b : books) {
            if (b.getBookPublisher().equalsIgnoreCase(publisher)) {
                count++;
            }
        }
        return count;
    }
	 public List<String> getAllBookTitles() {
          List<String> titles = new LinkedList<>();
          for (Book b : books) {
              titles.add(b.getBookName());
          }
          return titles;
      }
	 public boolean bookExists(String title) {
         for (Book b : books) {
             if (b.getBookName().equalsIgnoreCase(title)) {
                 return true;
             }
         }
         return false;
     }
	
	 public int getTotalQuantity() {
         int total = 0;
         for (Book b : books) {
             total += b.getBookQuantity();
         }
         return total;
     }
	 
	 public void run() {
		 System.out.println("------- Library ---------");
		 while(true) {
			 System.out.println("Books menu: ");
			 System.out.println("1. Add a book");
             System.out.println("2. Show books by author");
             System.out.println("3. Find book by ID");
             System.out.println("4. Remove a book");
             System.out.println("5. Update quantity");
             System.out.println("6. List books (sorted)");
             System.out.println("7. Count books by publisher");
             System.out.println("8. List all titles");
             System.out.println("9. Check if title exists");
             System.out.println("10. Total quantity in stock");
             System.out.println("0. Exit");
             System.out.print("Choose > ");
             
             int choice=scan.nextInt();
             
             switch(choice) {
             case 1:{
            	 promptForAddBooks();
            	 break;
             }
             case 2:{
            	 System.out.print("Author name: ");
            	 scan.nextLine();
                 String auth = scan.nextLine();
                 List<Book> list = getBooksByAuthor(auth);
                 System.out.println(list.isEmpty() ? "No books found." : list);
                 break;
             }
             case 3:{
            	 System.out.println("Id: ");
            	 int id=scan.nextInt();
            	 Book found=findBookById(id);
            	 System.out.println(found != null ? found : "Not found.");
            	 break;
             }
             case 4:{
            	 System.out.println("Id: ");
            	 int id=scan.nextInt();
            	 System.out.println(removeBook(id) ? "Removed." : "Not found.");
            	 break;
             }
             case 5:{
            	 System.out.println("Id: ");
            	 int id=scan.nextInt();
            	 System.out.print("New qty: ");
            	 int qty=scan.nextInt();
            	 System.out.println(updateBookQuantity(id, qty) ? "Updated." : "Not found.");
            	 break;
             }
             case 6:{
            	 System.out.println("Get Books Sorted By Name: ");
            	 for(Book b:getBooksSortedByName()) {
            		 System.out.println(b);
            	 }
            	 break;
             }
             case 7:{
            	 System.out.print("Publisher: ");
                 String pub = scan.nextLine();
                 System.out.println("Count = " + countBooksByPublisher(pub));
                 break;
             }
             case 8:{
            	 List<String> titles = getAllBookTitles();
                 System.out.println(" "+ titles);
                 break;
             }
             case 9:{
            	 System.out.print("Title: ");
                 System.out.println(bookExists(scan.nextLine()));
                 break;
             }
             case 10:{
            	 System.out.println("Total quantity = " + getTotalQuantity());
                 break;
             }
             case 0:{
            	 System.out.println("Exited.\nGood Bye!");
            	 return;
             }
             default:{
            	 System.out.println("Invalid option. Try again.");
             }
             }
             System.out.println("----------------");
		 }
	 }

	
	public static void main(String[] args) {
		CollectionOfBook cb=new CollectionOfBook();
		cb.run();

	}

}