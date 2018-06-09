package pl.kul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Cinema cinema = new Cinema(1,"Multikino Plaza","Lipowa 23","Lublin");
        System.out.println(cinema.toString());

        Movie Movie1 = new Movie(1,"Upgrade", "Leigh Whannell", 2018, "Blumhouse Productions", "Action", 95, cinema);
        System.out.println(Movie1.toString());

        Movie Movie2 = new Movie(2,"Hereditary", "Ari Aster", 2018, "A24", "Horror", 127, cinema);
        System.out.println(Movie2.toString());

        Reservation res = new Reservation(1,"Marta", "Kopytko", "555-555-555", Movie2.getMov_id(), cinema.getCin_id());
        System.out.println(res.toString());

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            ConnectRepo conRes = new Connect(connection);

            int personId = conRes.saveRes(new Reservation(1 ,"Kuba", "Buraczek", "666-666-666", Movie2.getMov_id(), cinema.getCin_id()));

            System.out.println(personId);

            /*Reservation resFind = conRes.findById(1);
            System.out.println(resFind.toString());*/

        }
    }
}