package at.htl.karate.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "MY_ADDRESS")
public class Address extends PanacheEntity {

    @Column(name = "A_STREET")
    String street;
    @Column(name = "A_CITY")
    String city;
    @Column(name = "A_ZIP_CODE")
    int zipCode;

    @ManyToOne
    @JoinColumn(name = "A_PERSON_ID")
    Person person;

    public Address() {
    }

    public Address(String street, String city, int zipCode, Person person) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.person = person;
    }
}