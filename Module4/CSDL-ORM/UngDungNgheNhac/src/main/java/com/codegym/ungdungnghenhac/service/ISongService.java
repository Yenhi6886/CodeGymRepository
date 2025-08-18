package com.codegym.ungdungnghenhac.service;

import com.codegym.ungdungnghenhac.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    void save(Song song);
    void remove(Long id);
}
