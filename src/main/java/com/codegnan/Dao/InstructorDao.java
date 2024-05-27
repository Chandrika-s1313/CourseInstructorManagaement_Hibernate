package com.codegnan.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.codegnan.entity.Instructor;
import com.codegnan.exception.InvalidInstructorIdException;
import com.codegnan.util.SessionHelper;

public class InstructorDao {
	public void saveInstructor(Instructor instructor) {

		Session session = SessionHelper.getSession().openSession();
		session.getTransaction().begin();
		session.save(instructor);
		session.getTransaction().commit();
		session.close();

	}

	public void updateInstructor(Instructor instructor) {
		Session session = SessionHelper.getSession().openSession();
		session.getTransaction().begin();
		session.update(instructor);
		session.getTransaction().commit();
		session.close();
	}

	public Instructor deleteInstructor(int id) throws InvalidInstructorIdException {
		Session session = SessionHelper.getSession().openSession();
		try {
			Instructor instructor = session.get(Instructor.class, id);
			if (instructor != null) {
				return instructor;
			} else {
				InvalidInstructorIdException e = new InvalidInstructorIdException(
						"There is no instructor with the given Id");
				throw e;
			}
		} finally {
			session.close();
		}
	}

	public Instructor getInstructor(int id) throws InvalidInstructorIdException {
		Session session = SessionHelper.getSession().openSession();
		try {
			Instructor instructor = session.get(Instructor.class, id);
			if (instructor != null) {
				return instructor;
			} else {
				InvalidInstructorIdException e = new InvalidInstructorIdException(
						"There is no instructor with the given Id");
				throw e;
			}
		} finally {
			session.close();
		}

	}

	public List<Instructor> getAllInstructructors() {
		Session session = SessionHelper.getSession().openSession();
		String hql = "from Instructor";
		Query query = session.createQuery(hql);
		List<Instructor> instructors = query.list();
		for (Instructor instructor : instructors) {
			instructors.add(instructor);
		}
		return instructors;
	}
}
