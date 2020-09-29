public class CourseMain {

   public static void main(String[] args) {
      System.out.println("Assignment 1 Demo:");
      System.out.println();

      // initializing CourseList and Courses
      CourseList testList = new CourseList();
      Course c1 = new Course("CSDS 233", "Data Structures", 50);
      Course c2 = new Course("MATH 201", "Linear Algebra", 75);
      Course c3 = new Course("PHYS 122", "Electromagnetism", 200);
      Course c4 = new Course("ENGR 145", "Material Chemistry", 150);

      // testing initialization
      System.out.println("Size of empty list: " + testList.size());
      System.out.println();

      // testing add functions
      testList.addCourse(0, c1);
      testList.addCourse(1, c2);
      testList.addCourse(2, c3);

      // testing add+shift functions
      testList.addCourse(1, c4);

      // testing remove+shift function
      testList.removeCourse(1);

      // testing size function
      testList.size();

      // testing searching functions
      testList.SearchCourseID("MATH 201");
      testList.getCourseWithIndex(2);
      testList.SearchCourseName("Electromagnetism");

      // testing changeCapacity
      testList.changeCapacity("MATH 201", 567);

      // testing i = too large
      testList.addCourse(11, new Course("FSTS 100", "English Composition", 25));
      testList.removeCourse(11);
      testList.getCourseWithIndex(11);

      // testing i = too small
      testList.addCourse(-1, new Course("FSTS 100", "English Composition", 25));
      testList.removeCourse(-1);
      testList.getCourseWithIndex(-1);

      // testing searching/changeCapacity functions with incorrect ID's/names
      testList.changeCapacity("x", 123);
      testList.SearchCourseID("x");
      testList.SearchCourseName("x");

      // testing duplicate courses for changeCapacity
      testList.addCourse(9, new Course("Test1", "test 1", 75));
      testList.addCourse(9, new Course("Test1", "test 1", 200));
      testList.changeCapacity("Test1", 5);
   }

}
