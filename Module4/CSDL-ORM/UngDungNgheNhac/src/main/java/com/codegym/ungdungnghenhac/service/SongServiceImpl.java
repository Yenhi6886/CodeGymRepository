package com.codegym.ungdungnghenhac.service;

import com.codegym.ungdungnghenhac.model.Song;
import com.codegym.ungdungnghenhac.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongServiceImpl implements ISongService {

    @Override
    public List<Song> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Song> songs = session.createQuery("from Song", Song.class).list();
        session.close();
        return songs;
    }

    @Override
    public Song findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Song song = session.get(Song.class, id);
        session.close();
        return song;
    }

    @Override
    public void save(Song song) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(song);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Song song = session.get(Song.class, id);
            if (song != null) {
                session.delete(song);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
