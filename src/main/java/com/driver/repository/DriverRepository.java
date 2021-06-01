package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

}
