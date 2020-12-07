package at.htl.karate.control;

import at.htl.karate.model.Address;
import at.htl.karate.model.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.logging.Logger;

@ApplicationScoped
public class InitBean {

    @Inject
    PersonDao personDao;

    @Inject
    AddressDao addressDao;

    @Transactional
    public void init(@Observes StartupEvent event) {
        Person chris = new Person("Christian", LocalDate.of(2000,12,17),"ledig");
        personDao.persist(chris);
        Address address = new Address("Hyrtlstraße 2ß", "Traun", 4050,chris);
        addressDao.persist(address);
    }
}