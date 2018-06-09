package pl.kul;

import java.util.Date;

public class Movie {
    private int mov_id;
    private String title;
    private String director;
    private int date;
    private String studio;
    private String genere;
    private int runtime;
    private Date inCinema;
    private Date outCinema;
    private Cinema cinema;

    public Movie(){}

    public Movie(int mov_id, String title, String director, int date, String studio, String genere, int runtime, Cinema cinema) {
        this.mov_id = mov_id;
        this.title = title;
        this.director = director;
        this.date = date;
        this.studio = studio;
        this.genere = genere;
        this.runtime = runtime;
        this.cinema = cinema;
    }

    public int getMov_id() {
        return mov_id;
    }

    public void setMov_id(int mov_id) {
        this.mov_id = mov_id;
    }

    public Date getInCinema() {
        return inCinema;
    }

    public void setInCinema(Date inCinema) {
        this.inCinema = inCinema;
    }

    public Date getOutCinema() {
        return outCinema;
    }

    public void setOutCinema(Date outCinema) {
        this.outCinema = outCinema;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Film - " +
                "Nazwa: " + title + ", " +
                "Reżyser: " + director + ", " +
                "Rok: " + date + ", " +
                "Studio: " + studio + ", " +
                "Gatunek: " + genere + ", " +
                "Długość: " + runtime + " minut.";
    }
}