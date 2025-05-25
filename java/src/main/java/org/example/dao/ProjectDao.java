package org.example.dao;

import org.example.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDao {
    private Connection connection;

    public ProjectDao(Connection connection) {
        this.connection = connection;
    }

    public void addProject(Project project) {
        String query = "INSERT INTO project (title, description, owner_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, project.getTitle());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getOwner_id());
            statement.executeUpdate();
            System.out.println("Project with title \"" + project.getTitle() + "\" added to table project");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project getProjectByOwner(int owner_id) {
        String query = "SELECT * FROM project WHERE owner_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, owner_id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Project project = new Project();
                    project.setId(resultSet.getInt("id"));
                    project.setTitle(resultSet.getString("title"));
                    project.setDescription(resultSet.getString("description"));
                    project.setOwner_id(resultSet.getInt("owner_id"));
                    return project;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
