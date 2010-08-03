package com.leanvienna.studentlife.client.interfaces;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Task;

public interface CalendarServiceAsync {

	void eventsForDay(Date date, AsyncCallback<List<Event>> callback);

	void tasksForDay(Date date, AsyncCallback<List<Task>> callback);

	void eventsForMonth(Date date, AsyncCallback<List<Date>> callback);

	void tasksForMonth(Date date, AsyncCallback<List<Date>> callback);

}
