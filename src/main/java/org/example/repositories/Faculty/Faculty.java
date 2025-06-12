package org.example.repositories.Faculty;

import org.example.Database;
import org.example.models.FacultyDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Faculty {

    public static List<FacultyDTO> hienthiKhoa() {
        List<FacultyDTO> khoaList = new ArrayList<>();
        Connection conn = Database.getConnection();

        if (conn != null) {
            System.out.println("Kết nối thành công đến CSDL");
        }

        String sql = "SELECT * FROM Faculty";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Danh sách khoa:");

            while (rs.next()) {
                long id = rs.getInt("id");
                String name = rs.getString("name");
                String code = rs.getString("code");
                String createdAt = rs.getString("created_at");

                System.out.println("Lấy dữ liệu thành công");

                FacultyDTO faculty = new FacultyDTO(id, name, code, createdAt);
                khoaList.add(faculty);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách khoa: " + e.getMessage());
        }

        return khoaList;
    }

    public static void main(String[] args) {
        List<FacultyDTO> dsKhoa = hienthiKhoa();
        dsKhoa.forEach(System.out::println);
    }
}
