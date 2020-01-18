package com.github.mugoonpark.common;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultCustomerRepository extends JpaRepository<DefaultCustomer, String> {
}
