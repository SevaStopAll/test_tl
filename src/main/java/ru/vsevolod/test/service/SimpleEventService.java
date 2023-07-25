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
import ru.vsevolod.test.entity.Event;
import ru.vsevolod.test.entity.PageSettings;
import ru.vsevolod.test.repository.CategoryRepository;
import ru.vsevolod.test.repository.EventRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEventService implements EventService {

    private EventRepository eventRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Event> create(Event event) {
        return Optional.of(eventRepository.save(event));
    }

    @Override
    public Optional<Event> getById(Long id) {
        return eventRepository.findById(id);
    }


    public Page<Event> getAll(@NonNull PageSettings pageSetting) {
        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), plantSort);
        return eventRepository.findAll(plantPage);
    }

    public Page<Event> getAllByCategory(@NonNull PageSettings pageSetting, String categoryName) {
        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), plantSort);

        return eventRepository.findAllByCategory(categoryRepository.findCategoryByName(categoryName).get());
    }

    public Page<Event> getAllByDate(@NonNull PageSettings pageSetting, LocalDate date) {
        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), plantSort);

        return eventRepository.findAllByTimeOfCreationContaining(date);
    }
}
