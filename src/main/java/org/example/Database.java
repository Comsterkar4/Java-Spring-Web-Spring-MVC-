package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "nlviet";
    private static final String PASSWORD = "270604";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối database: " + e.getMessage());
            return null;
        }
    }
    // phương thức để có thể chạy độc lập riêng file
    public static void main(String[] args){
        Connection conn = Database.getConnection();
    }
}
