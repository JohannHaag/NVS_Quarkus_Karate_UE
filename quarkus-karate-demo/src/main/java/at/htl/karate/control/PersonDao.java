package at.htl.karate.control;

import at.htl.karate.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonDao implements PanacheRepository<Person> {

    public Person update(Person updated) {
        Person persistedPerson = findById(updated.id);
        if (persistedPerson != null) {
            persistedPerson.id = updated.id;
            persistedPerson.birth = updated.birth;
            persistedPerson.name = updated.name;
            persistedPerson.status = updated.status;
        }
        return persistedPerson;
    }


    public Person deletePerson(Person deletedperson){
        Person persistedPerson= findById(deletedperson.id);
        if(persistedPerson!= null) {
            this.delete("id = ?1", deletedperson.id);
        }
        return persistedPerson;
    }
}