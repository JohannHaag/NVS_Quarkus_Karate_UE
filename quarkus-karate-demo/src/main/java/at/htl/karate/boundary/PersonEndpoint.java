package at.htl.karate.boundary;

import at.htl.karate.control.PersonDao;
import at.htl.karate.model.Person;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.LocalDate;

@Path("/person")
public class PersonEndpoint {

    @Inject
    PersonDao personDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        Person person = personDao
                .find("name","Christian")
                .firstResult();
        return Response
                .ok(person)
                .build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create() {
        Person person = new Person("Christiane", LocalDate.parse("2000-12-17"),"not ledig");
        personDao.persist(person);
        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("person/" + person.id))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") long id, Person person) {
        person.id = id;
        Person updated = personDao.update(person);
        if(updated != null) {
            return Response.ok().entity(updated).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") long id, Person person){
        person.id = id;
        Person deletedPerson = personDao.deletePerson(person);
        if(deletedPerson != null) {
            return Response.noContent().build();
        } else {
            return Response.status(404).build();
        }
    }
}