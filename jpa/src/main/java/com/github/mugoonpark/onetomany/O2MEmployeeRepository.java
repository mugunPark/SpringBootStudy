package com.github.mugoonpark.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface O2MEmployeeRepository extends JpaRepository<O2MEmployee, Integer> {
}
