package com.leanvienna.studentlife.client.interfaces;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

@RemoteServiceRelativePath("store")
public interface StoreEntitiesService extends RemoteService {
	void addCountry(Country country);
	void addProvince(String country, Province province);
	void addCity(String provinceId, City city);
	void addUniversity(String cityId, University university);
	void addCourse(String universityId, Course course);
	void addTask(String courseId, Task task);
	void addEvent(String courseId, Event event);
}
