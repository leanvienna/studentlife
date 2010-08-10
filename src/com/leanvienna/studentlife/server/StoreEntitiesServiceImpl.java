package com.leanvienna.studentlife.server;

import javax.persistence.Query;

import com.leanvienna.studentlife.client.interfaces.StoreEntitiesService;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

public class StoreEntitiesServiceImpl extends AbstractEntitiesService implements StoreEntitiesService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addCountry(Country country) {
		initEntityManager();
		persist(country);
		closeEntityManager();
	}
	
	@Override
	public void addProvince(String countryId, Province province) {
		initEntityManager();
		Country country = (Country) loadParent("Country", countryId);
		country.addProvince(province);
		persist(country);
		closeEntityManager();
	}

	@Override
	public void addCity(String provinceId, City city) {
		initEntityManager();
		// TODO: debug instead of sysout?
		System.out.println("Adding City");
		Province province = (Province) loadParent("Province", provinceId);
		province.addCity(city);
		persist(province);
		closeEntityManager();
	}
	
	@Override
	public void addUniversity(String cityId, University university) {
		initEntityManager();
		City city = (City) loadParent("City", cityId);
		city.addUniversity(university);
		persist(city);
		closeEntityManager();
	}

	@Override
	public void addCourse(String universityId, Course course) {
		initEntityManager();
		University uni = (University) loadParent("University", universityId);
		uni.addCourse(course);
		persist(uni);
		closeEntityManager();
	}

	@Override
	public void addEvent(String courseId, Event event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTask(String courseId, Task task) {
		
	}
	
	private Object loadParent(String parentType, String id){
		Query query = entityManager.createQuery("Select c from " + parentType +" c where c.id = :id");
		query.setParameter("id", id);
		Object result = query.getSingleResult();
		return result;
	}
	
	private void persist(Object toPersist) {
		//FIXME id can possibly be set for rpc sent objects, so check for id = null on new objects
		entityManager.persist(toPersist);
	}
}
