package org.fasttrack.ShelfSpace;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Builder
@ToString
public class Book {
    private final long id;
    private final String title;
    private final String author;
    private final String genre;
    private final LocalDate releaseDate;
    private final String description;
    private final String state;
}
