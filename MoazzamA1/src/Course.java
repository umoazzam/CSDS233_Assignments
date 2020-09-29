/*
Usman Moazzam, CSDS 233, Assignment #1: Course and CourseList
Course is an object that stores information about a given course, such as the course's ID, name and
capacity.
 */

public class Course {

   // stores course ID
   public String courseID;
   // stores name of course
   public String courseName;
   // stores capacity of course
   public int capacity;

   // initializes values for the course ID, name and capacity
   public Course(String courseID, String courseName, int capacity) {
      if (courseID == null || courseID.isBlank()) {
         throw new IllegalArgumentException("Course ID cannot be blank or null");
      }

      if (courseName == null || courseName.isBlank()) {
         throw new IllegalArgumentException("Course name cannot be blank or null");
      }

      if (capacity <= 0) {
         throw new IllegalArgumentException("Capacity must be greater than 0");
      }

      this.courseID = courseID;
      this.courseName = courseName;
      this.capacity = capacity;
   }

}
