package pl.kul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect implements ConnectRepo {

    private static final String FIND_BY_ID_QUERY = "SELECT first_name, last_name, phone_number, idMovie, idCinema" +
            "FROM reservation " +
            "WHERE res_id = ?";

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
                    ")");
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public int saveRes(Reservation person) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getFirst_name());
            preparedStatement.setString(2, person.getLast_name());
            preparedStatement.setString(3, person.getPhone_number());
            preparedStatement.setInt(4, person.getMovieId());
            preparedStatement.setInt(5, person.getCinemaId());

            int inserted = preparedStatement.executeUpdate();

            if (inserted != 1) {
                throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                    throw new IllegalStateException("Query did not return created primary key");
                }

                return generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("Could not execute query", ex);
        }
    }


    /*@Override
    public Reservation findById(int res_id) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            statement.setInt(1, res_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                } else {
                    String first_name = resultSet.getString(1);
                    String last_name = resultSet.getString(2);
                    String phone_number = resultSet.getString(3);
                    int idMovie = resultSet.getInt(4);
                    int idCinema = resultSet.getInt(5);

                    return new Reservation(res_id, first_name, last_name, phone_number, idMovie, idCinema);
                }
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("Could not execute query", ex);
        }
    }*/
}

