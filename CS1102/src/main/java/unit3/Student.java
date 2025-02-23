package unit3;

/** 
 * Student class 
 */ 
class Student { 
  /** 
   * Student name 
   */ 
  private String name; 
  /** 
   * Student ID 
   */ 
  private int id; 
  /** 
   * Student age 
   */ 
  private int age; 
  /** 
   * Student grade 
   */ 
  private char grade; 

  /** 
   * Constructor 
   * @param name  student name 
   * @param id  student ID 
   * @param age  student age 
   * @param grade  student grade 
   */ 
  public Student(String name, int id, int age, char grade) { 
      this.name = name; 
      this.id = id; 
      this.age = age; 
      this.grade = grade; 
  } 

  /** 
   * Getters and Setters 
   * @return 
   */ 
  public String getName() { 
      return name; 
  } 

  /** 
   * Set student name 
   * @param name 
   */ 
  public void setName(String name) { 
      this.name = name; 
  } 

  /** 
   * Get student ID 
   * @return 
   */ 
  public int getId() { 
      return id; 
  } 

  /** 
   * Set student ID 
   * @param id 
   */ 
  public void setId(int id) { 
      this.id = id; 
  } 

  /** 
   * Get student age 
   * @return student age 
   */ 
  public int getAge() { 
      return age; 
  } 

  /** 
   * Set student age 
   * @param age 
   */ 
  public void setAge(int age) { 
      this.age = age; 
  } 

  /** 
   * Get student grade 
   * @return student grade 
   */ 
  public char getGrade() { 
      return grade; 
  } 

  /** 
   * Set student grade 
   * @param grade 
   */ 
  public void setGrade(char grade) { 
      this.grade = grade; 
  } 

  /** 
   * Override toString method 
   * @return student details 
   */ 
  @Override 
  public String toString() { 
      return String.format("Student ID: %d, Name: %s, Age: %d, Grade: %s", id, name, age, grade); 
  } 
} 
