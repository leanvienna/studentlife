package com.leanvienna.studentlife.client.interfaces;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

@RemoteServiceRelativePath("retrieve")
public interface RetrieveEntitiesService extends RemoteService {
	List<Country> getCountries();

	List<Province> getProvinces(String country);

	List<City> getCities(String province);

	List<University> getUniversities(String city);

	List<Course> getCourses(String university);

	List<Task> getTasks(String course);

	List<Event> getEvents(String course);
}
