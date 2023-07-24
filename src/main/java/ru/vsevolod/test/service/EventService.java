package ru.vsevolod.test.service;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import ru.vsevolod.test.entity.Event;
import ru.vsevolod.test.entity.PageSettings;

import java.util.Optional;

public interface EventService {

    Optional<Event> create(Event event);

    Optional<Event> getById(Long id);

    Page<Event> getEventPage(@NonNull PageSettings pageSetting);

}
