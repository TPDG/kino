package pl.kul;

public class Reservation {
    private int res_id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Movie movie;
    private Cinema cinema;
    private int movieId;
    private int cinemaId;

    public Reservation(String firstName, String lastName, String phoneNumber, Movie movie, Cinema cinema) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.movie = movie;
        this.cinema = cinema;
    }

    public Reservation(int res_id, String firstName, String lastName, String phoneNumber, int movieId, int cinemaId) {
        this.res_id = res_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public String toString() {
        return "Rezerwacja - " +
                "Imię: " + firstName + ", " +
                "Nazwisko: " + lastName + ", " +
                "Numer telefonu: " + phoneNumber + ", " +
                "[ Id filmu: " + movieId + ", " +
                "Id kina: " + cinemaId + "]"
                ;
    }
}
