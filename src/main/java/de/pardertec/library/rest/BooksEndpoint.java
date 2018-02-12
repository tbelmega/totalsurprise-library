package de.pardertec.library.rest;

import de.pardertec.library.BookCto;
import de.pardertec.library.BookEntity;
import de.pardertec.library.BookEto;
import de.pardertec.library.BooksBS;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.awt.print.Book;
import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@ApplicationScoped
@Path("/books")
@Transactional
public class BooksEndpoint {

    @Inject
    private BooksBS booksBS;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response doGet() {
        List<BookCto> books = booksBS.findAll();

        return Response.ok(books).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response doPost(BookEto book, @Context UriInfo uriInfo) {

        book = booksBS.createNewBook(book);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        URI uri = builder.path(Long.toString(book.getId())).build();

        return Response.created(uri).entity(book).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getBook(@PathParam("id") Long bookId) {
        Optional<BookEto> book = booksBS.findBookById(bookId);
        return Response.ok(book.orElse(null)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response putBook(BookEto book, @PathParam("id") Long bookId) {
        book = booksBS.updateBook(book);
        return Response.ok(book).build();
    }

}