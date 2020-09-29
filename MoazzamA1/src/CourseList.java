/*
Usman Moazzam, CSDS 233, Assignment #1: Course and CourseList
CourseList is a data structure that stores a list of courses inputted by the client, allowing the
client to alter the specific courses, add and remove courses, and recall the size of the
course list as well as the specific course IDs, course names, and list indexes associated with each
of the courses.
 */

import java.util.ArrayList;
import java.util.List;

public class CourseList {

   // maximum # of courses
   private final int MAX_COURSES = 10;

   // data structure storing the courses
   private final Course[] listOfCourses = new Course[MAX_COURSES];

   // initializes list of courses using the MAX_COURSE standard
   public CourseList() {}

   // returns the number of courses in the current list
   public int size() {
      System.out.println("Operation: Compute and return number of classes");
      System.out.println("Course List:");
      courseListInfo();

      int currCourse = 0;

      // finding first null position in list
      while (listOfCourses[currCourse] != null) {
         currCourse++;
      }

      System.out.println("Result: " + currCourse + " classes total.");
      System.out.println();
      return currCourse;
   }

   // same as size method, without operation printing; for use in class methods
   private int sizePrivate() {
      int currCourse = 0;

      // finding first null position in list
      while (listOfCourses[currCourse] != null) {
         currCourse++;
      }
      return currCourse;
   }

   // adds a course to index i; if index is too large, adds to the end of the list
   public void addCourse(int i, Course course) {
      methodInfo("Add a course to index " + i, course);

      // if i is greater than the size, places at the end of the list
      // else places at desired index i
      if (i >= sizePrivate() || i < 0) {
         listOfCourses[sizePrivate()] = course;
      } else {
         // if index is empty, places course at that index
         // else places course at that index and shifts other entries
         if (listOfCourses[i] == null) {
            listOfCourses[i] = course;
         } else {
            int currCourse = i;
            Course temp = course;
            Course nextCourse = null;

            // shifts other courses
            while (temp != null) {
               nextCourse = listOfCourses[currCourse];
               listOfCourses[currCourse] = temp;
               temp = nextCourse;
               currCourse++;
            }
         }
      }

      System.out.println("List after the operation:");
      courseListInfo();
   }

   // removes course at index i; if index is too large, removal fails
   public boolean removeCourse(int i) {
      if (i >= sizePrivate()) {
         System.out.println("Operation: Remove course at index " + i);
         System.out.println("Given index too large, operation failed.");
         System.out.println();
         return false;
      } else if (i < 0) {
         System.out.println("Operation: Remove course at index " + i);
         System.out.println("Given index too small, operation failed.");
         System.out.println();
         return false;
      } else {
         Course course = getCourseWithIndex(i);
         methodInfo("Remove course at index " + i, course);

         listOfCourses[i] = listOfCourses[i + 1];
         int currCourse = i + 1;

         while (listOfCourses[currCourse + 1] != null) {
            listOfCourses[currCourse] = listOfCourses[currCourse + 1];
            currCourse++;
         }
         listOfCourses[currCourse] = null;

         // after operation text
         System.out.println("List after the operation:");
         courseListInfo();
         return true;
      }

   }

   // changes the capacity of course, searched using courseID;
   // if given courseID not associated with a course, operation fails
   public boolean changeCapacity(String courseID, int capacity) {
      List<Integer> indices = new ArrayList<>();

      for (int i = 0; i < sizePrivate(); i++) {
         if (listOfCourses[i].courseID.equals(courseID)) {
            indices.add(i);
         }
      }

      if (!indices.isEmpty()) {
         System.out.println("Operation: Change the capacity of a course to " + capacity);
         for (int index : indices) {
            courseInfo(listOfCourses[index]);
         }
         System.out.println("List before the operation:");
         courseListInfo();
         System.out.println();

         for (int index : indices) {
            listOfCourses[index].capacity = capacity;
         }

         System.out.println("List after the operation:");
         courseListInfo();
         return true;
      } else {
         System.out.println("Operation: Change the capacity of a course to " + capacity);
         System.out.println(courseID + " is not a valid course. Operation failed.");
         System.out.println();
         return false;
      }
   }

   // retrieves course based on index
   public Course getCourseWithIndex(int i) {
      System.out.println("Operation: Find course at index " + i);
      System.out.println("Course List:");
      courseListInfo();

      if (i >= sizePrivate()) {
         System.out.println("Result: course not found, index is too large");
         System.out.println();
         return null;
      } else if (i < 0) {
         System.out.println("Result: course not found, index is too small");
         System.out.println();
         return null;
      } else {
         System.out.println("Result: course found at index " + i);
         System.out.println(courseInfo(listOfCourses[i]));
         System.out.println();
         return listOfCourses[i];
      }
   }

   // retrieves course index with given courseID
   // returns -1 if courseID not associated with course
   public int SearchCourseID(String courseID) {
      System.out.println("Operation: Find course with course ID: " + courseID);
      System.out.println("Course List:");
      courseListInfo();

      for (int i = 0; i < sizePrivate(); i++) {
         if (listOfCourses[i].courseID.equals(courseID)) {
            System.out.println("Result: course found at index " + i);
            System.out.println(courseInfo(listOfCourses[i]));
            System.out.println();
            return i;
         }
      }

      System.out.println("Result: course not found");
      System.out.println();
      return -1;
   }

   // retrieves course index with given courseName
   // returns -1 if courseName not associated with course
   public int SearchCourseName(String courseName) {
      System.out.println("Operation: Find course with course name: " + courseName);
      System.out.println("Course List:");
      courseListInfo();

      for (int i = 0; i < sizePrivate(); i++) {
         if (listOfCourses[i].courseName.equals(courseName)) {
            System.out.println("Result: course found at index " + i);
            System.out.println(courseInfo(listOfCourses[i]));
            System.out.println();
            return i;
         }
      }

      System.out.println("Result: course not found");
      System.out.println();
      return -1;
   }

   // prints information for a given course given that the course exists
   private String courseInfo(Course course) {
      if (course != null) {
         return "courseID: " + course.courseID + ", " +
               "courseName: " + course.courseName + ", " +
               "capacity: " + course.capacity;
      } else {
         return "-";
      }
   }

   // prints information for each course in the list
   private void courseListInfo() {
      for (int i = 0; i < sizePrivate(); i++) {
         if (listOfCourses[i] != null) {
            System.out.println(i + ". " + courseInfo(listOfCourses[i]));
         }
      }
      System.out.println();
   }

   // prints method header, consists of operation description, course info, list info
   private void methodInfo(String operation, Course course) {
      System.out.println("Operation: " + operation + ".");
      System.out.println("Course: " + courseInfo(course));
      System.out.println();
      System.out.println("List before the operation:");
      courseListInfo();
   }

}
