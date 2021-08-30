package com.practice.springpractice.repository;

import com.practice.springpractice.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Domain, Long> {
}
