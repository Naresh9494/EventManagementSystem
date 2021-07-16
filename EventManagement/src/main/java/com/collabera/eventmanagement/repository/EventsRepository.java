package com.collabera.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.eventmanagement.model.Events;

public interface EventsRepository extends JpaRepository<Events, Long> {

}
