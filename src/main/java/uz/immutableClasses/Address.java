package uz.immutableClasses;

public class Address implements Cloneable{
    private String district;
    private String street;

    public Address() {
    }

    public Address(String district, String street) {
        this.district = district;
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Address{" +
                "district='" + district + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
