package org.example.dao;

import org.example.model.TaskColumnLink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskColumnLinkDao {
    private Connection connection;

    public TaskColumnLinkDao(Connection connection) {
        this.connection = connection;
    }

    public void addTaskColumnLink(TaskColumnLink taskColumnLink) {
        String query = "INSERT INTO taskcolumnlink (task_id, column_id) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, taskColumnLink.getTask_id());
            statement.setInt(2, taskColumnLink.getColumn_id());
            statement.executeUpdate();
            System.out.println("TaskColumnLink added to table \"taskcolumnlink\"");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
