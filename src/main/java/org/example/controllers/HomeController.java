package org.example.controllers;

import org.example.models.FacultyDTO;
import org.example.repositories.Faculty.Faculty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home-page")
    public String getHomePage(Model model) {
        List<FacultyDTO> khoaList = Faculty.hienthiKhoa();
        model.addAttribute("dskhoa", khoaList);  // Thêm dữ liệu vào model
            return "home-page";  // Trả về home-page.html
    }
}
