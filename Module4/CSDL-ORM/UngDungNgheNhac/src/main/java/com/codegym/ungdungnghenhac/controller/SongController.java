package com.codegym.ungdungnghenhac.controller;

import com.codegym.ungdungnghenhac.model.Song;
import com.codegym.ungdungnghenhac.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Song song,
                       @RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                song.setFilePath(fileName);

                String uploadPath = new File("D:/CodeGym/CodeGymRepository/Module4/CSDL-ORM/UngDungNgheNhac/upload").getAbsolutePath();
                File uploadDirFile = new File(uploadPath);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }

                Path path = Paths.get(uploadPath + File.separator + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        songService.save(song);
        return "redirect:/songs";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        songService.remove(id);
        return "redirect:/songs";
    }

    @GetMapping("/play/{id}")
    public String play(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "play";
    }
}
