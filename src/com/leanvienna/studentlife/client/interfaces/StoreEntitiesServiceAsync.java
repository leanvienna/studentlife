package com.leanvienna.studentlife.client.interfaces;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

public interface StoreEntitiesServiceAsync {

	void addCountry(Country country, AsyncCallback<Void> callback);

	void addProvince(String country, Province province,
			AsyncCallback<Void> callback);

	void addCity(String province, City city, AsyncCallback<Void> callback);

	void addEvent(String courseId, Event event, AsyncCallback<Void> callback);

	void addTask(String courseId, Task task, AsyncCallback<Void> callback);

	void addCourse(String universityId, Course course,
			AsyncCallback<Void> callback);

	void addUniversity(String cityId, University university,
			AsyncCallback<Void> callback);
}
