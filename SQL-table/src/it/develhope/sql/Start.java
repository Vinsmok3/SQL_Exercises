package it.develhope.sql;

import java.sql.*;
import java.util.ArrayList;

public class Start {


    public static void main(String[] args) throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "password";
            Connection connection;
            connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();

            //Create TABLE
            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " first_name VARCHAR(30), " +
                    " last_name VARCHAR(30))";
            stmt.executeUpdate(sql);
            System.out.println("Tabella creata con successo!");


            //ADD Names/Surname to Students
            String countSql = "SELECT COUNT(*) FROM student";
            ResultSet countRs = stmt.executeQuery(countSql);
            countRs.next();
            int count = countRs.getInt(1);
            if (count < 4) {
                String insertSql = "INSERT INTO student (first_name, last_name) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
                String[][] students = {{"Paolo", "Cann"}, {"Marco", "Rossi"}, {"Giovanni", "Bianchi"}, {"Luca", "Verde"}};
                for (String[] student : students) {
                    preparedStatement.setString(1, student[0]);
                    preparedStatement.setString(2, student[1]);
                    preparedStatement.executeUpdate();
                    System.out.println("Inserito studente: " + student[0] + " " + student[1]);
                }
            } else {
                System.out.println("La tabella student contiene già 4 studenti, quindi non vengono inseriti ulteriori dati.");
            }

            //Query ADD country
            String checkColumnSql = "SHOW COLUMNS FROM student LIKE 'country'";
            ResultSet rsCheck = stmt.executeQuery(checkColumnSql);
            if (!rsCheck.next()) {
                String addColumnSql = "ALTER TABLE student ADD COLUMN country VARCHAR(30)";
                stmt.executeUpdate(addColumnSql);
                System.out.println("Colonna aggiunta con successo!");
            } else {
                System.out.println("La colonna country esiste già.");
            }

            ArrayList<String> surnames = new ArrayList<>();
            String selectSql = "SELECT student_id, first_name, last_name, country FROM student";
            ResultSet rs = stmt.executeQuery(selectSql);

            //Query SET country
            String updateSql = "UPDATE student SET country = ? WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            String[] countries = {"Italy", "Italy", "Germany", "Germany"};
            int[] studentIds = {1, 2, 3, 4};
            for (int i = 0; i < 4; i++) {
                preparedStatement.setString(1, countries[i]);
                preparedStatement.setInt(2, studentIds[i]);
                preparedStatement.executeUpdate();
            }

            //Print All DATA
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String country = rs.getString("country");
                System.out.println("Student ID: " + studentId + ", Name: " + firstName + ", Surname: " + lastName + ", Country: " + country);
                surnames.add(rs.getString("last_name"));
            }
            System.out.println(surnames);

            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

