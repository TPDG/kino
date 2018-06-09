package pl.kul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect implements ConnectRepo {

    private static final String INSERT_RESERVATION_QUERY = "INSERT INTO reservation " +
            "(first_name, last_name, phone_number, idMovie, idCinema) " +
            "VALUES (?, ?, ?, ?, ?)";

    private final Connection connection;

    public Connect(Connection connection) {
        this.connection = connection;

        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS reservation (" +
                    "res_id int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "first_name varchar NOT NULL," +
                    "last_name varchar NOT NULL," +
                    "phone_number varchar NOT NULL," +
                    "idMovie number NOT NULL," +
                    "idCinema number NOT NULL" +
                    /*"CREATE TABLE IF NOT EXISTS movie (" +
                    "id int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "title varchar NOT NULL," +
                    "director varchar NOT NULL," +
                    "date number NOT NULL" +
                    "studio varchar NOT NULL" +
                    "genere varchar NOT NULL" +
                    "runtime number NOT NULL" +
                    "inCinema date NOT NULL" +
                    "outCinema date NOT NULL" +
                    "idCinema number NOT NULL" +*/
                    ")");
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public long saveRes(Reservation reservation) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, reservation.getFirstName());
            preparedStatement.setString(2, reservation.getLastName());
            preparedStatement.setString(3, reservation.getPhoneNumber());
            preparedStatement.setInt(4, reservation.getMovieId());
            preparedStatement.setInt(5, reservation.getCinemaId());

            int inserted = preparedStatement.executeUpdate();

            if (inserted != 1) {
                throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                    throw new IllegalStateException("Query did not return created primary key");
                }

                return generatedKeys.getLong(1);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("Could not execute query", ex);
        }
    }
}

