package at.htl.karate.control;

import at.htl.karate.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonValue;


@ApplicationScoped
public class PersonDao implements PanacheRepository<Person> {

    public Person findByName(String name){
        return find("name",name).firstResult();
    }

    public JsonArray saveByJson(JsonValue person){
        return person.asJsonArray();
    }

    public Person save(Person person){
        persistAndFlush(person);
        return person;
    }

}
