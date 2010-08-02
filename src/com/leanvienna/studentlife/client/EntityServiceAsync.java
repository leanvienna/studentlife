package com.leanvienna.studentlife.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

public interface EntityServiceAsync {

	void addEvent(Course course, Event event, AsyncCallback<Void> callback);

	void addUniversity(City city, University university,
			AsyncCallback<Void> callback);

	void addCountry(Country country, AsyncCallback<Void> callback);

	void addProvince(Country country, Province province,
			AsyncCallback<Void> callback);

	void addCity(Province province, City city, AsyncCallback<Void> callback);

	void addCourse(University university, Course course,
			AsyncCallback<Void> callback);

	void addTask(Course course, Task task, AsyncCallback<Void> callback);

}
