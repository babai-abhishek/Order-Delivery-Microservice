package entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String number;

    private String street;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    @JsonManagedReference
    private Orders order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
