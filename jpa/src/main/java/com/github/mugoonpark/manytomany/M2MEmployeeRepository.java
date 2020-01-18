package com.github.mugoonpark.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface M2MEmployeeRepository extends JpaRepository<M2MEmployee, Integer> {
}
