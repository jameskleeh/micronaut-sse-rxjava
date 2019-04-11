package playground.sse;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.sse.Event;
import org.reactivestreams.Publisher;

@Controller("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Post("/publish")
    public void publishAuthor(@Body Author author) {
        authorService.publish(author);
    }


    @Get("/events")
    Publisher<Event<Author>> events() {
        return authorService.getAuthors().map(Event::of);
    }
}
