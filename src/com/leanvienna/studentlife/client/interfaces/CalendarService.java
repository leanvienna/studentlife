package com.leanvienna.studentlife.client.interfaces;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.leanvienna.studentlife.domain.Event;
import com.leanvienna.studentlife.domain.Task;

@RemoteServiceRelativePath("calendar")
public interface CalendarService extends RemoteService {
	List<Date> tasksForMonth(Date date);
	List<Date> eventsForMonth(Date date);
	
	List<Task> tasksForDay(Date date);
	List<Event> eventsForDay(Date date);
}
