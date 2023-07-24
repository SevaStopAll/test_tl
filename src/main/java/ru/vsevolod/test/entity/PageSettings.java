package ru.vsevolod.test.entity;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PageSettings {

    private int page = 0;

    private int elementPerPage = 10;

    private String direction = "dsc";

    private String key;

    public Sort buildSort() {
        switch (direction) {
            case "dsc":
                return Sort.by(key).descending();
            case "asc":
                return Sort.by(key).ascending();
            default:
                return Sort.by(key).descending();
        }
    }
}
