package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class FacultyPageController {
    @GetMapping("/Khoa/FacultyApi")
    public String showFacultyPage(Model model) {
        return "Khoa/FacultyApi";
    }

    @GetMapping("/Khoa/EditFaculty")
    public String editFaculty(Model model) {
        return "Khoa/EditFaculty";
    }
    @GetMapping("/Khoa/AddFaculty")
    public String addFaculty(Model model) {
        return "Khoa/AddFaculty";
    }
}
