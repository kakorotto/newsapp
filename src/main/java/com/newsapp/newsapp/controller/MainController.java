package com.newsapp.newsapp.controller;

//import java.util.Arrays;
//import java.util.List;

import com.newsapp.newsapp.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {

    @Autowired
    FileService fileService;

    private String loc;

    @GetMapping("/news")
    public String showForm(Model model) {
        News news = new News();
        model.addAttribute("news", news);
        return "admin";
    }

    @PostMapping("/user")
    public String submitForm(@ModelAttribute("news") News news,@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        fileService.uploadFile(file);
        news.setImageLocation(fileService.getCopyLocation());
        System.out.println(news);
        return "/user";
    }

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        News news = new News();
        model.addAttribute("news", news);
        news.setImageLocation(loc);
        System.out.println(news.getDescription());
        System.out.println(news.getImageLocation());

        return "/admin";
    }


    @GetMapping("/about")
    public String about(Model model) {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
