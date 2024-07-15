package com.StudentManagementSystem;


import java.sql.*;

public class StudentManagementServices {
    private Connection connection;

    public StudentManagementServices() {
        try {
            String url = "jdbc:mysql://localhost:3306/student_management";
            String user = "root"; //;
            String password = "4549";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public int addStudent(Student student) {
        String query = "INSERT INTO students (studentName, branchName, phoneNumber) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getBranchName());
            preparedStatement.setString(3, student.getPhoneNumber());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int rollNo = generatedKeys.getInt(1);
                student.setRollNo(rollNo);
                return rollNo;
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return -1;
    }


    public boolean updateStudent(int rollNo, String phoneNumber) {
        String query = "UPDATE students SET phoneNumber= ? WHERE rollNo = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, String.valueOf(rollNo));
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Connnection failed: " + e.getLocalizedMessage());
        }
        return false;
    }

    public Student findStudent(int rollNo) {
        String query = "SELECT * FROM students WHERE rollNo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, rollNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("studentName");
                String branchName = resultSet.getString("branchName");
                String phoneNumber = resultSet.getString("phoneNumber");
                Student student = new Student(name, branchName, phoneNumber);
                student.setRollNo(rollNo);
                return student;
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }

        return null;

    }

    public boolean removeStudent(int rollNo) {
        String query = "DELETE FROM  students Where rollNo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, rollNo);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;


        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public void displayAllStudent() {
        String query = "SELECT * FROM students";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.isBeforeFirst()) {
                System.out.println("no student in the system");
            } else {
                while (resultSet.next()) {
                    int rollNo = resultSet.getInt("rollNo");
                    String name = resultSet.getString("studentName");
                    String branchName = resultSet.getString("branchName");
                    String phoneNumber = resultSet.getString("phoneNumber");

                    Student student = new Student(name, branchName, phoneNumber);
                    student.setRollNo(rollNo);
                    System.out.println(student.toString());
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());

        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database Connection closed");
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
