package com.rosebrakoh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Entity
@Data
@Table(name="boarding_history")
public class StudentBusHistory {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	private String studentId;
	private String firstName;
	private String lastName;
	private String otherNames;
	private String studentClass;
	private String date;
	private double latitude;
	private double longitude;

}
