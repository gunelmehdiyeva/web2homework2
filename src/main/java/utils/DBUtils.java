package utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            Context webContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) webContext.lookup("jdbc/homework");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet get(String query, String... args) throws SQLException {
        try {
            Connection connection = DBUtils.dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i <= args.length - 1; i++) {
                statement.setString(i + 1, args[i]);
            }
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void second(String sql, String... args) throws SQLException {
        try (Connection connection = DBUtils.dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i <= args.length - 1; i++) {
                statement.setString(i + 1, args[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
