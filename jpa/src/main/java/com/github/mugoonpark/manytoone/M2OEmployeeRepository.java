package com.github.mugoonpark.manytoone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface M2OEmployeeRepository extends JpaRepository<M2OEmployee, Integer> {
}
