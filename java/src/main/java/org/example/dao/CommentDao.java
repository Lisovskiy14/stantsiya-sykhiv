package org.example.dao;

import org.example.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDao {
    private Connection connection;

    public CommentDao(Connection connection) {
        this.connection = connection;
    }

    public void addComment(Comment comment) {
        String query = "INSERT INTO comment (task_id, author_id, content, timestamp) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, comment.getTask_id());
            statement.setInt(2, comment.getAuthor_id());
            statement.setString(3, comment.getContent());
            statement.setString(4, comment.getTimestamp());
            statement.executeUpdate();
            System.out.println("Comment with content \"" + comment.getContent() + "\" added to table comment");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
