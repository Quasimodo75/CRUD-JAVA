package org.example;

import javax.naming.Name;
import java.sql.*;
public class CrudFunc {

    private static final String URL = "jdbc:postgresql://localhost:5432/CRUD";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Letsdoit";

    public static void main(String[] args) {


    }

    // Update Function
    public static void updateTaskById(int id, String Name) {
        String sql = "UPDATE CRUD SET Name = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, Name);
            preparedStatement.setInt(2, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Task updated successfully.");
            } else {
                System.out.println("No record found with the given id.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    // Add Function
    public static void addTask(int id, String Name) {
        String sql = "INSERT INTO CRUD (id, Name) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            preparedStatement.setString(2, Name);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Task added successfully.");
            } else {
                System.out.println("Failed to add task.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

//DeleteTask

    public static void deleteTask(int id) {
        String sql = "DELETE FROM CRUD WHERE id = ?";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("Task deleted successfully.");
            }else{
                System.out.println("Failed to delete task.");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read All Tasks Function
    public static void readTask() {
        String sql = "SELECT * FROM CRUD";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("Name");
                System.out.println("Task ID: " + id);
                System.out.println("Task: " + Name);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

}