import java.util.ArrayList;

public class Cinema {
    private int cin_id;
    private String name;
    private String street;
    private String city;
    private ArrayList<Movie> movies;

    public Cinema(){}

    public Cinema(String name, String street, String city) {
        this.name = name;
        this.street = street;
        this.city = city;
    }

    public int getCin_id() {
        return cin_id;
    }

    public void setCin_id(int cin_id) {
        this.cin_id = cin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Kino - " +
                "Nazwa: " + name + ", " +
                "Ulica: " + street + ", " +
                "Miasto: " + city + ".";
    }
}


