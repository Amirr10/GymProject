package com.hit.model;

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
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="activity_name")
	private String workoutName;
	
	@Column(name="rep_num")
	private int numRep;
	
	@Column(name="num_sets")
	private int numSets;

	public Activity(String workoutName, int numRep, int numSets) {
		super();
		this.workoutName = workoutName;
		this.numRep = numRep;
		this.numSets = numSets;
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