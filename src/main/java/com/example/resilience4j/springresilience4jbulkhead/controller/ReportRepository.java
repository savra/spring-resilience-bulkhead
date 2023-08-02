package com.example.resilience4j.springresilience4jbulkhead.controller;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Long> {
    @Modifying
    @Query(value = "update test set id = 2 where id = 1", nativeQuery = true)
    void test();
}