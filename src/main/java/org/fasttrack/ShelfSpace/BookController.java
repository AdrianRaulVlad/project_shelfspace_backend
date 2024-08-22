package org.fasttrack.ShelfSpace;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.fasttrack.ShelfSpace.exceptions.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books") // GET http://host:port/books?genre=Fiction
    public List<Book> getAllBooks(@RequestParam(required = false) String genre) {
        if (genre != null) {
            return bookService.getAllBooksByGenre(genre);
        } else {
            return bookService.getAllBooks();
        }
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id).orElseThrow(() -> new EntityNotFoundException("Can't find the book", id));
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBookById(@PathVariable long id) {
        return bookService.deleteBookEntry(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book) {
        if(id != book.getId()) {
            throw new RuntimeException();
        }
        return bookService.updateBook(book);
    }
}
