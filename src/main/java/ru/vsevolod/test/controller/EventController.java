package ru.vsevolod.test.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vsevolod.test.entity.Event;
import ru.vsevolod.test.entity.PageSettings;
import ru.vsevolod.test.service.EventService;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Controller
@RequestMapping("/event")
public class EventController {
    private EventService eventService;
    private PageSettings pageSetting;

    @GetMapping("/all")
    public Page<Event> getAllEvents() {
        return eventService.getEventPage(pageSetting);
    }

    @PostMapping("/create")
    public String createEvent(@RequestBody Event event) {
        eventService.create(event);
        return "redirect: /";
    }
}
