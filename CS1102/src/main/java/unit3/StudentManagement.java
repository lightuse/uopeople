package unit3;

import java.util.ArrayList; 
 
/** 
 * Student Management 
 */ 
class StudentManagement { 
    /** 
     * List of students in the system 
     */ 
    private static ArrayList<Student> students = new ArrayList<>(); 
    /** 
     * Total number of students in the system 
     */ 
    private static int totalStudents = 0; 
 
    /** 
     * Add a new student to the system 
     * @param name  student name 
     * @param id  student ID 
     * @param age  student age 
     * @param grade  student grade 
     */ 
    public static void addStudent(String name, int id, int age, char grade) { 
        Student newStudent = new Student(name, id, age, grade); 
        students.add(newStudent); 
        totalStudents++; 
        System.out.println("Student added successfully."); 
    } 
 
    /** 
     * Update student information 
     * @param id  student ID 
     * @param name  student name 
     * @param age  student age 
     * @param grade  student grade 
     */ 
    public static void updateStudent(int id, String name, int age, char grade) { 
        for (Student student : students) { 
            if (student.getId() == id) { 
                student.setName(name); 
                student.setAge(age); 
                student.setGrade(grade); 
                System.out.println("Student information updated successfully."); 
                return; 
            } 
        } 
        System.out.println("Student with ID " + id + " not found."); 
    } 
 
    /** 
     * View student details 
     * @param id  student ID 
     */ 
    public static void viewStudent(int id) { 
        for (Student student : students) { 
            if (student.getId() == id) { 
                System.out.println(student); 
                return; 
            } 
        } 
        System.out.println("Student with ID " + id + " not found."); 
    } 
 
    /** 
     * View all students in the system 
     */ 
    public static void viewAllStudents() { 
        if (students.isEmpty()) { 
            System.out.println("No students in the system."); 
            return; 
        } 
        students.forEach(System.out::println); 
    } 
 
    /** 
     * Get total number of students in the system 
     * @return total number of students 
     */ 
    public static int getTotalStudents() { 
        return totalStudents; 
    } 
} 
