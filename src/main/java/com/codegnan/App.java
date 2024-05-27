package com.codegnan;

import com.codegnan.Dao.CourseDao;
import com.codegnan.Dao.InstructorDao;
import com.codegnan.entity.Course;
import com.codegnan.entity.Instructor;

public class App 
{
    public static void main( String[] args )
    {
    	 InstructorDao instructorDao = new InstructorDao();
    	 CourseDao courseDao = new CourseDao();
    	 Instructor instructor = new Instructor("Ramesh", "Balla", "rameshballa@gmail.com");
    	 instructorDao.saveInstructor(instructor);
    	 // create some courses
    	 Course tempCourse1 = new Course("CSE");
    	 tempCourse1.setInstructor(instructor);
    	 courseDao.saveCourse(tempCourse1);  
    	 Course tempCourse2 = new Course("IT");
    	 tempCourse2.setInstructor(instructor);
    	 courseDao.saveCourse(tempCourse2);
    }
}
