package com.cisco.clinic.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.clinic.model.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
