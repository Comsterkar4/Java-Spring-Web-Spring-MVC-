package org.example.controllers.Login;

import org.example.models.FacultyDTO;
import org.example.repositories.FacultyRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Login {

    @GetMapping("/Khoa/")
    public String getHomePage(Model model) {
        List<FacultyDTO> khoaList = FacultyRepositories.hienthiKhoa();
        model.addAttribute("dskhoa", khoaList);
        return "Khoa/";
    }

}
