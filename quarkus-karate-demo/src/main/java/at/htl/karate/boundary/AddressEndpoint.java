package at.htl.karate.boundary;

import at.htl.karate.control.AddressDao;
import at.htl.karate.model.Address;
import at.htl.karate.model.Person;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/address")
public class AddressEndpoint {

    @Inject
    AddressDao addressDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<Address> addressList = addressDao.findAll().list();
        return Response
                .ok(addressList)
                .build();
    }
}
