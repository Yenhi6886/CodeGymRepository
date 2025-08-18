package com.codegym.customer.repository;

import com.codegym.customer.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean saveWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() !=0;
    }
}
