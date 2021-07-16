package com.collabera.eventmanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Events implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long event_id;

	private Date event_date;
	private String title;
	
	//default constructor
	public Events() {
		
	}

	//parameterized constructor
	public Events(Long event_id, Date event_date, String title) {
		
		this.event_id = event_id;
		this.event_date = event_date;
		this.title = title;
	}

	//getters and setters
	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event_date == null) ? 0 : event_date.hashCode());
		result = prime * result + (int) (event_id ^ (event_id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Events other = (Events) obj;
		if (event_date == null) {
			if (other.event_date != null)
				return false;
		} else if (!event_date.equals(other.event_date))
			return false;
		if (event_id != other.event_id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Events [event_id=" + event_id + ", event_date=" + event_date + ", title=" + title + "]";
	}
	
	
	
	
	
	
	

}
