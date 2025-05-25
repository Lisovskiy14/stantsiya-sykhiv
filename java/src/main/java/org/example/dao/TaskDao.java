package org.example.dao;

import org.example.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDao {
    private Connection connection;

    public TaskDao(Connection connection) {
        this.connection = connection;
    }

    public void addTask(Task task) {
        String query = "INSERT INTO task (title, description, start_date, end_date, status, project_id, assignee_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getStart_date());
            statement.setString(4, task.getEnd_date());
            statement.setString(5, task.getStatus());
            statement.setInt(6, task.getProject_id());
            statement.setInt(7, task.getAssignee_id());
            statement.executeUpdate();
            System.out.println("Task with title \"" + task.getTitle() + "\" added to table task");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
