package com.codegnan.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.codegnan.entity.Course;
import com.codegnan.exception.InvalidCourseIdException;

import com.codegnan.util.SessionHelper;

public class CourseDao {

	public void saveCourse(Course course) {
		Session session = SessionHelper.getSession().openSession();
		session.getTransaction().begin();
		session.save(course);
		session.getTransaction().commit();
		session.close();

	}

	public void updateCourse(Course course) {
		Session session = SessionHelper.getSession().openSession();
		session.getTransaction().begin();
		session.update(course);
		session.getTransaction().commit();
		session.close();
	}

	public Course deleteCourse(int id) throws InvalidCourseIdException {
		Session session = SessionHelper.getSession().openSession();
		try {
			Course course = session.get(Course.class, id);
			if (course != null) {
				return course;
			} else {
				InvalidCourseIdException e = new InvalidCourseIdException("There is no instructor with the given Id");
				throw e;
			}
		} finally {
			session.close();
		}
	}

	public Course getCourse(int id) throws InvalidCourseIdException {
		Session session = SessionHelper.getSession().openSession();
		try {
			Course course = session.get(Course.class, id);
			if (course != null) {
				return course;
			} else {
				InvalidCourseIdException e = new InvalidCourseIdException("There is no instructor with the given Id");
				throw e;
			}
		} finally {
			session.close();
		}

	}

	public List<Course> getAllCourses() {
		Session session = SessionHelper.getSession().openSession();
		String hql = "from Course";
		Query query = session.createQuery(hql);
		List<Course> courses = query.list();
		for (Course course : courses) {
			courses.add(course);
		}
		return courses;

	}

}
