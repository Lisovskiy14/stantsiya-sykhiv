package org.example.dao;

import org.example.model.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDao {
    private Connection connection;

    public BoardDao(Connection connection) {
        this.connection = connection;
    }

    public void addBoard(Board board) {
        String query = "INSERT INTO board (title, project_id) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, board.getTitle());
            statement.setInt(2, board.getProject_id());
            statement.executeUpdate();
            System.out.println("Board with title \"" + board.getTitle() + "\" added to table board");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
