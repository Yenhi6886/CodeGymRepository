package com.codegym.filesong.controller;

import com.codegym.filesong.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SongController {
    private List<Song> songList = new ArrayList<>();

    @GetMapping("/upload")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute Song song,
                         @RequestParam("file") MultipartFile file,
                         HttpServletRequest request,
                         Model model) throws IOException {

        String[] allowedExt = {".mp3", ".wav", ".ogg", ".m4p"};
        String fileName = file.getOriginalFilename();

        boolean isValid = Arrays.stream(allowedExt).anyMatch(fileName::endsWith);
        if (!isValid) {
            model.addAttribute("error", "File không hợp lệ! Chỉ cho phép .mp3, .wav, .ogg, .m4p");
            return "upload";
        }

        // Lưu file
        String uploadPath = request.getServletContext().getRealPath("/songs/");
        File uploaded = new File(uploadPath, fileName);
        file.transferTo(uploaded);

        song.setFilePath("/songs/" + fileName);
        songList.add(song);
        return "redirect:/songs";
    }

    @GetMapping("/songs")
    public String showSongs(Model model) {
        model.addAttribute("songs", songList);
        return "list";
    }
}
