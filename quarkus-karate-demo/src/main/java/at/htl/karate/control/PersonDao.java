package at.htl.karate.control;

import at.htl.karate.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonDao implements PanacheRepository<Person> {

}
