package test;

import java.sql.*;
import java.util.List;

public class DatabaseHandler {
    private Connection connection;
    public DatabaseHandler() {
        connect();
    }
    private void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:prometey.db");
            System.out.println("Подключение к базе данных успешно.");
            createTable();
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS records (" +
                "id TEXT PRIMARY KEY," +
                "fio TEXT NOT NULL," +
                "city TEXT NOT NULL," +
                "street TEXT NOT NULL," +
                "number TEXT NOT NULL," +
                "date TEXT NOT NULL," +
                "additional_info TEXT" +
                ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица records успешно создана или уже существует.");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблицы: " + e.getMessage());
        }
    }
    public void addOrUpdateRecord(String id, String fio, String city, String street, String number, List<String> additionalInfo, String date) {
        String additionalInfoStr = String.join(", ", additionalInfo);
        try {
            String sql = "INSERT INTO records (id, fio, city, street, number, date, additional_info) " + // Переместили "date" перед "additional_info"
                    "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                    "ON CONFLICT(id) DO UPDATE SET fio = excluded.fio, city = excluded.city, " +
                    "street = excluded.street, number = excluded.number, date = excluded.date, " + // Переместили "date"
                    "additional_info = excluded.additional_info;";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, fio);
            pstmt.setString(3, city);
            pstmt.setString(4, street);
            pstmt.setString(5, number);
            pstmt.setString(6, date); // Переместили "date"
            pstmt.setString(7, additionalInfoStr); // Переместили "additional_info"
            pstmt.executeUpdate();
            System.out.println("Запись успешно добавлена или обновлена.");
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении или обновлении записи: " + e.getMessage());
        }
    }
    public void printAllRecords() {
        String sql = "SELECT * FROM records";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nЗаписи в таблице:");
            System.out.printf("%-10s | %-20s | %-10s | %-20s | %-10s | %-10s | %-30s%n", "ID", "ФИО", "Город", "Улица", "Номер", "Дата", "Дополнительные сведения");
            System.out.println("----------------------------------------------------------------------------------------------");
            while (rs.next()) {
                String id = rs.getString("id");
                String fio = rs.getString("fio");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String number = rs.getString("number");
                String date = rs.getString("date");
                String additionalInfo = rs.getString("additional_info");
                System.out.printf("%-10s | %-20s | %-10s | %-20s | %-10s | %-10s | %-30s%n", id, fio, city, street, number, date, additionalInfo);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при извлечении записей: " + e.getMessage());
        }
    }
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение с базой данных закрыто.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
        }
    }
}
