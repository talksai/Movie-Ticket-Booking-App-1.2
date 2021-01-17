package com.Saisatya.MovieTicketBookingApp11.Model;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "pincode")
    int pinCode;

    @Column(name = "city")
    String city;

    @Column(name = "state")
    String state;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address(int pinCode, String city, String state, String country) {
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Column(name = "country")
    String country;
}
