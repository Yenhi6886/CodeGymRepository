package com.codegym.customerrepository.repository;

import com.codegym.customerrepository.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends CrudRepository<Province, Long> {
}