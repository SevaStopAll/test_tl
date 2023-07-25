package ru.vsevolod.test.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vsevolod.test.entity.Event;
import ru.vsevolod.test.entity.PageSettings;
import ru.vsevolod.test.service.EventService;

import java.time.LocalDate;

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
        return eventService.getAll(pageSetting);
    }

    @PostMapping("/create")
    public String createEvent(@RequestBody Event event) {
        eventService.create(event);
        return "redirect: /";
    }

    @GetMapping("/{category}")
    public Page<Event> getAllByCategory(@PathVariable String category) {
        return eventService.getAllByCategory(pageSetting, category);
    }

    @GetMapping("/{date}}")
    public Page<Event> getAllByDate(@PathVariable String date) {
        LocalDate targetDate = LocalDate.parse(date);
        return eventService.getAllByDate(pageSetting, targetDate);
    }


}
