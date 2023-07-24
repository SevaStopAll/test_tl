package ru.vsevolod.test.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.vsevolod.test.entity.Category;
import ru.vsevolod.test.entity.Event;
import ru.vsevolod.test.entity.PageSettings;
import ru.vsevolod.test.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEventService implements EventService {

    private EventRepository eventRepository;

    @Override
    public Optional<Event> create(Event event) {
        return Optional.of(eventRepository.save(event));
    }

    @Override
    public Optional<Event> getById(Long id) {
        return eventRepository.findById(id);
    }


    public Page<Event> getEventPage(@NonNull PageSettings pageSetting) {
        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), plantSort);

        return eventRepository.findAll(plantPage);
    }
}
