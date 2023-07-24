package ru.vsevolod.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.vsevolod.test.entity.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>, CrudRepository<Event, Long> {

}
