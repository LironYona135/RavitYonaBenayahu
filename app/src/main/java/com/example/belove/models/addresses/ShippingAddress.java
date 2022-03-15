package com.example.belove.models.addresses;

public class ShippingAddress {
    private String fullName;
    private String city;
    private String street;
    private int houseNumber;
    private int apartment;
    private int zipCode;
// constructor:

    public ShippingAddress(String fullName, String city, String street, int houseNumber, int apartment, int zipCode) {
        this.fullName = fullName;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartment = apartment;
        this.zipCode = zipCode;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartment=" + apartment +
                ", zip code=" + zipCode +
                '}';
    }
}
