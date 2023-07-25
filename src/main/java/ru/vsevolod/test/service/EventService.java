package ru.vsevolod.test.service;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import ru.vsevolod.test.entity.Event;
import ru.vsevolod.test.entity.PageSettings;

import java.time.LocalDate;
import java.util.Optional;

public interface EventService {

    Optional<Event> create(Event event);

    Optional<Event> getById(Long id);

    Page<Event> getAll(@NonNull PageSettings pageSetting);

    Page<Event> getAllByCategory(@NonNull PageSettings pageSetting, String categoryName);

    Page<Event> getAllByDate(@NonNull PageSettings pageSetting, LocalDate date);
}
