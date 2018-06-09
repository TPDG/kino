package pl.kul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Cinema cinema = new Cinema(1,"Multikino Plaza","Lipowa 23","Lublin");
        System.out.println(cinema.toString());

        Movie newMovie = new Movie(1,"Upgrade", "Leigh Whannell", 2018, "Blumhouse Productions", "Action", 95, cinema);
        System.out.println(newMovie.toString());

        Reservation res = new Reservation(1,"Marta", "Kopytko", "555-555-555", newMovie.getMov_id(), cinema.getCin_id());
        System.out.println(res.toString());

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            ConnectRepo conRes = new Connect(connection);

            long personId = conRes.saveRes(new Reservation(1 ,"Kuba", "Buraczek", "666-666-666", newMovie.getMov_id(), cinema.getCin_id()));

            System.out.println(personId);

        }
    }
}