package vn.codegym.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.jpa.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    public List<Customer> findByName(String name) {
        TypedQuery<Customer> query = entityManager.createNamedQuery("findAllCustomersWithName", Customer.class);
        query.setParameter("custName", "%" + name + "%");
        return query.getResultList();
    }

    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    public void delete(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}

