package com.github.mugoonpark.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface M2MMeetingRepository extends JpaRepository<M2MMeeting, Integer> {
}
