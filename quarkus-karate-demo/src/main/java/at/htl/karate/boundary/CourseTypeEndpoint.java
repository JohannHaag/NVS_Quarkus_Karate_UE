package at.htl.karate.boundary;

import at.htl.karate.control.CourseDao;
import at.htl.karate.control.CourseTypeDao;
import at.htl.karate.entity.Course;
import at.htl.karate.entity.CourseType;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/course_type")
public class CourseTypeEndpoint {
    @Inject
    CourseTypeDao courseTypeDao;

    @Inject
    CourseDao courseDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<CourseType> courseTypeList = courseTypeDao.findAll().list();
        return Response
                .ok(courseTypeList)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        CourseType courseType = courseTypeDao.findById(id);
        return Response
                .ok(courseType)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(CourseType courseType) {
        CourseType courseType1 = courseTypeDao.save(courseType);
        courseTypeDao.persist(courseType1);
        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("course_type/" + courseType1.id))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") long id, CourseType courseType) {
        CourseType updated = courseTypeDao.findById(id);
        if (updated== null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "courseType with id " + id + " does not exist")
                    .build();
        }else{
            updated.id = courseType.id;
            updated.abbr = courseType.abbr;
            updated.name= courseType.name;
        }
        return Response.ok().entity(updated).build();
    }


    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") long id){
        CourseType courseType = courseTypeDao.findById(id);
        courseTypeDao.delete(courseType);
        return Response.noContent().build();
    }

}
