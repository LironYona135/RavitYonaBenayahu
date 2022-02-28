package com.example.belove.models.addresses;

public class ShippingAddress {
    private String fullName;
    private String city;
    private String street;
    private int houseNumber;
    private int apartment;
// constructor:

    public ShippingAddress(String fullName, String city, String street, int houseNumber, int apartment) {
        this.fullName = fullName;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartment = apartment;
    }
    //getters & setters:
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartment=" + apartment +
                '}';
    }
}
