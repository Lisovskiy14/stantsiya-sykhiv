package org.example.dao;

import org.example.model.Column;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ColumnDao {
    private Connection connection;

    public ColumnDao(Connection connection) {
        this.connection = connection;
    }

    public void addColumn(Column column) {
        String query = "INSERT INTO `column` (title, board_id, `order`) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, column.getTitle());
            statement.setInt(2, column.getBoard_id());
            statement.setInt(3, column.getOrder());
            statement.executeUpdate();
            System.out.println("Column with title \"" + column.getTitle() + "\" added to table column");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
