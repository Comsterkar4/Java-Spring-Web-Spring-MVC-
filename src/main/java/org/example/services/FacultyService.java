package org.example.services;

import org.example.models.FacultyDTO;
import org.example.repositories.FacultyRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    public List<FacultyDTO> getAllFaculties() {
        return FacultyRepositories.hienthiKhoa(); // Gọi repository để lấy danh sách
    }

    public boolean addFaculty(FacultyDTO faculty) {
        return org.example.repositories.FacultyRepositories.themKhoa(faculty);
    }

    public void updateFaculty(FacultyDTO faculty) {
        org.example.repositories.FacultyRepositories.updateFaculty(faculty);
    }

    public void deleteFaculty(long id) {
        org.example.repositories.FacultyRepositories.xoaKhoaTheoId(id);
    }

    public FacultyDTO getById(long id) {
        return org.example.repositories.FacultyRepositories.getFacultyById(id);
    }
}
