package com.collabera.eventmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.collabera.eventmanagement.model.Events;
import com.collabera.eventmanagement.repository.EventsRepository;
import com.collabera.eventmanagement.service.EventManagementService;

@Controller
public class EventController {

	@Autowired
	public EventsRepository eventsRepo;

	@Autowired
	public EventManagementService eventService;

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	// This method invokes create form
	@GetMapping("/createEvent")
	public ModelAndView createEventForm(ModelAndView model) {

		model.addObject("event", new Events());
		model.setViewName("createEvent");
		return model;
	}

	// Returns success page after creating new event
	@GetMapping("/createNewEvent")
	public ModelAndView createNewEvent(ModelAndView model, Events event, @ModelAttribute("title") String title) {

		// saves event into databasex
		eventsRepo.save(event);

		model.addObject("eventName", title);
		model.setViewName("eventCreateSuccess");
		return model;
	}

	@GetMapping("/displayEvent")
	public ModelAndView displayEvents(ModelAndView model) {

		List<Events> listofevents = eventsRepo.findAll();
		model.addObject("eventList", listofevents);
		model.setViewName("displayEvents");
		return model;

	}

	// its for edit the event record
	@RequestMapping("/edit/{event_Id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "event_Id") int event_Id) {
		ModelAndView mav = new ModelAndView("edit_event");
		Events event;
		try {
			event = eventService.get(event_Id);
			mav.addObject("person", event);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	// return success page after deleting events
	@RequestMapping("/removeEvent/{event_Id}")
	public String removeEvnet(@PathVariable(name = "event_Id") Events event) {
		System.out.println("welcome to delete");
		eventsRepo.delete(event);
		return "redirect:/";

	}

}
