package de.pardertec.library.rest;

import de.pardertec.library.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

@ApplicationScoped
@Path("/books")
public class BooksEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response doGet() {
        BookEntity demoBook = new BookEntity(1, "Clean Code", LocalDate.now(), Locale.GERMAN, 2, 3);
        return Response.ok(
                Arrays.asList(demoBook)
        ).build();
    }
}