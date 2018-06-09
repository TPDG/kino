package pl.kul;

public class Main {

    public static void main(String[] args) {

        Cinema cinema = new Cinema("Multikino Plaza","Lipowa 23","Lublin");
        System.out.println(cinema.toString());

        Movie newmovie = new Movie("Upgrade", "Leigh Whannell", 2018, "Blumhouse Productions", "Action", 95, cinema);
        System.out.println(newmovie.toString());

        Reservation res = new Reservation("Marta", "Kopytko", "555-555-555", newmovie, cinema);
        System.out.println(res.toString());
    }
}