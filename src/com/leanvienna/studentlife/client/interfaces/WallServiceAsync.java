package com.leanvienna.studentlife.client.interfaces;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Message;
import com.leanvienna.studentlife.domain.Student;

public interface WallServiceAsync {

	void colleaguesInCourse(Course course, AsyncCallback<List<Student>> callback);

	void getCoursesForLoggedInStudent(AsyncCallback<List<Course>> callback);

	void getLastMessages(AsyncCallback<List<Message>> callback);

	void getLastMessages(int offset, AsyncCallback<List<Message>> callback);

}
