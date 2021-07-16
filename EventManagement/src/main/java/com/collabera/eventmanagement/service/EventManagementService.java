package com.collabera.eventmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.eventmanagement.model.Events;
import com.collabera.eventmanagement.repository.EventsRepository;

@Service
public class EventManagementService {
	
	@Autowired
	EventsRepository eventrepo;
	
	public List<Events> listAll() {
        return eventrepo.findAll();
    }
     
    public Events save(Events event) {
    	return eventrepo.save(event);
    }
     
    public Events get(long event_Id) {
        return eventrepo.findById(event_Id).get();
    }
     
    public void delete(long event_Id) {
    	eventrepo.deleteById(event_Id);
    }
}
