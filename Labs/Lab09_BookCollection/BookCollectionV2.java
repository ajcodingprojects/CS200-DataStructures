/*
 * File: BookCollection.java
 */

 
import java.util.*;
import java.io.*;
import zhstructures.*;
import ajnstructures.*;
/**
 * Class BookCollection
 * 
 * @author Andrew Nerud, Colin Glynn
 * @version TODAY'S 11/16/22
 */
public class BookCollectionV2 {
  
  /**
   * library is a Map associating authors (the String) with the
   * collection of books they have written (the map of BookDescriptionV2).
   */ 
  private ZHMap<String, ZHMap<String, BookDescriptionV2>> library;
  
  /**
   * This constructor will read in all the information for books and
   * insert the author name associated with this book entry into the
   * library. You will need to organize your file in such a way that
   * this is reasonably easy to do. I have included a very short
   * sample library showing one way to organize. (I use a _ to separate
   * one book from the next.)
   * 
   * @param fileName the path to the file containing the book information
   * @throws FILL IN APPROPRIATE EXCEPTION INFORMATION.
   */
  public BookCollectionV2(String fileName) {
    this.library = new AJNTreeMap<>();
    try {
      Scanner sc = new Scanner(new File(fileName)); 
      
      while(sc.hasNextLine()) {
        String author = sc.nextLine();
        String title = sc.nextLine();
        String publisher = sc.nextLine();
        int date = sc.nextInt();
        sc.nextLine();
        char rating = sc.nextLine().charAt(0);
        int pages = sc.nextInt();
        sc.nextLine();
        String desc = "";
        String nextDesc = sc.nextLine();
        while(!nextDesc.equals("_")) {
          desc += nextDesc + " ";
          nextDesc = sc.nextLine();
        }
        BookDescriptionV2 nextBook = new BookDescriptionV2(author, title, publisher, date, rating, pages, desc);
        
        if (!library.contains(author))
          library.put(author, new AJNTreeMap<>());
        if (!library.get(author).contains(title))
          library.get(author).put(title, nextBook);
        
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }
  
  /**
   * The default constructor for the class
   */
  public BookCollectionV2() {
    this.library = new AJNTreeMap<>();
  }
  
  // put in appropriate methods
  /**
   * Retruns an iterator over all authors in the library
   * 
   * @return Iterator
   */
  public Iterator<String> allAuthors() {
    return library.iterator();
  }
  
  /**
   * Retruns an iterator over all titles for a given author in the library
   * 
   * @param author is the String given to search for book titles
   * @return Iterator
   */
  public Iterator<String> allAuthorTitles(String author) {
    try {
      return library.get(author).iterator();
    } catch (NullPointerException n) {
      return null; 
    }
  }
  
  /**
   * Retruns a BookDescriptionV2 over a given title and author in the library
   * 
   * @param author is the String given 
   * @param title is the String given to search for book description
   * @return Iterator
   */
  public BookDescriptionV2 get(String author, String title) {
    try {
      return library.get(author).get(title); 
    } catch (NullPointerException n) {
      return null; 
    }
  }
  
  /**
   * Adds the given BookDescriptionV2 object to the collection in the author's inner map
   * 
   * @param bd is the given BookDescriptionV2
   */
  public void add(BookDescriptionV2 bd) {
    if (!library.contains(bd.getAuthor()))
      library.put(bd.getAuthor(), new AJNTreeMap<>());
    library.get(bd.getAuthor()).put(bd.getTitle(), bd);
  }
  
  /**
   * Removes the BookDesciption of the given author and title
   * 
   * @param author is the given author key
   * @param title is the given title key
   */
  public void remove(String author, String title) {
    if(library.contains(author) && library.get(author).contains(title)) 
      library.get(author).remove(title);
  }
  
  /**
   * updates the BookDesciption of the given author and title and new description
   * 
   * @param author is the given author key
   * @param title is the given title key
   * @param description is a string of the new book description
   */
  public void update(String author, String title, String description) {
    if(library.contains(author) && library.get(author).contains(title))
      library.get(author).get(title).setDescription(description);
  }
  
  
  /**
   * this method writes the book description to a given file
   * 
   * @param fileName is the given filename to write to 
   */
  public void write(String fileName) {
    try {
      PrintWriter pw = new PrintWriter(new File(fileName));
      for (String author: library) {
        for (String title: library.get(author)) {
          pw.println(library.get(author).get(title));
          pw.println("_");
        }
      }
      pw.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println(e); 
    }
  }
  
  /**
   * checks if the collection is empty 
   * 
   * @returns ture if the collection is empty
   */
  public boolean isEmpty() {
    return library.isEmpty();
  }
  
  /**
   * gets the size of the book collection
   * 
   * @returns the size of the collection as an integer
   */
  public int size() {
    return library.size(); 
  }
  
  /**
   * Programs main method / driver class
   */
  public static void main (String args[]) {
    System.out.println("*********************TestingReading**************************");
    BookCollectionV2 bc = new BookCollectionV2("sampleLibrary.BookCollection");
    print(bc);
    
    System.out.println("*********************TestingUpdating**************************");
    bc.update("Delany, Samuel", "Stars in My Pocket Like Grains of Sand", "This is a new description as a test!!");
    System.out.println(bc.get("Delany, Samuel", "Stars in My Pocket Like Grains of Sand"));
    
    System.out.println("*********************TestingAdding**************************");
    BookDescriptionV2 bd = new BookDescriptionV2("Glynn, Andrew", "Go Johnnies", "GoJOhnnies.com", 1856, 'A', 420, "GoJohnnies!!!!");
    bc.add(bd);
    print(bc);
    
    System.out.println("*********************TestingRemoving**************************");
    bc.remove("Asimov, Isaac", "Foundation");
    print(bc);
    
    System.out.println("*********************TestingWriting**************************");
    bc.write("WriteTest.txt");
    BookCollectionV2 bc2 = new BookCollectionV2("WriteTest.txt");
    print(bc2);
  }
  
  /**
   * Helper method to print all authors and their books 
   * 
   * @param bc is the passed book collection to print
   */ 
  public static void print(BookCollectionV2 bc) {
    Iterator<String> authors = bc.allAuthors();
    while (authors.hasNext()) {
      String a = authors.next();
      System.out.println(a);
      Iterator<String> titles = bc.allAuthorTitles(a);
      while (titles.hasNext()) {
        System.out.println("\t-"+titles.next());
      }
    }
  }
}


