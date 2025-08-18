package vn.codegym.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.jpa.model.Customer;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
//    List<Customer> findAll();
//
//    List<Customer> findByName(String name);
}
