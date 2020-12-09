package at.htl.karate.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="MY_PERSON")
public class Person  {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public long id;

    public String name;
    public LocalDate birth;
    public String status;

    public Person() {
    }

    public Person(String name, LocalDate birth, String status) {
        this.name = name;
        this.birth = birth;
        this.status = status;
    }
}