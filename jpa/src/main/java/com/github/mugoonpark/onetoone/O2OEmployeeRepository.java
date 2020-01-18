package com.github.mugoonpark.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface O2OEmployeeRepository extends JpaRepository<O2OEmployee, Integer> {
}
