package org.example.controllers;

import org.example.models.FacultyDTO;
import org.example.repositories.FacultyRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/khoa")
public class FacultyApiController {
    @GetMapping
    public List<FacultyDTO> getAllFaculties() {
        return FacultyRepositories.hienthiKhoa();
    }
    // Post ( ud )
    @PostMapping
    public ResponseEntity<String> addFaculty(@RequestBody FacultyDTO faculty) {
        if (faculty.getName() == null || faculty.getCode() == null) {
            return ResponseEntity.badRequest().body("Tên khoa và Mã khoa không được để trống.");
        }
        boolean added = FacultyRepositories.themKhoa(faculty);
        if (added) {
            return ResponseEntity.ok("Thêm khoa thành công");
        } else {
            return ResponseEntity.status(500).body("Lỗi khi thêm khoa.");
        }
    }

    // xu ly lay id

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> getFacultyById(@PathVariable long id) {
        FacultyDTO faculty = org.example.repositories.FacultyRepositories.getFacultyById(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFaculty(@PathVariable long id, @RequestBody FacultyDTO faculty) {
        FacultyDTO existing = org.example.repositories.FacultyRepositories.getFacultyById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        // Cập nhật dữ liệu
        existing.setName(faculty.getName());
        existing.setCode(faculty.getCode());
        org.example.repositories.FacultyRepositories.updateFaculty(existing);
        return ResponseEntity.ok("Cập nhật thành công");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateFaculty(@PathVariable long id){
         FacultyDTO existing = FacultyRepositories.getFacultyById(id);
         if (existing == null){
             return  ResponseEntity.notFound().build();
         }
         FacultyRepositories.xoaKhoaTheoId(id);
         return  ResponseEntity.ok(" xoa thanh cong");
    }
}