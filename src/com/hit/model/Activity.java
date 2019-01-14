package com.hit.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="activity_id")
	private int activityId;

	
	@Column(name="activity_name")
	private String workoutName;
	
	@Column(name="rep_num")
	private int numRep;
	
	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	@Column(name="num_sets")
	private int numSets;
	
	@Column(name="date_created")
	private Date date_created;

	public Activity(String workoutName, int numRep, int numSets) {
		super();
		this.workoutName = workoutName;
		this.numRep = numRep;
		this.numSets = numSets;
		this.date_created = new Date(Calendar.getInstance().getTime().getTime());
	}
	
	public Activity() {}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public int getNumRep() {
		return numRep;
	}

	public void setNumRep(int numRep) {
		this.numRep = numRep;
	}

	public int getNumSets() {
		return numSets;
	}

	public void setNumSets(int numSets) {
		this.numSets = numSets;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", workoutName=" + workoutName + ", numRep=" + numRep
				+ ", numSets=" + numSets + "]";
	}
	
	
	
}
