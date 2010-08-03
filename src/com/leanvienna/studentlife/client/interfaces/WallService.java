package com.leanvienna.studentlife.client.interfaces;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.leanvienna.studentlife.domain.Course;
import com.leanvienna.studentlife.domain.Message;
import com.leanvienna.studentlife.domain.Student;

@RemoteServiceRelativePath("wall")
public interface WallService extends RemoteService {
	List<Message> getLastMessages();
	List<Message> getLastMessages(int offset);
	
	List<Course> getCoursesForLoggedInStudent();
	List<Student> colleaguesInCourse(Course course);
}
