/*
 * File: BookDescription.java
 */


import java.util.*;
import zhstructures.*;
import ajnstructures.*;

/**
 * Class BookDescription
 * 
 * @author Andrew Nerud, Colin Glynn
 * @version TODAY'S 11/16/22
 */
public class BookDescriptionV2 {
  
  /**
   * the author of the book
   */
  private String author;
  
  /**
   * The title of the book
   */
  private String title;
  
  /**
   * The publisher of the book
   */
  private String publisher;
  
  /**
   * The date of publishing
   */
  private int date;
  
  /**
   * The rating of the book
   */
  private char rating;
  
  /**
   * The number of pages the book has
   */
  private int pages;
  
  /**
   * The book's description
   */
  private String description;
  
  /**
   * Creates a new book description with all paramters of the entire class
   * 
   * @param author the author of the book
   * @param title the title of the book
   * @param publisher the publisher of the book
   * @param date the date of publishing
   * @param rating the rating of the book
   * @param pages the number of pages
   * @param description a description of the book
   */
  public BookDescriptionV2(String author, String title, String publisher, int date, char rating, int pages, String description) {
    this.author = author;
    this.title = title;
    this.publisher = publisher;
    this.date = date;
    this.rating = rating;
    this.pages = pages;
    this.description = description;
  }
  
  /**
   * Creates a new book description with the specified author and title.
   * 
   * @param author the author of the book
   * @param title the title of the book
   */
  public BookDescriptionV2(String author, String title) {
    this.author = author;
    this.title = title;
    this.publisher = null;
    this.date = -1;
    this.rating = ' ';
    this.pages = -1;
    this.description = null;
  }
  
  /**
   * Creates a new book description with no parameters filled in.
   * 
   */
  public BookDescriptionV2() {
    this.author = null;
    this.title = null;
    this.publisher = null;
    this.date = -1;
    this.rating = ' ';
    this.pages = -1;
    this.description = null;
  }
  
  //add another constructor with takes in parameters for ALL class fields
  // Put in necessary get() and set() methods
  
  /**
   * Getter for the book's author
   */
  public String getAuthor() {
    return author;
  }
 
  /**
   * Getter for the book's title
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * Getter for the book's publisher
   */
  public String getPublisher() {
    return publisher;
  }
  
  /**
   * Setter for the book's publisher
   * 
   * @param publisher a String publisher
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  
  /**
   * Getter for the book's publishing date
   */
  public int getDate() {
    return date;
  }
  
  /**
   * Setter for the book's date of publishing
   * 
   * @param date an int date
   */
  public void setDate(int date) {
    this.date = date;
  }
  
  /**
   * Getter for the book's rating
   */
  public char getRating() {
    return rating;
  }
  
  /**
   * Setter for the book's rating
   * 
   * @param rating a char rating
   */
  public void setRating(char rating) {
    this.rating = rating;
  }
  
  /**
   * Getter for the book's number of pages
   */
  public int getPages() {
    return pages;
  }
  
  /**
   * Setter for the book's number of pages
   * 
   * @param pages an int pages
   */
  public void setPages(int pages) {
    this.pages = pages;
  }
  
  /**
   * Getter for the book's description
   */
  public String getDescription() {
    return description;
  }
  
  /**
   * Setter for the book's description
   * 
   * @param description a String description
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return author+"\n" + title +"\n" + publisher +"\n" + date +"\n" + rating +"\n" + pages +"\n" + description;
    
  }
  
}
