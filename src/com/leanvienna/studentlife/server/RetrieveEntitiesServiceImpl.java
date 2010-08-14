package com.leanvienna.studentlife.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.leanvienna.studentlife.client.interfaces.RetrieveEntitiesService;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

public class RetrieveEntitiesServiceImpl extends AbstractEntitiesService implements RetrieveEntitiesService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<City> getCities(String province) {
		// Why initEntityManager?
		initEntityManager();
		Query query = entityManager.createQuery("Select p.cities from Province p where p.id = :id");
		query.setParameter("id", province);
		@SuppressWarnings("unchecked")
		List<City> resultList = new ArrayList<City>((Set<City>)query.getSingleResult());
		System.out.println("ResultList: " + resultList);
		closeEntityManager();
		return resultList;
	}

	@Override
	public List<Country> getCountries() {
		System.out.println("Loading Countries");
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createQuery("Select c from Country c");
		@SuppressWarnings("unchecked")
		List<Country> resultList = new ArrayList<Country>(query.getResultList());
		return resultList;
	}

	@Override
	public List<Course> getCourses(String university) {
		System.out.println("Loading Courses");
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createQuery("SELECT u.courses FROM University u WHERE u.id = :id");
		query.setParameter("id", university);
		@SuppressWarnings("unchecked")
		List<Course> resultList = new ArrayList<Course>((Set<Course>)query.getSingleResult());
		return resultList;
	}

	@Override
	public List<Event> getEvents(String course) {
		System.out.println("Loading events for course " + course);
		initEntityManager();
		Query query = entityManager.createQuery("SELECT c.events FROM Course c WHERE c.id = :id");
		query.setParameter("id", course);
		@SuppressWarnings("unchecked")
		List<Event> resultList = new ArrayList<Event>((Set<Event>)query.getSingleResult());
		return resultList;
	}

	@Override
	public List<Province> getProvinces(String country) {
		System.out.println("Loading Provinces " + country);
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createQuery("Select c from Country c where c.id = :id");
		query.setParameter("id", country);
		Country c = (Country) query.getSingleResult();
		ArrayList<Province> provinces = new ArrayList<Province>(c.getProvinces());
		System.out.println("Provinces: " + provinces);
		return provinces;
	}

	@Override
	public List<Task> getTasks(String course) {
		System.out.println("Loading tasks for course " + course);
		initEntityManager();
		Query query = entityManager.createQuery("SELECT c.tasks FROM Course c WHERE c.id = :id");
		query.setParameter("id", course);
		@SuppressWarnings("unchecked")
		List<Task> resultList = new ArrayList<Task>((Set<Task>)query.getSingleResult());
		return resultList;
	}

	@Override
	public List<University> getUniversities(String city) {
		initEntityManager();
		Query query = entityManager.createQuery("Select c.universities from City c where c.id = :id");
		query.setParameter("id", city);
		@SuppressWarnings("unchecked")
		// TODO: WHY single result???
		List<University> resultList = new ArrayList<University>((Set<University>)query.getSingleResult());
		System.out.println("ResultList: " + resultList);
		closeEntityManager();
		return resultList;
	}
}
