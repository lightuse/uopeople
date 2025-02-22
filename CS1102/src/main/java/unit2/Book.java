package unit2;

/** 
 * Represents a book with a title, author, and quantity. 
 */
class Book { 
  /**
   * The title of the book.
   */
  String title;

  /**
   * The author of the book.
   */ 
  String author;

  /**
   * The quantity of the book.
   */ 
  int quantity; 

  /** 
   * Constructs a new Book with the specified title, author, and quantity. 
   * 
   * @param title    the title of the book 
   * @param author   the author of the book 
   * @param quantity the quantity of the book 
   */ 
  Book(String title, String author, int quantity) { 
      this.title = title; 
      this.author = author; 
      this.quantity = quantity; 
  } 

  /** 
   * Gets the quantity of the book. 
   * 
   * @return the quantity of the book 
   */ 
  public int getQuantity() { 
      return quantity; 
  } 

  /** 
   * Sets the quantity of the book. 
   * 
   * @param quantity the new quantity of the book 
   */ 
  public void setQuantity(int quantity) { 
      this.quantity = quantity; 
  } 

  /** 
   * Gets the title of the book. 
   * 
   * @return the title of the book 
   */ 
  public String getTitle() { 
      return title; 
  } 

  /** 
   * Gets the author of the book. 
   * 
   * @return the author of the book 
   */ 
  public String getAuthor() { 
      return author; 
  } 
} 