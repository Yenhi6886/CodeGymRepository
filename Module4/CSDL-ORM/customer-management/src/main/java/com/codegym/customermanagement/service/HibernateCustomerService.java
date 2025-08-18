package com.codegym.customermanagement.service;

import com.codegym.customermanagement.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateCustomerService implements ICustomerService {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Failed to create sessionFactory: " + e.getMessage());
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Customer", Customer.class).list();
        } catch (Exception e) {
            System.err.println("Error in findAll: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve customers", e);
        }
    }

    @Override
    public void save(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            if (customer.getId() == 0) {
                session.save(customer);
            } else {
                session.update(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error in save: " + e.getMessage());
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save customer", e);
        }
    }

    @Override
    public Customer findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, id);
        } catch (Exception e) {
            System.err.println("Error in findById: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to find customer by id", e);
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            if (customer != null) {
                session.delete(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error in remove: " + e.getMessage());
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to remove customer", e);
        }
    }
}