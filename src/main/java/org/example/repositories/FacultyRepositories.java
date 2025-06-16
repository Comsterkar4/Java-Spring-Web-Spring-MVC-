package org.example.repositories;

import org.example.Database;
import org.example.models.FacultyDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyRepositories {
    public static List<FacultyDTO> hienthiKhoa() {
        List<FacultyDTO> khoaList = new ArrayList<>();
        String sql = "SELECT * FROM Faculty";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                FacultyDTO faculty = new FacultyDTO(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("code"),
                        rs.getString("created_at")
                );
                khoaList.add(faculty);
            }
        } catch (SQLException e) {
            // Sử dụng logging framework thay vì System.out.println
            throw new RuntimeException("Lỗi khi lấy danh sách khoa: " + e.getMessage(), e);
        }

        return khoaList;
    }
    // Tính năng Thêm Khoa
    public static boolean themKhoa(FacultyDTO faculty) {
        String sql = "INSERT INTO Faculty(name, code, created_at) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, faculty.getName());
            stmt.setString(2, faculty.getCode());
            stmt.setString(3, faculty.getCreatedAt());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc dùng Logger
            return false;
        }
    }
    // Tính năng sửa
    public static FacultyDTO getFacultyById(long id) {
        String sql = "SELECT * FROM Faculty WHERE id = " + id;
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return new FacultyDTO(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("code"),
                        rs.getString("created_at")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi lấy khoa theo ID: " + e.getMessage(), e);
        }
        return null;
    }
    public static void updateFaculty(FacultyDTO faculty) {
        String sql = "UPDATE Faculty SET name = ?, code = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, faculty.getName());
            stmt.setString(2, faculty.getCode());
            stmt.setLong(3, faculty.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi cập nhật khoa: " + e.getMessage(), e);
        }
    }
    // xóa khó
    public static void xoaKhoaTheoId(long id) {
        String sql = "DELETE FROM Faculty WHERE id = " + id;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi xoá khoa: " + e.getMessage(), e);
        }
    }

}