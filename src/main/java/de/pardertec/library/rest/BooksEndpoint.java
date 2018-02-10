package de.pardertec.library.rest;

import de.pardertec.library.BookCto;
import de.pardertec.library.BookEntity;
import de.pardertec.library.BooksBS;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@ApplicationScoped
@Path("/books")
public class BooksEndpoint {

    @Inject
    private BooksBS booksBS;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response doGet() {

        List<BookCto> books = booksBS.findAll();

        return Response.ok(books).build();
    }
}