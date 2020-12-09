package at.htl.karate.boundary;

import at.htl.karate.control.PersonDao;
import at.htl.karate.model.Person;

import javax.inject.Inject;
import javax.json.JsonValue;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/person")
public class PersonEndpoint {

    @Inject
    PersonDao personDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Person> personList = personDao.findAll().list();
        return Response
                .ok(personList)
                .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByJson(JsonValue persons) {
        return Response
                .ok(personDao.saveByJson(persons.asJsonArray()))
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        Person person = personDao.findById(id);
        return Response
                .ok(person)
                .build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        Person person = personDao.findByName(name);
        return Response
                .ok(person)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Person person1) {
        Person person = personDao.save(person1);
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
        Person updated = personDao.findById(id);
        if(updated != null) {
            updated.birth = person.birth;
            updated.name = person.name;
            updated.status = person.status;
        } 
        return Response.ok().entity(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") long id, Person person){
        Person deletedPerson = personDao.findById(id);
        personDao.delete(deletedPerson);
        return Response.noContent().build();
    }
}
