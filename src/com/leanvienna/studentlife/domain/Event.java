package com.leanvienna.studentlife.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    
    //Date stored in UTC
    private Date date;
    
    //Duration in Minutes
    private int duration;
    
    private Student creator;
}
