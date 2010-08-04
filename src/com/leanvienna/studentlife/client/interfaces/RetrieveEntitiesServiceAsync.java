package com.leanvienna.studentlife.client.interfaces;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.Task;
import com.leanvienna.studentlife.domain.University;

public interface RetrieveEntitiesServiceAsync {

	void getCities(String province, AsyncCallback<List<City>> callback);

	void getCountries(AsyncCallback<List<Country>> callback);

	void getCourses(String university, AsyncCallback<List<Course>> callback);

	void getEvents(String course, AsyncCallback<List<Event>> callback);

	void getProvinces(String country, AsyncCallback<List<Province>> callback);

	void getTasks(String course, AsyncCallback<List<Task>> callback);

	void getUniversities(String city, AsyncCallback<List<University>> callback);

}
