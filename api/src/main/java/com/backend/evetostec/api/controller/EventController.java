package com.backend.evetostec.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.evetostec.api.domain.event.Event;
import com.backend.evetostec.api.domain.event.EventRequestDTO;
import com.backend.evetostec.api.domain.event.EventResponseDTO;
import com.backend.evetostec.api.service.EventService;

@RestController
@RequestMapping("api/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Event> create(@RequestBody EventRequestDTO body){
        Event newEvent = this.eventService.createEvent(body);
        return ResponseEntity.ok(newEvent);
    }
    @GetMapping
    public ResponseEntity <List<EventResponseDTO>> getEvent(@RequestParam(defaultValue = "0") int page, @RequestParam  (defaultValue = "10") int size){
        List<EventResponseDTO> allEvents = this.eventService.getEvents(page, size);
        return ResponseEntity.ok(allEvents);
    }
}
