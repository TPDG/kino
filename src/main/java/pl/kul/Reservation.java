package pl.kul;

public class Reservation {
    private int res_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private Movie movie;
    private Cinema cinema;
    private int movieId;
    private int cinemaId;

    public Reservation(int res_id, String first_name, String last_name, String phone_number, int movieId, int cinemaId) {
        this.res_id = res_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
                "Imię: " + first_name + ", " +
                "Nazwisko: " + last_name + ", " +
                "Numer telefonu: " + phone_number + ", " +
                "[ Id filmu: " + movieId + ", " +
                "Id kina: " + cinemaId + "]"
                ;
    }
}
