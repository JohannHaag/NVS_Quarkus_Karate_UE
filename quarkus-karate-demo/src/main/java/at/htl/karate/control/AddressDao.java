package at.htl.karate.control;

import at.htl.karate.model.Address;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressDao implements PanacheRepository<Address> {
}
