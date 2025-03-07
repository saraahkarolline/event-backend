package com.backend.evetostec.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.evetostec.api.domain.event.Event;
public interface EventRepository extends JpaRepository<Event, UUID> {

}
