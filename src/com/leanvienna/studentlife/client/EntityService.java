package com.leanvienna.studentlife.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

@RemoteServiceRelativePath("entity")
public interface EntityService extends RemoteService {
	void addCountry(Country country);
	void addProvince(Country country, Province province);
	void addCity(Province province, City city);
	void addUniversity(City city, University university);
	void addCourse(University university, Course course);
	void addTask(Course course, Task task);
	void addEvent(Course course, Event event);
}
