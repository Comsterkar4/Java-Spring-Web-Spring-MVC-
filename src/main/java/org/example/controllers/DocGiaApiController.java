package org.example.controllers;

import org.example.models.FacultyDTO;
import org.example.repositories.Faculty.Faculty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
    @RequestMapping("/api/khoa")
public class DocGiaApiController {

    @GetMapping
    public List<FacultyDTO> getAllDocGia() {
        return Faculty.hienthiKhoa();
    }
}
