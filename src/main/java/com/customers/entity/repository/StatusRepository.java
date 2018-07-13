package com.customers.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customers.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
